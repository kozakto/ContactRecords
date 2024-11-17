package com.contactrecords.service;

import com.contactrecords.dto.WrapperPerson;
import com.contactrecords.exceptions.NoValueException;
import com.contactrecords.model.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

public class XMLConverterService {

    public void convertObjectToXML(String fileName, WrapperPerson wrapperPerson) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(WrapperPerson.class);
        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(wrapperPerson, System.out);
        m.marshal(wrapperPerson, new File(fileName));
    }

    /**
     * Converts XML and returns list of people
     * @param fileName
     * @return List of people
     * @throws JAXBException
     * @throws NoValueException
     */
    public List<Person> convertObjectFromXML(String fileName) throws JAXBException, NoValueException {
        try {
            File xmlFile = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(WrapperPerson.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            WrapperPerson data = (WrapperPerson) jaxbUnmarshaller.unmarshal(xmlFile);

            List<Person> personsXML = data.getPersonList();

            // check if any value is missing in XML
            for (Person person : personsXML) {
                if (person.getFirstName() == null || person.getLastName() == null ||
                        person.getAddress() == null || person.getPhoneNumber() == null) {
                    throw new NoValueException("Missing or wrong value in XML");
                }
            }
            return personsXML;

        } catch (JAXBException e) {
            System.err.println("XML parsing error: " + e.getMessage());
            throw e;
        }
    }


    //Loads existing person records from the specified XML file.
    public WrapperPerson loadPersonsFromXML(String fileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(WrapperPerson.class);
        Unmarshaller um = jaxbContext.createUnmarshaller();

        File xmlFile = new File(fileName);
        if (xmlFile.exists()) {
            return (WrapperPerson) um.unmarshal(xmlFile);
        } else {
            return new WrapperPerson();
        }
    }

}

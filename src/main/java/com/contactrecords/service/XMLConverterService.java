package com.contactrecords.service;

import com.contactrecords.dto.WrapperPerson;
import com.contactrecords.model.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XMLConverterService {

    public void convertObjectToXML(String fileName, WrapperPerson wrapperPerson) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(WrapperPerson.class);
        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(wrapperPerson, System.out);
        m.marshal(wrapperPerson, new File(fileName));
    }

    public void convertObjectFromXML(String fileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(WrapperPerson.class);
        Unmarshaller um = jaxbContext.createUnmarshaller();
        WrapperPerson wp = (WrapperPerson) um.unmarshal(new File(fileName));

        if (wp != null && wp.getPersonLists() != null) {
            for (Person p : wp.getPersonLists()) {
                System.out.println("Person Info");
                System.out.println("First name: " + p.getFirstName());
                System.out.println("Last name: " + p.getLastName());
                System.out.println("Address: " + p.getAddress());
                System.out.println("Phone number: " + p.getPhoneNumber());
            }
        } else {
            System.out.println("No person data found.");
        }


    }

    public WrapperPerson loadPersonsFromXML() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(WrapperPerson.class);
        Unmarshaller um = jaxbContext.createUnmarshaller();

        File xmlFile = new File("people.xml");
        if (xmlFile.exists()) {
            return (WrapperPerson) um.unmarshal(xmlFile);
        } else {
            return new WrapperPerson();
        }
    }

}

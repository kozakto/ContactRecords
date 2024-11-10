package com.contactrecords.service;

import com.contactrecords.dto.WrapperPerson;
import com.contactrecords.model.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLConverterService {

    public void convertObjectToXML(String fileName, WrapperPerson wrapperPerson) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(WrapperPerson.class);
        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(wrapperPerson, System.out);
        m.marshal(wrapperPerson, new File(fileName));
    }

    public List<Person> convertObjectFromXML(String fileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(WrapperPerson.class);
        Unmarshaller um = jaxbContext.createUnmarshaller();

        File xmlFile = new File(fileName);
        if (xmlFile.exists()) {
            WrapperPerson wrapperPerson = (WrapperPerson) um.unmarshal(xmlFile);
            return wrapperPerson.getPersonList();
        } else {
            return new ArrayList<>();
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

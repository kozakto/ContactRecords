package com.contactrecords.app;

import com.contactrecords.model.*;
import com.contactrecords.service.ContactManagement;
import com.contactrecords.dto.WrapperPerson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void convertObjectToXML(WrapperPerson wrapperPerson) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(WrapperPerson.class);
        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(wrapperPerson, System.out);
        m.marshal(wrapperPerson, new File("people.xml"));
    }

    public static void main(String[] args) throws JAXBException {

        Scanner scanner = new Scanner(System.in);
        ContactManagement cm = new ContactManagement();
        WrapperPerson wrapperPerson = new WrapperPerson();
        List<Person> personList = new ArrayList<>();
        while (true) {
            System.out.println("Do you want to add a new contact? (1 - yes/ 0 - no)");
            String userInput = scanner.nextLine();

            if (userInput.equals("0")) {
                break;
            }

            Person newPerson = new Person();
            newPerson.createPerson(scanner);

            cm.addContact(newPerson);
            personList.add(newPerson);
        }

        System.out.println("Do you want to export list of People to XML? (1 - yes / 0 - no)");
        String export = scanner.nextLine().trim();
        if (export.equals("1")) {
            wrapperPerson.setPersonList(personList);
            convertObjectToXML(wrapperPerson);
        } else {
            System.out.println("Do you want to find any contact? (1 - yes / 0 - no)");
            String searchApprove = scanner.nextLine().trim();
            if (searchApprove.equals("1")) {
                System.out.println("Insert value.");
                String searchValue = scanner.nextLine().trim();
                cm.searchByPrefix(searchValue);
            } else {
                cm.getContacts();
            }
        }
    }
}




package com.contactrecords.app;

import com.contactrecords.dto.WrapperPerson;
import com.contactrecords.model.Person;
import com.contactrecords.service.ContactManagementService;
import com.contactrecords.service.XMLConverterService;
import jakarta.xml.bind.JAXBException;

import java.util.List;
import java.util.Scanner;



public class Main {
    public static final String VALUE_TRUE = "1";
    public static final String VALUE_FALSE = "0";

    private static final String XML_FILE_NAME = "people.xml";
    public static void main(String[] args) throws JAXBException {

        Scanner scanner = new Scanner(System.in);
        XMLConverterService xmlConvert = new XMLConverterService();

        ContactManagementService cm = new ContactManagementService();
        WrapperPerson wrapperPerson = xmlConvert.loadPersonsFromXML();
        List<Person> personList = wrapperPerson.getPersonLists();

        while (true) {
            System.out.println("Do you want to add a new contact? (1 - yes/ 0 - no)");
            String userInput = scanner.nextLine();

            if (userInput.equals(VALUE_FALSE)) {
                break;
            }

            Person newPerson = new Person();
            newPerson.createPerson(scanner);

            cm.addContact(newPerson);
            personList.add(newPerson);
        }

        System.out.println("Do you want to export list of People to XML? (1 - yes / 0 - no)");
        String export = scanner.nextLine().trim();
        if (export.equals(VALUE_TRUE)) {
            wrapperPerson.setPersonList(personList);
            //xmlConvert.loadPersonsFromXML();
            xmlConvert.convertObjectToXML(XML_FILE_NAME, wrapperPerson);


        } else {
            System.out.println("Do you want to find any contact? (1 - yes / 0 - no)");
            String searchApprove = scanner.nextLine().trim();


            if (searchApprove.equals(VALUE_TRUE)) {
                System.out.println("Insert value.");
                String searchValue = scanner.nextLine().trim();
                cm.searchByPrefix(searchValue, wrapperPerson);
                //cm.getContacts(wrapperPerson);
            } else {
                cm.getContacts(wrapperPerson);
            }
        }
    }
}




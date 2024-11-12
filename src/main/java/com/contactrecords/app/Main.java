package com.contactrecords.app;

import com.contactrecords.dto.WrapperPerson;
import com.contactrecords.model.Person;
import com.contactrecords.service.CSVImportService;
import com.contactrecords.service.ContactManagementService;
import com.contactrecords.service.XMLConverterService;
import jakarta.xml.bind.JAXBException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static final String VALUE_TRUE = "1";
    public static final String VALUE_FALSE = "0";
    private static final String XML_FILE_NAME = "people.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        Scanner scanner = new Scanner(System.in);
        XMLConverterService xmlConvert = new XMLConverterService();

        ContactManagementService cms = new ContactManagementService();
        WrapperPerson wrapperPerson = xmlConvert.loadPersonsFromXML(XML_FILE_NAME);
        List<Person> personList = wrapperPerson.getPersonList();
        cms.initializeContacts(wrapperPerson);

        CSVImportService cis = new CSVImportService();
        String directoryPath = "src/main/resources";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();


        while (true) {
            System.out.println("Do you want to add a new contact? (1 - yes/ 0 - no)");
            String userInput = scanner.nextLine();

            if (userInput.equals(VALUE_FALSE)) {
                break;
            }

            Person newPerson = new Person();
            newPerson.createPerson(scanner);

            cms.addContact(newPerson);
            personList.add(newPerson);
        }

        System.out.println("Do you want to export list of People to XML? (1 - yes / 0 - no)");
        String export = scanner.nextLine().trim();
        if (export.equals(VALUE_TRUE)) {
            wrapperPerson.setPersonList(personList);

            xmlConvert.convertObjectToXML(XML_FILE_NAME, wrapperPerson);

        } else {
            System.out.println("Do you want to find any contact? (1 - yes / 0 - no)");
            String searchApprove = scanner.nextLine().trim();

            if (searchApprove.equals(VALUE_TRUE)) {
                System.out.println("Insert value.");
                String searchValue = scanner.nextLine().trim();
                cms.searchByPrefix(searchValue, wrapperPerson);
                System.out.println("List of all people: ");
                cms.getContacts(wrapperPerson);
            } else {
                cms.getContacts(wrapperPerson);
            }
        }

        System.out.println("Do you want to import contacts from csv files? (1 - yes / 0 - no)");
        String fileApprove = scanner.nextLine().trim();

        if (fileApprove.equals(VALUE_TRUE)) {
            try {
                if (files != null) {
                    for (File file : files) {
                        if (file.getName().endsWith(".csv")) {
                            List<Person> peopleFromCsv = cis.csvImport(file.getPath());

                            for (Person person : peopleFromCsv) {
                                if (!cms.isDuplicate(person)) {
                                    personList.add(person);
                                    cms.addContact(person);
                                } else {
                                    System.out.println("Contact is duplicate: " + person.getFirstName() + " " + person.getLastName());
                                }
                            }
                        }
                    }
                    wrapperPerson.setPersonList(personList);
                    xmlConvert.convertObjectToXML(XML_FILE_NAME, wrapperPerson);
                } else {
                    System.out.println("No files in directory.");
                }

            } catch (JAXBException | IOException e) {
                e.getMessage();
            }
        }else {
            System.out.println("Program ends");
        }

        /*System.out.println("Do you want to import contacts from xml file? (1 - yes / 0 - no)");
        String fileApprove = scanner.nextLine().trim();

        if (fileApprove.equals(VALUE_TRUE)) {
            System.out.println("Insert path to the file (src/main/resources/importPeople1.xml)");
            String userPath = scanner.nextLine().trim();

            List<Person> personsFromXML = xmlConvert.convertObjectFromXML(userPath);

            for (Person person : personsFromXML) {
                personList.add(person);
            }

            wrapperPerson.setPersonList(personList);
            xmlConvert.convertObjectToXML(XML_FILE_NAME, wrapperPerson);
        } else {
            System.out.println("Program ends");
        }*/
    }
}




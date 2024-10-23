package main.java.com.contactrecords.app;

import main.java.com.contactrecords.model.*;
import main.java.com.contactrecords.service.ContactManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManagement cm = new ContactManagement();

        while (true) {
            System.out.println("Do you want to add a new contact? (1 - yes/ 0 - no)");
            String userInput= scanner.nextLine();

            if (userInput.equals("0")) {
                break;
            }

            Person newPerson = new Person();
            newPerson.personInfo(scanner);
            LegalEntity personCompany = new LegalEntity();
            personCompany.legalEntityInfo(scanner);

            List<Department> departments = new ArrayList<>();
            while (true) {
                System.out.println("Insert Name of the position in company (or 0 to stop): ");
                String companyPosition = scanner.nextLine();

                if (companyPosition.equals("0")) {
                    break;
                }

                Department unit = new Department(companyPosition);
                departments.add(unit);
            }

            PhoneCategory phoneCat = new PhoneCategory("Vodafone");
            Phone phone = new Phone("732 732 732", phoneCat);

            Relationship relationship = new Relationship(newPerson, personCompany, departments, phone, phoneCat);
            cm.addContact(newPerson);
            System.out.println(relationship);
        }

        cm.getContacts();
    }
}




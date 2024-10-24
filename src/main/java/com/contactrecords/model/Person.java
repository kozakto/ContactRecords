package com.contactrecords.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Scanner;

@XmlRootElement(name = "Person")
@XmlType(propOrder = {"title", "firstName", "lastName", "contactAddress"})
public class Person extends Contact {
    private String firstName;
    private String lastName;
    private String title;

    public Person() {
    }

    public Person(String firstName, String lastName, String title, String address) {
        super(address);
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }
        public void createPerson(Scanner scanner) {
            System.out.println("Insert Title of the Person: ");
            this.title = scanner.nextLine();

            System.out.println("Insert First Name of the Person: ");
            this.firstName = scanner.nextLine();

            System.out.println("Insert Last Name of the Person: ");
            this.lastName = scanner.nextLine();

            System.out.println("Insert Address of the Person: ");
            contactAddress = scanner.nextLine();
        }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @XmlElement(name = "address")
    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    @Override
    public String toString() {
        return title + " " + firstName + " " + lastName + ", Address: " + contactAddress;
    }
}

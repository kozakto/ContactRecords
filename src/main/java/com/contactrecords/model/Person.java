package com.contactrecords.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Scanner;

@XmlRootElement(name = "Person")
@XmlType(propOrder = {"firstName", "lastName", "address", "phoneNumber"})
public class Person extends Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    //private String title;

    public Person() {
    }

    public Person(String firstName, String lastName, String address, String phoneNumber) {
        super(address);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
        public void createPerson(Scanner scanner) {

            System.out.println("Insert First Name of the Person: ");
            this.firstName = scanner.nextLine();

            System.out.println("Insert Last Name of the Person: ");
            this.lastName = scanner.nextLine();

            System.out.println("Insert Address of the Person: ");
            address = scanner.nextLine();

            System.out.println("Insert Phone number of the Person: ");
            this.phoneNumber = scanner.nextLine();
        }
    @XmlElement(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @XmlElement(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @XmlElement(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @XmlElement(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "First name: " + getFirstName() + ", Last name: " + getLastName() + ", Address: " + getAddress() + ", Phone number: " + getPhoneNumber();
    }
}

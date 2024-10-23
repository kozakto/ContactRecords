package main.java.com.contactrecords.model;

import java.util.Scanner;

public class Person extends Contact {
    private String firstName;
    private String lastName;
    private String title;

    public Person() {
    }

    public void personInfo(Scanner scanner) {
        System.out.println("Insert Title of the Person: ");
        this.title = scanner.nextLine();

        System.out.println("Insert First Name of the Person: ");
        this.firstName = scanner.nextLine();

        System.out.println("Insert Last Name of the Person: ");
        this.lastName = scanner.nextLine();

        System.out.println("Insert Address of the Person: ");
        this.address = scanner.nextLine();
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

    @Override
    public String toString() {
        return title + " " + firstName + " " + lastName + ", Address: " + address;
    }
}

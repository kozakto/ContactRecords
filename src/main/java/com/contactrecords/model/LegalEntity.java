package main.java.com.contactrecords.model;

import java.util.Scanner;

public class LegalEntity extends Contact {
    private String name;

    public LegalEntity() {
    }

    public LegalEntity(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void legalEntityInfo(Scanner scanner) {
        System.out.println("Insert Name of the Company: ");
        this.name = scanner.nextLine();

        System.out.println("Insert Address of the Company: ");
        this.address = scanner.nextLine();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "company: " + name + ", Address: " + address;
    }
}
package com.contactrecords.model;

import java.util.Scanner;

public class LegalEntity extends Contact {
    private String name;

    public LegalEntity() {
    }

    public LegalEntity(String name, String address) {
        super(address);
        this.name = name;
    }

    public void legalEntityInfo(Scanner scanner) {
        System.out.println("Insert Name of the Company: ");
        this.name = scanner.nextLine();

        System.out.println("Insert Address of the Company: ");
        this.contactAddress = scanner.nextLine();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "company: " + name + ", Address: " + contactAddress;
    }
}
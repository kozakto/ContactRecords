package com.contactrecords.model;

import jakarta.xml.bind.annotation.XmlTransient;

import java.util.Scanner;

public class LegalEntity extends Contact {
    private String legalEntityName;

    public LegalEntity() {
    }

    public LegalEntity(String legalEntityName, String address) {
        super(address);
        this.legalEntityName = legalEntityName;
    }

    public void legalEntityInfo(Scanner scanner) {
        System.out.println("Insert Name of the Company: ");
        this.legalEntityName = scanner.nextLine();

        System.out.println("Insert Address of the Company: ");
        this.address = scanner.nextLine();
    }

    @XmlTransient
    public String getLegalEntityName() {
        return legalEntityName;
    }

    public void setLegalEntityName(String legalEntityName) {
        this.legalEntityName = legalEntityName;
    }

    @Override
    public String toString() {
        return "company: " + legalEntityName + ", Address: " + address;
    }
}
package com.contactrecords.model;

import jakarta.xml.bind.annotation.XmlTransient;

public class PhoneNumber {
    private String type;
    @XmlTransient
    private String phoneNumber;

    public PhoneNumber(String type, String phoneNumber) {
        this.type = type;
        this.phoneNumber = phoneNumber;
    }
}

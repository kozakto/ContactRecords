package com.contactrecords.model;

import jakarta.xml.bind.annotation.XmlTransient;

abstract public class Contact {
    @XmlTransient
    public String contactAddress;

    public Contact() {
    }

    public Contact(String address) {
        this.contactAddress = address;
    }

    public String getAddress() {
        return contactAddress;
    }

    public void setAddress(String address) {
        this.contactAddress = address;
    }
}
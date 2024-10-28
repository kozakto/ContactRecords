package com.contactrecords.model;

import jakarta.xml.bind.annotation.XmlTransient;

abstract public class Contact {
    @XmlTransient
    public String address;

    public Contact() {
    }

    public Contact(String address) {
        this.address = address;
    }

    @XmlTransient
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
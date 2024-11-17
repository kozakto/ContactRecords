package com.contactrecords.service;

import com.contactrecords.dto.WrapperPerson;
import com.contactrecords.model.Contact;
import com.contactrecords.model.Person;
import jakarta.xml.bind.JAXBException;

import java.util.ArrayList;
import java.util.List;

public class ContactManagementService {
    private List<Contact> contacts;

    public ContactManagementService() {
        this.contacts = new ArrayList<>();
    }


    public List<Contact> getContacts(WrapperPerson wrapperPerson) throws JAXBException {

        contacts.addAll(wrapperPerson.getPersonList());
        return contacts;
    }


    public void addContact(Contact newContact) {
        if (newContact != null && !isDuplicate(newContact)) {
            contacts.add(newContact);
        } else {
            System.out.println("Duplicate or null contact found. Contact not added.");
        }
    }

    public boolean isDuplicate(Contact newContact) {
        for (Contact existingContact : contacts) {
            if (newContact instanceof Person && existingContact instanceof Person) {
                Person newPerson = (Person) newContact;
                Person existingPerson = (Person) existingContact;
                return existingPerson.getFirstName().equals(newPerson.getFirstName()) &&
                        existingPerson.getLastName().equals(newPerson.getLastName()) &&
                        existingPerson.getAddress().equals(newPerson.getAddress());
            }
        }
        return false;
    }

    public void searchByPrefix(String prefix, WrapperPerson wrapperPerson) throws JAXBException {

        for (Contact contact : wrapperPerson.getPersonList()) {
            if (contact instanceof Person) {
                Person person = (Person) contact;
                if (person.getFirstName().startsWith(prefix) || person.getLastName().startsWith(prefix)) {
                    System.out.println(person);
                }
            }
        }
    }


}
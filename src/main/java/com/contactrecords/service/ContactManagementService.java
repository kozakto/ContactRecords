package com.contactrecords.service;

import com.contactrecords.dto.WrapperPerson;
import com.contactrecords.model.Contact;
import com.contactrecords.model.Person;
import jakarta.xml.bind.JAXBException;

import java.util.ArrayList;
import java.util.List;

public class ContactManagementService {
    private List<Contact> contacts = new ArrayList<>();

    public void initializeContacts(WrapperPerson wrapperPerson) {
        if (wrapperPerson != null && wrapperPerson.getPersonList() != null) {
            contacts.addAll(wrapperPerson.getPersonList());
        }
    }


    public List<Contact> getContacts(WrapperPerson wrapperPerson) throws JAXBException {
        List<Contact> contacts = new ArrayList<>();
        for (Contact contact : wrapperPerson.getPersonList()) {
            contacts.add(contact);
        }
        return contacts;
    }


    public void addContact(Contact newContact) {
        if (!isDuplicate(newContact)) {
            contacts.add(newContact);
        } else {
            System.out.println("Duplicate contact found. Contact not added.");
        }
    }

    public boolean isDuplicate(Contact newContact) {
        for (Contact existingContact : contacts) {
            if (newContact instanceof Person && existingContact instanceof Person) {
                Person newPerson = (Person) newContact;
                Person existingPerson = (Person) existingContact;
                if (existingPerson.getFirstName().equals(newPerson.getFirstName()) &&
                        existingPerson.getLastName().equals(newPerson.getLastName()) &&
                        existingPerson.getAddress().equals(newPerson.getAddress())) {
                    return true;
                }
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
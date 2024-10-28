package com.contactrecords.service;

import com.contactrecords.model.Contact;
import com.contactrecords.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ContactManagement {
    private List<Contact> contacts;

    public ContactManagement() {
        this.contacts = new ArrayList<>();
    }


    public List<Contact> getContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
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

    private boolean isDuplicate(Contact newContact) {
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


    /*public void searchByPrefix(String prefix) {
        for (Contact contact : contacts) {
            if (contact instanceof Person) {
                Person person = (Person) contact;
                if (person.getLastName().startsWith(prefix)) {
                    System.out.println(person);
                }
            } else if (contact instanceof LegalEntity) {
                LegalEntity entity = (LegalEntity) contact;
                if (entity.getLegalEntityName().startsWith(prefix)) {
                    System.out.println(entity);
                }
            }
        }
    }*/

    public void searchByPrefix(String prefix) {
        for (Contact contact : contacts) {
            if (contact instanceof Person) {
                Person person = (Person) contact;
                if (person.getFirstName().startsWith(prefix) || person.getLastName().startsWith(prefix)) {
                    System.out.println(person);
                }
            }
        }
    }


}
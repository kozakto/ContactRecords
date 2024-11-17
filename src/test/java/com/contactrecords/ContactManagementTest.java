package com.contactrecords;

import com.contactrecords.dto.WrapperPerson;
import com.contactrecords.model.Contact;
import com.contactrecords.model.Person;
import com.contactrecords.service.ContactManagementService;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ContactManagementTest {
    WrapperPerson wrapperPerson;
    ContactManagementService cms;

    @BeforeEach
    public void setUp() {
        cms = new ContactManagementService();
        wrapperPerson = new WrapperPerson();
    }

    @Test
    public void getContacts_methodTest() throws JAXBException {

        Person person1 = new Person("John", "Biden", "Florida", "123");
        Person person2 = new Person("Donald", "Trump", "Washington", "456");

        wrapperPerson.setPersonList(Arrays.asList(person1, person2));
        List<Contact> result = cms.getContacts(wrapperPerson);

        assertEquals(Arrays.asList(person1, person2), result);
    }

    @Test
    public void getContacts_shouldHandleEmptyList() throws JAXBException {
        List<Person> emptyContactList = new ArrayList<>();

        wrapperPerson.setPersonList(emptyContactList);
        List<Contact> result = cms.getContacts(wrapperPerson);

        assertTrue(result.isEmpty());
    }

    @Test
    public void getContacts_shouldHandleIncorrectValues() throws JAXBException {
        Person person1 = new Person("Láďa", "", "", "");
        Person person2 = new Person("Adam", "", "Praha", "");
        Person person3 = new Person(" ", " ", " , ", "");

        wrapperPerson.setPersonList(Arrays.asList(person3, person2, person1));
        List<Contact> result = cms.getContacts(wrapperPerson);

        assertEquals(Arrays.asList(person3, person2, person1), result);
    }

    @Test
    public void getContacts_shouldHandleLotsOfContacts() throws JAXBException {
        List<Person> lotsOfContacts = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            lotsOfContacts.add(new Person("First name: " + i, "Last name: " + i, "Address: " + i, "Phone number: " + i));
        }

        wrapperPerson.setPersonList(lotsOfContacts);
        List<Contact> result = cms.getContacts(wrapperPerson);

        assertEquals(1000, result.size());
    }

    @Test
    public void isDuplicate_shouldReturnTrue() throws JAXBException {
        Person p1 = new Person("Jan", "Kral", "Opava", "012");
        Person p2 = new Person("Jan", "Kral", "Opava", "012");

        cms.addContact(p1);
        boolean test = cms.isDuplicate(p2);

        assertTrue(test);
    }

    @Test
    public void isDuplicate_shouldReturnFalse() throws JAXBException {
        Person p1 = new Person("Jan", "Kral", "Opava", "012");
        Person p2 = new Person("Eva", "Eva", "Ostrava", "55");

        cms.addContact(p1);
        boolean test = cms.isDuplicate(p2);

        assertFalse(test);
    }

    @Test
    public void isDuplicate_shouldReturnFalseForEmptyValue() throws JAXBException {
        Person p1 = new Person("Jan", "Kral", "Opava", "012");

        assertFalse(cms.isDuplicate(p1));
    }

    @Test
    public void addContact_newContact() throws JAXBException {
        Person p1 = new Person("Jan", "Kral", "Opava", "012");
        cms.addContact(p1);

        WrapperPerson wrapperPerson = new WrapperPerson();
        List<Contact> contacts = cms.getContacts(wrapperPerson);

        assertTrue(contacts.contains(p1));
        assertEquals(1, contacts.size());
    }

    @Test
    public void addContact_emptyWrapperPerson() throws JAXBException {
        Person p1 = null;
        cms.addContact(p1);

        WrapperPerson wrapperPerson = new WrapperPerson();
        List<Contact> contacts = cms.getContacts(wrapperPerson);

        assertTrue(contacts.isEmpty());
    }


}



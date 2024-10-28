package com.contactrecords.dto;

import com.contactrecords.model.Person;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "entities")
public class WrapperPerson {
    @XmlElementWrapper(name = "personList")
    @XmlElement(name = "person")
    private List<Person> personList;

    public List<Person> getPersonLists() {
        return personList;
    }
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}

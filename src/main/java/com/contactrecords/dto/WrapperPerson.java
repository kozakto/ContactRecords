package com.contactrecords.dto;

import com.contactrecords.model.Person;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "entities")
public class WrapperPerson {
    private List<Person> personList = new ArrayList<>();

    @XmlElementWrapper(name = "personList")
    @XmlElement(name = "person")


    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}

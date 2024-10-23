package main.java.com.contactrecords.model;

import java.util.List;

public class Relationship {
    private Person person;
    private List<Department> units;
    private LegalEntity legalEntity;
    private Phone phone;
    private PhoneCategory phoneCategory;

    public Relationship(Person person, LegalEntity legalEntity, List<Department> units, Phone phone, PhoneCategory phoneCategory) {
        this.person = person;
        this.legalEntity = legalEntity;
        this.units = units;
        this.phone = phone;
        this.phoneCategory = phoneCategory;
    }

    public List<Department> getUnits() {
        return units;
    }

    public void setUnits(List<Department> units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return person + " working in " + legalEntity + " as " + units + " with  " + phone + " " + phoneCategory;
    }
}
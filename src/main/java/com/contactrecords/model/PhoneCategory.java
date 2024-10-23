package main.java.com.contactrecords.model;

public class PhoneCategory {
    private String name;

    public PhoneCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
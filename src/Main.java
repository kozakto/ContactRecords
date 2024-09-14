import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Creating a new person with address
        Person person1 = new Person("Ing","Jan", "Plha", "123 Opava");
        Person person2 = new Person("Ing","Jan", "Plha", "123 Opava");
        Person person3 = new Person("Ing","Adam", "Novák", "456 Opava");

        // Creating a company with address
        LegalEntity company = new LegalEntity("FFF", "123 Opava");

        // Creating a department
        Department unit1 = new Department("Technický ředitel");
        Department unit2 = new Department("Ředitel pražské pobočky");

        // Creating a phone
        PhoneCategory phoneCat = new PhoneCategory("Vodafone");
        Phone phone = new Phone("732 732 732", phoneCat);
        Relationship relationship = new Relationship(person1, company, Arrays.asList(unit1, unit2), phone, phoneCat);

        // Adding new contact to List and checking if it's unique
        ContactManagement cm = new ContactManagement();
        cm.addContact(person1);
        cm.addContact(person2);
        cm.addContact(person3);
        cm.getContacts();
        System.out.println(relationship);

        // Searching contact by prefix
        cm.searchByPrefix("Plh");
    }
}


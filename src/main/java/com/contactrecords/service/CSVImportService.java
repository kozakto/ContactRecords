package com.contactrecords.service;

import com.contactrecords.model.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVImportService {
    private static final ContactManagementService cms = new ContactManagementService();

    public List<Person> csvImport(String fileName) throws IOException {
        List<Person> people = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Person person = new Person();
                List<String> row = parseLine(line);

                if (row.size() == 4) {
                    person.setFirstName(row.get(0));
                    person.setLastName(row.get(1));
                    person.setAddress(row.get(2));
                    person.setPhoneNumber(row.get(3));
                    people.add(person);

                } else {
                    System.out.println("Wrong values in file");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    protected List<String> parseLine(String line) {
        List<String> result = new ArrayList<>();
        if (line != null) {
            for (String s : line.split(",")) {
                String trimmed = s.trim();
                result.add(trimmed);
            }
        }
        return result;
    }
}






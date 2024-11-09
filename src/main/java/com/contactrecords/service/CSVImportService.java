package com.contactrecords.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVImportService {

    /**
     * Tady jsem to malinko uravil ... neresil jsem co ta metoda dela, ale jen jsem ji upravil, aby byla testovatelna.
     * Jinak by tato metoda nemela nic vypisovat do konzole ... Zde to asi neni problem, protoze se jedna o ukazkovou aplikaci, ale normalne nema servisni trida pristup k uzivatelskemi interface ... napr. web page....
     * Takze by mela sprave vracet nejaky objekt, ktery se pak zobrazi uzivateli. .. Pripadne by mohla metoda ulozit data do DB atd...
     * @param file
     */
    public void csvImport(File file) {
        BufferedReader reader = null;
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                List<String> row = parseLine(line);
                System.out.println("Row: " + String.join(" ", row));
                System.out.println();
            }
        } catch (IOException e) {
            // log error
        }

//
//        try {
//            reader = new BufferedReader(new FileReader(file));
//            while ((line = reader.readLine()) != null) {
//
//                String[] row = line.split(",");
//
//                for (String i : row) {
//                    System.out.printf(i + " ");
//                }
//                System.out.println();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

    }

    /**
     * Parses a line of CSV data into a list of strings.
     * Metoda je trivialni a normalne by odbsahovala nejakou logiku ... treba by misto Stringu vracela rovnou POJO objekty.
     * Udelal jsem to jako ukazku metody, ktera je dobre testovatelna.
     * @param line
     * @return
     */
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






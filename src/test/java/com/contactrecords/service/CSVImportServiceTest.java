package com.contactrecords.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVImportServiceTest {

    CSVImportService service;

    @BeforeEach
    void setUp() {
        service = new CSVImportService();
    }

    @Test
    void parseLine_shouldReturnListOfTrimmedStrings() {
        String line = "  value1 , value2 ,value3  ";
        List<String> result = service.parseLine(line);
        assertEquals(3, result.size());
        assertEquals("value1", result.get(0));
        assertEquals("value2", result.get(1));
        assertEquals("value3", result.get(2));
    }

    @Test
    void parseLine_shouldHandleEmptyString() {
        String line = "";
        List<String> result = service.parseLine(line);
        assertEquals(1, result.size());
        assertEquals("", result.get(0));
    }

    @Test
    void parseLine_shouldHandleStringWithSpacesOnly() {
        String line = "   ";
        List<String> result = service.parseLine(line);
        assertEquals(1, result.size());
        assertEquals("", result.get(0));
    }

    @Test
    void parseLine_shouldHandleNull() {
        List<String> result = service.parseLine(null);
        assertTrue(result.isEmpty());
    }
}

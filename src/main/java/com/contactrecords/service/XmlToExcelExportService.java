package com.contactrecords.service;

import com.contactrecords.model.Person;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XmlToExcelExportService {

    /**
     * Converts List of people to Excel. Creates a new sheet with name "People" and inserts columns First name, Last name, Address, Phone number.
     * @param persons
     * @param excelFileName
     */
    public void convertToExcel(List<Person> persons, String excelFileName){

        try(Workbook workbook = new XSSFWorkbook();
            FileOutputStream fileOut = new FileOutputStream(excelFileName)){

            Sheet sheet = workbook.createSheet("People");
            Row headerRow = sheet.createRow(0);
            String[] columns = {"First name", "Last name", "Address", "Phone number"};

            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            int rowNum = 1;
            for(Person person : persons){
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(person.getFirstName());
                row.createCell(1).setCellValue(person.getLastName());
                row.createCell(2).setCellValue(person.getAddress());
                row.createCell(3).setCellValue(person.getPhoneNumber());
            }
            workbook.write(fileOut);

        }catch (IOException e){
            e.getMessage();
        }
    }
}

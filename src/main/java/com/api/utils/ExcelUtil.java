package com.api.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;

public class ExcelUtil {
    public static List<Map<String, String>> getData(String filePath, String sheetName) throws IOException {
        List<Map<String, String>> data = new ArrayList<>();
        FileInputStream fis = new FileInputStream("src/test/resources/" + filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row headerRow = sheet.getRow(0);
        int colCount = headerRow.getLastCellNum();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Map<String, String> rowMap = new HashMap<>();
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                rowMap.put(headerRow.getCell(j).getStringCellValue(), row.getCell(j).getStringCellValue());
            }
            data.add(rowMap);
        }
        workbook.close();
        fis.close();
        return data;
    }
}

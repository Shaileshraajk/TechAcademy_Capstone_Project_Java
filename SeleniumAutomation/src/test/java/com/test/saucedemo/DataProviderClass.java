package com.test.saucedemo;

import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;

public class DataProviderClass {
	
	@DataProvider(name = "testData")
    public Object[][] getData() {
        return getTestData("testdata\\Capstone_TestData.xlsx", "LoginData");
    }

    private Object[][] getTestData(String filePath, String sheetName) {
        try  {
        	FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rowCount - 1][colCount];

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                }
            }

            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}

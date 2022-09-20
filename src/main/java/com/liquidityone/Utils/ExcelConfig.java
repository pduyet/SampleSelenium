package com.liquidityone.Utils;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelConfig {

    private XSSFWorkbook wb;
    private XSSFSheet sh;
    private FileInputStream fileIn;

    public ExcelConfig(String excelPath) {
        try {
            File file = new File(excelPath);
            fileIn = new FileInputStream(file);
            wb = new XSSFWorkbook(fileIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public ExcelConfig() {
        try {
            File file = new File("");
            fileIn = new FileInputStream(file);
            wb = new XSSFWorkbook(fileIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public int getNumRow() {
        sh = wb.getSheetAt(0);
        return sh.getLastRowNum();
    }

    public int getColNum() {
        sh = wb.getSheetAt(0);
        return sh.getRow(0).getLastCellNum();
    }

    public String getDataValue(int rowNum, int colNum) {
        sh = wb.getSheetAt(0);
        DataFormatter df = new DataFormatter();
        return df.formatCellValue(sh.getRow(rowNum).getCell(colNum));
    }

    public Object[][] data() {
        int rowNum = getNumRow();
        int colNum = getColNum();
        Log4j.info("Total row: " + rowNum);
        Log4j.info("Total col: " + colNum);
        Object[][] obj = new Object[rowNum][colNum];
        int currentRow = 0;
        for (int i = 0; i <= rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                obj[currentRow][j] = getDataValue(i, j);
                Log4j.info("Value: " + obj[currentRow][j]);
                currentRow++;
            }
        }
        return obj;
    }


}
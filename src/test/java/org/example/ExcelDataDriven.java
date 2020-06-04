package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelDataDriven {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\60066285\\Desktop\\java\\TestReports\\Testdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheetsCount = workbook.getNumberOfSheets();
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < sheetsCount; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                System.out.println(i);
                System.out.println(sheet);

                Iterator<Row> rows = sheet.iterator(); //sheet is collection of rows
                while (rows.hasNext()) {
                    Row firstRow = rows.next();
                    Iterator<Cell> cell = firstRow.cellIterator(); // row is collection of cells

                    while (cell.hasNext()) {
                        if (cell.next().getStringCellValue().equalsIgnoreCase("Login")) {
                            while (cell.hasNext()) {
                                Cell c=cell.next();
                                CellType ct=c.getCellType();
                                if(ct==CellType.STRING) {
                                    arr.add(c.getStringCellValue());
                                } else{
                                    int intValue=(int)c.getNumericCellValue();
                                    String str=Integer.toString(intValue);
                                    arr.add(str);
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(arr.toString());
    }
}


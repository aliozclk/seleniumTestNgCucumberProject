package excelDataProvider;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Excel {

    @Test
    public void getExcel() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\alioz\\Desktop\\Kitap1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheetAt(0);
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int numberOfCols = row.getLastCellNum();

        Object[][] data = new Object[numberOfRows-1][numberOfCols];
        for (int i = 0; i < numberOfRows - 1; i++) {

            row = sheet.getRow(i+1);
            for (int j = 0; j < numberOfCols; j++) {
                System.out.println(row.getCell(j));
            }
        }
    }
}

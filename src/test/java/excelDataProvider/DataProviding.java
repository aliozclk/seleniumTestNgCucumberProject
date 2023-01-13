package excelDataProvider;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProviding {

    DataFormatter formatter = new DataFormatter();

    @Test(dataProvider = "driveTest")
    public void testCaseData(String greeting,String communication,String id){

        System.out.println(greeting +", " + communication + ", " + id);
    }

    //multiple sets of data to our tests
    //array
    //5sets of data as 5 arrays from data provider to your tests
    //then your test ill run 5 times with 5 seperate tests of data arrays

    @DataProvider(name = "driveTest")
    public Object[][] getData() throws IOException {

        //Object[][] data = {{"hello","text","1"},{"bye","message","143"},{"solo","call","453"}};
        //every row of excel should be sent to 1 array

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
                XSSFCell cell = row.getCell(j);

                data[i][j] =formatter.formatCellValue(cell);
            }
        }

        return data;
    }
}

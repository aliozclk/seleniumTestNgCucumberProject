package getDataFromExcelFile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {

    public static void main(String[] args) throws IOException {




    }

    public ArrayList<String> getData(String testCaseName) throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\alioz\\Desktop\\Kitap1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        ArrayList<String> data = new ArrayList<>();
        //Get Access to Sheet
        int numberOfSheet = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheet; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                //Identify Testcases column by scanning the entire 1st row
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                //get Access to Cell
                Iterator<Cell> cell = firstRow.cellIterator();
                int index = 0;
                int col = 0;
                while (cell.hasNext()) {
                    Cell value = cell.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Test Cases")) {
                        //desired column
                        col = index;
                    }
                    index++;
                }

                //once column is identified then scan entire testCase's row
                while (rows.hasNext()) {
                    Row row = rows.next();
                    if (row.getCell(col).getStringCellValue().equalsIgnoreCase(testCaseName)) {

                        //after you grab testcase row == pull all data and feed test
                        Iterator<Cell> cellsOfTest = row.cellIterator();
                        while (cellsOfTest.hasNext()){
                            Cell c = cellsOfTest.next();
                            if(c.getCellType() == CellType.STRING){
                                data.add(c.getStringCellValue());
                            }
                            else {
                                data.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }

                        }
                    }
                }

            }
        }

        return data;
    }


}

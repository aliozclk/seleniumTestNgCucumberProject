package cucumberPractice.smartbearsoftware.assessment.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class CommonExcelReader {

    public HashMap<String, String> getDataFromExcel(String testCaseName, String workbookName, String sheetName) throws IOException {

        String path = "";
        FileInputStream fileInputStream = new FileInputStream(path);

        HashMap<String, String> excelData = new HashMap<>();
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);


        int rowIndexOfTestCase = 0;
        int colIndexOfTestCase = 0;
        boolean isTestCaseFound = false;

        for (int rowIndex = 0; rowIndex < sheet.getLastRowNum(); rowIndex++) {
            if (!isTestCaseFound) {

                Row currentRow = sheet.getRow(rowIndex);
                if (currentRow != null) {
                    for (int colIndex = 0; colIndex < currentRow.getLastCellNum(); colIndex++) {
                        Cell currentCell = currentRow.getCell(colIndex);
                        if (currentCell.getStringCellValue().equalsIgnoreCase("TestCase")) {
                            rowIndexOfTestCase = rowIndex;
                            colIndexOfTestCase = colIndex;
                            isTestCaseFound = true;
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }


        //excelData
        Row headerRow = sheet.getRow(rowIndexOfTestCase);
        for (int indexRow = rowIndexOfTestCase; indexRow < sheet.getLastRowNum(); indexRow++) {

            Row currentRow = sheet.getRow(indexRow);
            Cell testCaseNameCell = currentRow.getCell(colIndexOfTestCase);
            if (testCaseNameCell != null) {
                if (testCaseNameCell.getStringCellValue().equalsIgnoreCase(testCaseName)) {
                    for (int colIndex = colIndexOfTestCase; colIndex < headerRow.getLastCellNum(); colIndex++) {
                        Cell testCaseCell = currentRow.getCell(colIndex);
                        Cell headerCell = headerRow.getCell(colIndex);

                        if (headerCell != null) {
                            String key = headerCell.getStringCellValue();
                            String value = testCaseCell.getStringCellValue();

                            excelData.put(key, value);
                        }

                    }
                    break;
                }

            }

            workbook.close();

        }

        return excelData;

    }
}

package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
    /*public static void main(String[] args) throws EncryptedDocumentException, IOException {

        Object[][] testData = getTestData(path);
        
        // Iterate through the array and print each element
        for (Object[] row : testData) {
            for (Object cellValue : row) {
                System.out.print(cellValue + "\t");
            }
            System.out.println(); // Move to the next line after each row
        }
    }*/

    static Workbook book;
    static Sheet sheet;
    static String sheetName = "Sheet1";
    

    public static Object[][] getTestData(String excelPath) throws EncryptedDocumentException, IOException {
        FileInputStream file = new FileInputStream(excelPath);
        book = WorkbookFactory.create(file);
        sheet = book.getSheet(sheetName);

        // create an array which will store number of rows and cols
        // dataType[][] arrayname = new datatype[lengthrow][lengthcol]
        
        Object[][] inputdata = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                inputdata[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }

        return inputdata;
        
        
    }
}

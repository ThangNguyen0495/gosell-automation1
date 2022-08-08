package utilities.excel;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Excel {
    public Sheet getSheet(String fileName, Integer sheetID) throws IOException {
        FileInputStream fileInput = new FileInputStream("%s/src/main/resources/excels/%s".formatted(System.getProperty("user.dir"), fileName));
        return new XSSFWorkbook(fileInput).getSheetAt(sheetID);
    }
}

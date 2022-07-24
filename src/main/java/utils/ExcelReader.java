package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import constants.Constants;
import environment.PropertyReader;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
    private static final Logger logger = Logger.getLogger(ExcelReader.class);
    private static XSSFSheet excelSheet;
    protected static Properties configProperty;

    private ExcelReader() {
    }

    //Set the File path and to open the Excel file, Pass Excel Path and Sheet name as Arguments to this method
    private static void setExcelFile() {
        XSSFWorkbook excelBook;
        try {
            configProperty = PropertyReader.getConfigData();
            FileInputStream excelFile = new FileInputStream(new File(System.getProperty(Constants.USER_DIR) + Constants.SHEET_PATH));
            excelBook = new XSSFWorkbook(excelFile);
            excelSheet = excelBook.getSheet(Constants.SHEET_NAME);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    //Read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
    public static String getCellData(int rowNum, int colNum) {
        XSSFCell cell;
        try {
            setExcelFile();
            cell = excelSheet.getRow(rowNum).getCell(colNum);
            return cell.getStringCellValue();
        } catch (RuntimeException e) {
            logger.error(e);
            return Constants.FAIL_MSG + e;
        }
    }
}

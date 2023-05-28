package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static String getExcelData(String sheetName, int rowNo, int cellNo)
			throws IOException, IllegalStateException {
		String data;
		String path = "src\\main\\resources\\TestDataForAutomation\\TestData.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);

		try {
			data = cell.getStringCellValue();

		} catch (IllegalStateException e) {
			e.printStackTrace();
			double value = cell.getNumericCellValue();

			data = String.valueOf(value);
		}
		return data;
	}
	public static void setExcelData(String sheetName, int rowNo, int cellNo, String newValue )
			throws IOException, IllegalStateException {
		String path = "src\\main\\resources\\TestDataForAutomation\\TestData.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		cell.setCellValue(newValue);
		 try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
             book.write(fileOutputStream);
             System.out.println("Excel sheet updated successfully.");
         }
     catch (IOException e) {
         e.printStackTrace();
     }
		 file.close();
		 book.close();

	}	

}
	

		    
		    
		
		
	       
		
	
	



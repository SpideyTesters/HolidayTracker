package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {

	public static Cell cell;
	public static XSSFSheet sheet;
	public static Row row1;

	public static void write(String sheetName, int row, int col, String value) throws Exception {
		try {
		File src = new File("./Excelsheet/Data.xlsx");   
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		try {
			sheet = wb.createSheet(sheetName);
		} catch (Exception e) {
			sheet = wb.getSheet(sheetName);
		}
		if (sheet.getRow(row) == null) {
			row1 = sheet.createRow(row);
		} else {
			row1 = sheet.getRow(row);
		}
		if (row1.getCell(col) == null) {
			cell = row1.createCell(col);
		} else {
			cell = row1.getCell(col);
		}
		cell.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(src);
		wb.write(fos);
		wb.close();
		}
		catch(Exception e)
		{
			System.out.println("Error while writing into excel sheet");
			e.printStackTrace();
		}
	}
}

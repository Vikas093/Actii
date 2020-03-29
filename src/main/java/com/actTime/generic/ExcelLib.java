package com.actTime.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {

	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public String path;

	// ------------------------------Constructor of
	// Xls_Reader--------------------------

	public ExcelLib(String path) throws IOException {

		this.path = path;
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}

	// -----------------Getting no of row in excel
	// sheet-----------------------------

	public int getRowCount(String sheetName) {

		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		return rowCount + 1;

	}

	/// -------------Geeting no of column in excel sheet--------------------------

	public int getColumnCount(String sheetName, int rowNumber) {

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		int colCount = row.getLastCellNum();
		return colCount;

	}

	// -----------------Reading excel data using column
	// number-------------------------

	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell.getCellType() == CellType.STRING)

				return cell.getStringCellValue();

			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());

				return cellValue;
			}

			else if (cell.getCellType() == CellType.BLANK)

				return "";

			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			return "Row" + rowNum + " or Column" + colNum + "does not exist in excel";
		}

	}
	/// ---------------------------Reading excel data using column
	/// name---------------------

	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			int colNum = -1;
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);

			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName.trim())) {
					colNum = i;
				}
			}
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
	

			if (cell.getCellType() == CellType.STRING)

				return cell.getStringCellValue();

			else if (cell.getCellType()== CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				
				String cellValue = String.valueOf(cell.getNumericCellValue());

				return cellValue;
			}

			else if (cell.getCellType() == CellType.BLANK)

				return "";

			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {
			return "Row" + rowNum + " or Column" + colName + "does not exist in excel";
		}
	}

	/// ---------------------Writing data in excel using col
	/// number-----------------------------------

	public Boolean setCellData(String sheetName, int colNum, int rowNum, String value) throws IOException {
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			if (row == null) {
				row = sheet.createRow(rowNum);
			}

			cell = row.getCell(colNum);

			if (cell == null) {
				cell = row.createCell(colNum);
			}
			cell.setCellValue(value);

			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			return false;// Return false
		}
		return true;

	}

	/// ---------------------Writing data in excel using col
	/// name-----------------------------------

	public Boolean setCellData(String sheetName, String colName, int rowNum, String value) throws IOException {

		try {
			int colNum = -1;
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);

			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName.trim())) {
					colNum = i;
				}
			}
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			if (row == null) {
				row = sheet.createRow(rowNum);
			}

			cell = row.getCell(colNum);

			if (cell == null) {
				cell = row.createCell(colNum);
			}
			cell.setCellValue(value);

			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			return false;// Return false
		}
		return true;

	}
}

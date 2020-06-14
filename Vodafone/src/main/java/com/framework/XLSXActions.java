package com.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXActions {
	private String xlsx_name;

	public XLSXActions(final String xlsx_name) {
		this.xlsx_name = xlsx_name;
	}

	// method defined for reading a cell
	public String ReadCellData(int vRow, int vColumn) {
		String value = null; // variable for storing the cell value
		XSSFWorkbook wb = null; // initialize Workbook null
		try {
			// reading data from a file in the form of bytes
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/resources/" + xlsx_name);
			// constructs an XSSFWorkbook object, by buffering the whole stream into the
			// memory
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// getting the XSSFSheet object at given index
		Sheet sheet = wb.getSheetAt(0);
		// returns the logical row
		Row row = sheet.getRow(vRow);
		// getting the cell representing the given column
		Cell cell = row.getCell(vColumn);
		// getting cell value
		boolean numeric = true;

		try {
			Double.parseDouble(cell.getStringCellValue());
		} catch (NumberFormatException e) {
			numeric = true;
		} catch (IllegalStateException e) {
			numeric = true;
		}

		if (numeric == true) {
			DataFormatter formatter = new DataFormatter();
			value = formatter.formatCellValue(cell);
		} else if (numeric == false) {
			value = cell.getStringCellValue();
		}
		return value;
	}
}
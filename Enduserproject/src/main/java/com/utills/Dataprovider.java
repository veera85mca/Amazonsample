package com.utills;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.report.Myreports;


public class Dataprovider {

	private static ThreadLocal<Map<String, String>> xlsxDataProvider = new ThreadLocal<Map<String, String>>();

	public static Map<String, String> loadExcelData(String excelFile, String sheetName, String testName) {
		Map<String, String> data = new HashMap<String, String>();
		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFile));
			DataFormatter formatter = new DataFormatter();
			Workbook workBook = new XSSFWorkbook(inputStream);
			Sheet workSheet = workBook.getSheet(sheetName);
			int rowCount = workSheet.getPhysicalNumberOfRows();
			int colCount = workSheet.getRow(0).getPhysicalNumberOfCells();
			XSSFRow rowHeader = (XSSFRow) workSheet.getRow(0);
			XSSFRow row;
			XSSFCell cell;
			int findRow = findRow(workSheet, testName);
			if (findRow == 0) {
				Myreports.addlogs("Test data not found for Test Name", "Info");
			} else {
				row = (XSSFRow) workSheet.getRow(findRow);
				for (int c = 1; c < colCount; c++) {
					cell = rowHeader.getCell(c);
					String key = formatter.formatCellValue(cell);
					cell = row.getCell(c);
					String value = formatter.formatCellValue(cell);
					data.put(key, value);
				}
				setXLS(data);
			}
			workBook.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	private static int findRow(Sheet workSheet, String cellContent) {
		for (Row row : workSheet) {
			for (Cell cell : row) {
				if (cell.getCellType() == CellType.STRING) {
					if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
						return row.getRowNum();
					}
				}
			}
		}
		return 0;
	}
	private static void setXLS(Map<String, String> data) {
		xlsxDataProvider.set(data);
	}
	private static Map<String, String> getXLS() {
		try {
			xlsxDataProvider.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xlsxDataProvider.get();
	}
	
	public static synchronized String getExcelData(String productname) {
		String xlData = "";
		try {
			xlData = getXLS().get(productname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xlData;
	}

}

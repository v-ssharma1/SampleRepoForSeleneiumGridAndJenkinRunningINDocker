package main.java.CustomerRagistration.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public FileOutputStream fileOut = null;
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public ExcelReader() {
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + File.separator + "Resources" + File.separator + "Cargo.xlsx");
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Creating data provider from the sheet which return 2 D array of String.
	 */
	@SuppressWarnings({ "deprecation" })
	public String[][] getDataFromSheet(String sheetName) {
		String dataSets[][] = null;
		try {
			// get sheet from excel workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active tows
			int totalRow = sheet.getLastRowNum();
			System.out.println("Total number of rows in the table:" + totalRow);
			// count number of active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();
			// Create array of rows and column
			dataSets = new String[totalRow - 1][totalColumn];
			System.out.println("inserting the data into a dataprovider of size " + dataSets.length);
			// Run for loop and store data in 2D array
			// This for loop will run on rows
			for (int i = 1; i <= totalRow - 1; i++) {
				XSSFRow rows = sheet.getRow(i);
				// This for loop will run on columns of that row
				for (int j = 0; j < totalColumn; j++) {
					// get Cell method will get cell
					XSSFCell cell = rows.getCell(j);
					//dataSets[i - 1][j] = cell.getStringCellValue();
					// If cell of type String , then this if condition will work
					if (cell.getCellType() == Cell.CELL_TYPE_STRING)
						dataSets[i - 1][j] = cell.getStringCellValue();
					// If cell of type Number , then this if condition will work
					else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						String cellText = String.valueOf(cell.getNumericCellValue());
						dataSets[i - 1][j] = cellText;
					} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						// If cell of type blank , then this if condition will work
						String cellText = String.valueOf("");
						dataSets[i - 1][j] = cellText;
					} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
						// If cell of type boolean , then this if condition will work
						String cellText = String.valueOf(cell.getBooleanCellValue());
						dataSets[i - 1][j] = cellText;
					} else
						// If cell of type boolean , then this if condition will work
						System.out.println("Data type does't match");
				}

			}
			return dataSets;
		} catch (Exception e) {
			System.out.println("Exception in reading Xlxs file" + e.getMessage());
			e.printStackTrace();
		}
		return dataSets;
	}

	/*
	 * Getting cell data as String
	 */
	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			int col_Num = 0;
			int index = workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			XSSFRow row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equals(colName)) {
					col_Num = i;
					break;
				}
			}
			row = sheet.getRow(rowNum - 1);
			XSSFCell cell = row.getCell(col_Num);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * Inserting test results into table.
	 */
	public void setCellData(String sheetName, String result, String testCaseName) {
		try {

			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + File.separator + "Resources" + File.separator + "Cargo.xlsx");
			// get sheet from excel workbook
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get sheet name
			XSSFSheet sheet = workbook.getSheet(sheetName);
			System.out.println(
					"updating test result for " + testCaseName + " as " + result + " in the  sheet: " + sheetName);
			int totalRow = sheet.getLastRowNum();

			System.out.println("Total Rows:" + totalRow);
			// System.out.println("TotalColumn:" + totalRow);
			for (int i = 1; i <= totalRow; i++) {
				XSSFRow r = sheet.getRow(i);
				int totalColumn = r.getLastCellNum() - 1;
				String ce = r.getCell(0).getStringCellValue();
				if (ce.contains(testCaseName)) {
					r.createCell(totalColumn).setCellValue(result);
					// r.createCell(1).setCellValue(result);
					file.close();
					System.out.println("Test Result updated..");
					FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir") + File.separator
							+ "Resources" + File.separator + "Cargo.xlsx"));
					workbook.write(out);
					out.close();
					break;
				}
			}
			System.out.println("Test Result updated.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// public boolean setCellData(String sheetName, String colName, int rowNum,
	// String result) {
	// try {
	// fis = new FileInputStream(path);
	// workbook = new XSSFWorkbook(fis);
	//
	// if (rowNum <= 0)
	// return false;
	//
	// int index = workbook.getSheetIndex(sheetName);
	// int colNum = -1;
	// if (index == -1)
	// return false;
	//
	// sheet = workbook.getSheetAt(index);
	//
	// row = sheet.getRow(0);
	// for (int i = 0; i < row.getLastCellNum(); i++) {
	// // System.out.println(row.getCell(i).getStringCellValue().trim());
	// if (row.getCell(i).getStringCellValue().trim().equals(colName))
	// colNum = i;
	// }
	// if (colNum == -1)
	// return false;
	// sheet.autoSizeColumn(colNum);
	// row = sheet.getRow(rowNum - 1);
	// if (row == null)
	// row = sheet.createRow(rowNum - 1);
	//
	// cell = row.getCell(colNum);
	// if (cell == null)
	// cell = row.createCell(colNum);
	//
	// // cell style
	// // CellStyle cs = workbook.createCellStyle();
	// // cs.setWrapText(true);
	// // cell.setCellStyle(cs);
	// cell.setCellValue(result);
	//
	// fileOut = new FileOutputStream(path);
	//
	// workbook.write(fileOut);
	//
	// fileOut.close();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// return false;
	// }
	// return true;
	// }

}

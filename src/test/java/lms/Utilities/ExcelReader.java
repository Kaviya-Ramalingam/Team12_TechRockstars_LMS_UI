package lms.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelReader {

	public static FileInputStream fi;
	public FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public XSSFRow row;
	public static XSSFCell cell;
	public CellStyle style;
	public File jsonFile;
	
	public static void loadExcelFile(String sheetName) throws IOException {

		String filePath = System.getProperty("user.dir")
				+ "//src//test//resources//Team12_TechRockstarts_Lms_data.xlsx";
		fi = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fi);

		sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			throw new IOException("Sheet " + sheetName + " not found in the Excel file.");
		}
	}

	// to get row number for given data key
	private static int getDataRow(String dataKey, int dataColumn) {
		
		int rowCount = sheet.getLastRowNum();
		for (int row = 1; row <= rowCount; row++) {
			String cellData = getCellData(row, 0); // Assuming the dataKey is in the first column (0th index)
			if (cellData.equalsIgnoreCase(dataKey)) {
				return row;
			}
		}
		return -1;
	}

//get data from specified cell
	private static String getCellData(int rowNumb, int colNumb) {
		
		cell = sheet.getRow(rowNumb).getCell(colNumb);
		if (cell != null) {
			if (cell.getCellType() == CellType.NUMERIC) {
				cell.setCellType(CellType.STRING);
			}
			String cellData = cell.getStringCellValue();
			return cellData;
		}
		return "";
	}

	public static Map<String, String> getData(String dataKey, String sheetName) throws Exception {

		loadExcelFile(sheetName);

		Map<String, String> dataMap = new HashMap<String, String>();
		int dataRow = getDataRow(dataKey.trim(), 0);
		if (dataRow == -1) {
			throw new Exception("NO DATA FOUND for dataKey: " + dataKey);
		}
		int columnCount = sheet.getRow(dataRow).getLastCellNum();

		// Iterate over the columns 
		for (int i = 1; i < columnCount; i++) { // Start from 1 to skip the header row
			String header = getCellData(0, i); // Get the header (key) from the first row
			String value = getCellData(dataRow, i); // Get the corresponding value for the key
			dataMap.put(header, value);
		}
		return dataMap;
	}

}


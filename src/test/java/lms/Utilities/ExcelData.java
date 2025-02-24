package lms.Utilities;

import java.util.Map;

public class ExcelData {
	static Map<String, String> excelDataMap;
	
	public static String programName;
	public static String programDescription;
	static String programStatus;
	
	public static Map<String, String> programXLdata(String dataKey,String SheetName) throws Exception {
		
		excelDataMap = ExcelReader.getData(dataKey, SheetName);

		programName = excelDataMap.get("programName");
		programDescription= excelDataMap.get("programDescription");
		//programStatus = excelDataMap.get("programStatus");

		return excelDataMap;
	}

}

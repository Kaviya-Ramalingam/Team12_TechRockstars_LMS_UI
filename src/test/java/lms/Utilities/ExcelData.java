package lms.Utilities;

import java.util.Map;

public class ExcelData {
	static Map<String, String> excelDataMap;
	static Map<String, String> excelDataMapClass;
	public static String programName;
	public static String programDescription;
	static String programStatus;
	public static String classTopic;
	
	public static Map<String, String> programXLdata(String dataKey,String SheetName) throws Exception {
		
		excelDataMap = ExcelReader.getData(dataKey, SheetName);

		programName = excelDataMap.get("programName");
		programDescription= excelDataMap.get("programDescription");

		return excelDataMap;
	}
	
public static Map<String, String> classXLdata(String dataKey,String SheetName) throws Exception {
		
		excelDataMapClass = ExcelReader.getData(dataKey, SheetName);

		classTopic = excelDataMapClass.get("classTopic");
		
		return excelDataMap;
	}

}

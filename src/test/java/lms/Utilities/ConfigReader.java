package lms.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static Properties prop;
	public static String browserName ;
	
	public static void ReadDataFromConfig() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "//src//test//resources//Config//config.properties");
		prop.load(fis);
	   
	}
	
	public static void WriteDataIntoConfig() throws IOException {
		FileOutputStream outputStream = new FileOutputStream(
				System.getProperty("user.dir") + "//src//test//resources//Config//config.properties");
		prop.store(outputStream, null); // Save the properties to file
		outputStream.close();
	}

	public static String getUrl() {
		String Url = prop.getProperty("url");
		return Url;

	}

	public static String getBrowser() {
		String browser = prop.getProperty("browser");
		return browser;
	}

	public static String getUsername() {
		String username = prop.getProperty("username");
		return username;
	}

	public static String getpassword() {
		String password = prop.getProperty("password");
		return password;
	}

	public static String getrole() {
		String role = prop.getProperty("role");
		return role;
	}

	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

	public static void setProperty(String key, String value) throws IOException {
		prop.setProperty(key, value); // Set the property in the properties object
		WriteDataIntoConfig();
		
	}
}

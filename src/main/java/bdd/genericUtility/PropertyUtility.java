package bdd.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyUtility {

	Properties properties;
	
	
	public void loadPropertyFile() throws Throwable {
		FileInputStream file = new FileInputStream(".\\CucumberFrame.properties");
		 properties = new Properties();
		properties.load(file);
		
	}
	
	public String readBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
	}
	
	public String readUrl() {
		String url = properties.getProperty("url");
		return url;
	}
	
	public String readUsername() {
		String username = properties.getProperty("username");
		return username;
	}
	
	public String readPassword() {
		String password = properties.getProperty("password");
		return password;
	}
}

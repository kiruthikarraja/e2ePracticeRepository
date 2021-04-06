package com.practiceAutomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;
	public ConfigDataProvider() {
		
		File src=new File("./configuration/configProp.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to config file " + e.getMessage());
		} 
		
	}
	
	/*public String getDataFromPropFile(){
		
	}*/
	
	public String getBrowserFromPropFile(){
		return prop.getProperty("Browser");
	}

	public String getURLFromPropFile(){
		return prop.getProperty("practiceURL");

	}


}

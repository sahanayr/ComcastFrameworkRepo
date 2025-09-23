package com.comcast.crm.generic.data.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws Exception {
		FileInputStream fis = new FileInputStream("./configAppData/d.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data =	pObj.getProperty(key);
		
		
		
		return data;
		
	}
}

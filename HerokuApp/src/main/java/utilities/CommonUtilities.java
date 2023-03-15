package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtilities {
	public static String getPropertyValue(String key) throws IOException {
		Properties objProperties=new Properties();
		String strpath=Constants.APPLICATION_PROPERTIES_PATH;	
		FileInputStream objFile=new FileInputStream(strpath);
		objProperties.load(objFile);
		String strKey=objProperties.getProperty(key);
		return strKey;
	}
	
}

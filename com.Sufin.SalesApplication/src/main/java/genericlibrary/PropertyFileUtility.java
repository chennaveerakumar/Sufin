package genericlibrary;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	Properties prop;
    public PropertyFileUtility() {
    	File file = new File("./src/java/resources/Config.properties");
    	try{
    		FileInputStream fis = new FileInputStream(file);
    		prop=new Properties();
    		prop.load(fis);
    	}
    	catch(Exception e) {
            System.out.println("Exception is"+e.getMessage());    		
    	}
    	
    }
    public String getBrowser() {
    	String Browser = prop.getProperty("Browser");
    	return Browser;
    }
    public String getBaseURL() {
    	String BaseURL = prop.getProperty("BaseURL");
    	return BaseURL;
    }
    public String getEmail() {
    	String Email = prop.getProperty("Email");
    	return Email;
    }
    public String getPassword() {
    	String Password = prop.getProperty("Password");
    	return Password;
    }
    
}

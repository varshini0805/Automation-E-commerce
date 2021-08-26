package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() throws IOException
	{
		File src= new File("./Configuration/Config.properties");
		
		FileInputStream fs= new FileInputStream(src);
		
		 pro = new Properties();
		
		pro.load(fs);
	
	}
	
	public String getURL()
	{
		String Baseurl = pro.getProperty("Url");
		return Baseurl;
	}
	
	public String getEmail()
	{
		String Email = pro.getProperty("Email");
		return Email;
	}
	
	public String getPassword()
	{
		String Password = pro.getProperty("Password");
		return Password;
	}

}

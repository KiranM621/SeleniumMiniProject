package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public static String getProperty(String key) throws IOException
	{
		FileReader reader=new FileReader("files/config.properties");
	 Properties p = new Properties();
     p.load(reader);
     
     return p.getProperty(key);
	 
		
	}
	
	public static void main(String[] args) throws IOException {
		
//		FileReader reader=new FileReader("files/config.properties");
//		 Properties p = new Properties();
//	        p.load(reader);
//		 System.out.println( p.getProperty("baseUrl"));
//	      System.out.println( p.getProperty("browser"));
//	      System.out.println(p.getProperty("id"));
//	       System.out.println(p.getProperty("pwd")); 
	}

}

package suman.saurav.in;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
FileInputStream fis= new FileInputStream("application.properties");
Properties properties= new Properties();
properties.load(fis);

String url = properties.getProperty("url");
String user = properties.getProperty("user");
String password = properties.getProperty("password");

System.out.println("URL is :: "+url);
System.out.println("USER is :: "+user);
System.out.println("PWD is :: "+password);
	}

}

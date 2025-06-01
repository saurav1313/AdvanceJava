package in.suman.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
    
    private JdbcUtil() {
        // private constructor to prevent instantiation
    }
    
    static {
        // Step1. Loading and registering the Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException ce) {                   
        	ce.printStackTrace();                     
        }
    }

    public static Connection getJdbcConnection() throws SQLException, IOException {
    	
    	//Take the data from properties file
    	FileInputStream fis= new FileInputStream("D:\\JavaAdavance\\JDBCStandardApp\\application.properties");
    	Properties properties = new Properties();

		properties.load(fis);
        // Step2. Establish the Connection
        String url = properties.getProperty("url");
        String user = properties.getProperty("username");
        String password = properties.getProperty("password");

        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println("CONNECTION object created...");
        return connection;
    }

    public static void cleanup(Connection con, Statement statement, ResultSet resultset) throws SQLException {
        // Step6. Close the resources
        if (resultset != null) {
            resultset.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (con != null) {
            con.close();
        }
    }
}

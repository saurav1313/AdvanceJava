package in.suman.saurav;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.suman.util.JdbcUtil;

/**
 * @author suman
 * @Company saurvtechy
 * @see www.saurav.dev
 *
 */
public class InsertApp {

    public static void main(String[] args) {
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = JdbcUtil.getJdbcConnection();
            
            if (connection != null) {
                statement = connection.createStatement();  
                
                if (statement != null) {
                    resultSet = statement.executeQuery("select sid, sname, sage, saddress, sgender from student");
                    
                    if (resultSet != null) {
                        System.out.println("SID\tSNAME\tSAGE\tSADDRESS\tSGENDER");
                        while (resultSet.next()) {
                        	System.out.printf("%-5d %-15s %-5d %-15s %-10s%n",
                                    resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getInt(3),
                                    resultSet.getString(4),
                                    resultSet.getString(5));

                        }
                    }
                }
            }
        } 
        catch(IOException io) {
        	io.printStackTrace();
        }
        catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.cleanup(connection, statement, resultSet);
            } catch (SQLException e) {
                System.out.println("Closing the resources...");
                e.printStackTrace();
            }
        }
    }
}

package in.suman.saurav;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DeletionApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		 // Step2. Establish the Connection
        String url = "jdbc:mysql://localhost:3306/JDBCsikho";
        String user = "root";
        String password = "1234";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("CONNECTION object created...");

        // Step3. Create statement Object and send the Query
        Statement statement = connection.createStatement();
        System.out.println("STATEMENT object created...");

        // Step4. Execute the Query and Process the resultSet
        String sqlSelectQuery = "delete from Student where sid = 3";
        int rowAffected = statement.executeUpdate(sqlSelectQuery);
        System.out.println("No. of row affected is :: " +rowAffected);

        // Step6. Close the resources
       
        statement.close();
        connection.close();
        System.out.println("Closing the resources...");
	}

}
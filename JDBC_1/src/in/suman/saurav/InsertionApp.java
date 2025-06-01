package in.suman.saurav;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertionApp {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Step2. Establish the Connection
        String url = "jdbc:mysql://localhost:3306/JDBCsikho";
        String user = "root";
        String password = "1234";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("CONNECTION object created...");

        // Step3. Create statement Object and send the Query
        Statement statement = connection.createStatement();
        System.out.println("STATEMENT object created...");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the student :: ");
        String sname = sc.next();

        System.out.print("Enter the age of the Student :: ");
        int sage = sc.nextInt();

        System.out.print("Enter the address of the student :: ");
        String saddress = sc.next();

        // Correct SQL Query (no manual quoting of variables)
        String sqlInsertQuery = "INSERT INTO Student(sname, sage, saddress) VALUES ('" + sname + "', " + sage + ", '" + saddress + "')";
        System.out.println(sqlInsertQuery);

        int rowAffected = statement.executeUpdate(sqlInsertQuery);
        System.out.println("No. of row affected is :: " + rowAffected);

        // Step6. Close the resources
        statement.close();
        connection.close();
        System.out.println("Closing the resources...");
    }
}

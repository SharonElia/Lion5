package SharonProject.pageObjects;

import java.sql.*;

/**
 * Created by SMaymonX054905 on 20/08/2017.
 */
public class DB{

    public static String DB() throws  ClassNotFoundException, SQLException

    {
        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = "jdbc:mysql://localhost:3306/sharon";

        //Database Username
        String username = "sharonelia";

        //Database Password
        String password = "Shilielia1234$";

        //Query to Execute
        String query = "select *  from sharon.student ;";

        //Load mysql jdbc driver
        Class.forName("com.mysql.jdbc.Driver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl, username, password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs = stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        String LastName = null;
        String FirstName = null;
        rs.last();
        LastName = rs.getString(2);
        FirstName = rs.getString(3);
        rs.previous();
        String id = rs.getString(1);
        System.out.println("SharonTest" + "\t" + id+"\t"+ LastName);
        con.close();
        return LastName;
        // closing DB Connection

    }
}






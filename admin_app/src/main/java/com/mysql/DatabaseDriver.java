package com.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class DatabaseDriver {
    String url = "jdbc:mysql://localhost:3306/demo";
    String url2 = "jdbc:mysql://localhost:3306/paintings";
    String user = "root";
    String password = "renTON55";
    Connection myConn = null;
    Statement myStmt = null;
    PreparedStatement myPreparedStmt = null;

    public void addUserToTable() {

        try {
            // 1. Get a connection to the database
            myConn = DriverManager.getConnection(url, user, password);
            System.out.println("connected to demo");

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            String sql = "insert into employees "
                    + " (last_name, first_name, email)"
                    + "values('stevens', 'pip', 'pip@gmail.com')";

            myStmt.executeUpdate(sql);

            System.out.println("statement updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addImageLocationToDatabase() {

        try {
            // 1. Get a connection to the database
            myConn = DriverManager.getConnection(url2, user, password);
            System.out.println("connected to paintings");

            // sql statement to prepare upload image to the area in the database where the comment is surf
            String sql = "update images set images=? where comments=surf";
            myPreparedStmt = myConn.prepareStatement(sql);

            // 3. Set parameter for painting local file location
            File file = new File("C:\\workspace\\SpringBootThymeleaf\\src\\main\\resources\\images\\surf.jpg");
            FileInputStream input = new FileInputStream(file);
            myPreparedStmt.setBinaryStream(1, input);

            System.out.println("Reading input file " + file.getAbsolutePath());

            // execute statement
            System.out.println("\nStoring image in database: " + file);
            System.out.println(sql);

            // execute update
            myPreparedStmt.executeUpdate();

            System.out.println("painting location uploaded");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } }









package com.automation.utilities;

import org.openqa.selenium.WebElement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kolodiy on 7/29/16.
 */
public class DbHelper {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test_results";
    static final String DB_NAME = "test_res";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "777999";

    public static void main(String[] args) {


    }//end main

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(JDBC_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_URL, USER, PASS);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
    public static void insertRecordIntoTable(List<WebElement> names, List<WebElement> prices) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO test_results.test_res"
                + "(TestDate, ProductName, ProductPrice) VALUES"
                + "(?,?,?)";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            int i = 0;
            while (i < names.size()) {
            preparedStatement.setTimestamp(1,getCurrentTimeStamp());
            preparedStatement.setString(2, names.get(i).getText() );
            preparedStatement.setString(3, prices.get(i).getText());
            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            i++;
            }

            System.out.println("Record is inserted into test_res table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }

}


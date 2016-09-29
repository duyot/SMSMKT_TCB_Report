package com.vivas.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by duyot on 9/28/2016.
 */
public class DBUtils {

    public static Logger log = LoggerFactory.getLogger(DBUtils.class);
    public static final String JDBC_URL = BundleUtils.getkey("jdbc.url");
    public static final String JDBC_USER_NAME = BundleUtils.getkey("jdbc.username");
    public static final String JDBC_PASSWORD = BundleUtils.getkey("jdbc.password");

    public static Connection getConnection(){
        Connection con = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            return DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME,JDBC_PASSWORD);
        } catch (SQLException e) {
            log.error("Could not get connection caused: "+ e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(ResultSet rs, CallableStatement callableStatement, Connection connection){
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception ex) {
                log.error("Error: ", ex);
            }
        }
        //
        if(callableStatement != null){
            try {
                callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeConnection(ResultSet rs, Statement statement, Connection connection){
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception ex) {
                log.error("Error: ", ex);
            }
        }
        //
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.ci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Detector {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://mysql:3306/sonar";
    static int retries = 120;
    static int retryInterval = 500;

    public static void main(String[] args) throws InterruptedException {
        String retry = System.getProperty("retry");
        if (null != retry && !"".equalsIgnoreCase(retry)) {
            retries = Integer.parseInt(retry);
        }
        System.out.println("retry:" + retry + ", " + retries);
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("⚠ Can not find JDBC driver for MYSQL DB.");
            e.printStackTrace();
            System.exit(1);
        }

        Properties prop = new Properties();
        prop.put("user", "sonar");
        prop.put("password", "sonar");
        Connection connection;
        for (int i = 0; i < retries; i++) {
            try {
                connection = DriverManager.getConnection(url, prop);
                if (connection != null) {
                    System.out.println("⚡ DB connection is successful.");
                    for (int j = 0; j < 5; j++) {
                        System.out.println("**************test**************");
                        Thread.sleep(2000);
                    }
                    return;
                }
            } catch (SQLException e) {
                System.out.println("⚠ Can not establish a connection to the DB.");
            }
            Thread.sleep(retryInterval);
        }

        System.out.println("⚠ Failed to connect to the DB.  Quit.");
        System.exit(1);
    }
}
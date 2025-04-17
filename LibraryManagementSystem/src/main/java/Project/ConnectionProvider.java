package Project;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class ConnectionProvider {

    public static Connection getCon() {
        Properties prop = new Properties();
        InputStream input = ConnectionProvider.class.getClassLoader().getResourceAsStream("config.properties");

        // Load the config.properties file from the classpath
        try (input) { 

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }

            // Load the properties
            prop.load(input);

            // Get the values from the properties file
            String url = prop.getProperty("db.url");
            String username = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            // Ensure these values are not null or empty
            if (url == null || username == null || password == null) {
                System.out.println("Missing configuration values in config.properties");
                return null;
            }

            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Return the connection
            return DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}



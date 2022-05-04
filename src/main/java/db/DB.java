package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                connection = DriverManager.getConnection(url, props);
            }
            catch (SQLException e) {
                throw new DBException("Could not connect to database" + e.getMessage());
            }
        }
        return connection;
    }
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("src/main/resources/db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException e) {
            throw new DBException("Could not load properties file" + e.getMessage());
        }
    }

    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            }
            catch (SQLException e) {
                throw new DBException("Could not close connection" + e.getMessage());
            }
        }
    }

    public static void closeStatement(PreparedStatement st) {
        if (st != null) {
            try {
                st.close();
            }
            catch (SQLException e) {
                throw new DBException("Could not close statement" + e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }
            catch (SQLException e) {
                throw new DBException("Could not close result set" + e.getMessage());
            }
        }
    }
}

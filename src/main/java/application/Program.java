package application;

import db.DB;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public static void main(String[] args) throws Exception {

        Connection connection = DB.getConnection();
        Statement st = connection.createStatement();

        try {
            st.executeQuery("SELECT * FROM department");
        }
        catch (SQLException e) {
            ScriptRunner sr = new ScriptRunner(connection);
            Reader reader = new BufferedReader(new FileReader("src/main/resources/script.sql"));
            sr.runScript(reader);
        }



    }
}

package application;

import db.DB;
import model.entities.Department;
import model.entities.Seller;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Connection;

public class Program {

    public static void main(String[] args) {

        Department d1 = new Department(1, "Computers");

        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime dt1 = fmt.parseDateTime("15/12/1980");

        Seller s1 = new Seller(1, "Bob Brown", "bob@gmail.com", dt1, 1000.0, d1);

        System.out.println(s1);
    }
}

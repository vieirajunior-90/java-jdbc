package application;

import db.DB;
import model.entities.Department;

import java.sql.Connection;

public class Program {

    public static void main(String[] args) {

        Department d1 = new Department(1, "Computers");
        System.out.println(d1);
    }
}

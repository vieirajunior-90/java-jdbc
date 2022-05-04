package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

    public static void main(String[] args) {
        DepartmentDao dao = DaoFactory.createDepartmentDao();

//        System.out.println("\n==== INSERTING DEPARTMENT ====");
//        Department depFood = new Department(null, "Food");
//        dao.insert(depFood);
//        System.out.println("INSERTED DEPARTMENT");

        System.out.println("\n==== UPDATE DEPARTMENT ====");
        Department dep = dao.findById(1);
        dep.setName("Cars");
        dao.update(dep);
        System.out.println("UPDATED DEPARTMENT");
    }
}

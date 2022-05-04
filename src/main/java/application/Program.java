package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.List;

public class Program {

    public static void main(String[] args){

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("\n==== FIND SELLER BY ID ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n==== FIND SELLER BY DEPARTMENT ====");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);
        for (Seller obj : sellers) {
            System.out.println(obj);
        }

        System.out.println("\n==== FIND ALL SELLERS ====");
        List<Seller> allSellers = sellerDao.findAll();
        for (Seller obj : allSellers) {
            System.out.println(obj);
        }

        System.out.println("\n==== INSERT SELLER ====");
        Seller newSeller = new Seller(null,
                "Juan Vasquez",
                "juanvasquez@hotmail.com",
                new DateTime(1980, 12, 12, 0, 0),
                2000.0,
                department);

        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id: " + newSeller.getId());

    }
}

import Dao.JpaDao;

import Dao.JpaDao;
import Model.User;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create a JpaDao instance for User
        JpaDao<User> userDao = new JpaDao<>(User.class);

        // Create a dummy user
        User user = new User(
                "Jane Doe",
                "jane@example.com",
                "123-456-7890",
                "123 Street, City",
                "password123",
                5
        );

        // Save the user to the database
        userDao.save(user);

        // Print confirmation
        System.out.println("Dummy user saved: " + user);


    }
}

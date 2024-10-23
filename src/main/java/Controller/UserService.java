package Controller;

import Dao.JpaDao;
import Model.User;
import org.springframework.stereotype.Component;


@Component
public class UserService {

    private JpaDao<User> userDao = new JpaDao<>(User.class);

    public User findByEmail(String email) {
        return userDao.findByEmail(email, "User"); // Fetch user by email
    }

    public void addUser(User user) {
        userDao.save(user); // Save new user
    }
}


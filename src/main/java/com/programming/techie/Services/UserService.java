package com.programming.techie.Services;

import com.programming.techie.Dao.JpaDao;
import com.programming.techie.Model.User;
import org.springframework.stereotype.Component;


@Component
public class UserService {

    private JpaDao<User> userDao = new JpaDao<>(User.class);

    public User findByEmail(String email) {
        return userDao.findByEmail(email, "User"); // Fetch user by email
    }
    public User findById(Long id) {
        return userDao.findById(id);
    }

    public void addUser(User user) {
        userDao.save(user); // Save new user
    }
}


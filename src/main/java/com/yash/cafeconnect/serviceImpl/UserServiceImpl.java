package com.yash.cafeconnect.serviceImpl;

import com.yash.cafeconnect.entity.User;
import com.yash.cafeconnect.dao.UserDao;
import com.yash.cafeconnect.daoImpl.UserDaoImpl;
import com.yash.cafeconnect.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    public void addUser(User user) {
        if(userDao.getUser(user.getEmailId()) != null){
            throw new IllegalStateException("User with this EmailId already exists");
        }
        userDao.saveUser(user);
    }
    public User getUserByEmailId(String emailId) {
        return userDao.getUser(emailId);
    }
    public void updateUser(User user) {
        if(userDao.getUser(user.getEmailId()) == null){
            throw new IllegalStateException("User with this EmailId does not exist");
        }
        userDao.updateUser(user);
    }
    public void removeUser(String emailId) {
        if(userDao.getUser(emailId) == null){
            throw new IllegalStateException("User with this EmailId does not exist");
        }
        userDao.deleteUser(emailId);
    }
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}

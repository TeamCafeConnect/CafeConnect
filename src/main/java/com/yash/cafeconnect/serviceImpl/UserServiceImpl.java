package com.yash.cafeconnect.serviceImpl;

import com.yash.cafeconnect.entity.User;
import com.yash.cafeconnect.dao.UserDao;
import com.yash.cafeconnect.daoImpl.UserDaoImpl;
import com.yash.cafeconnect.entity.dto.UserLoginModel;
import com.yash.cafeconnect.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();


    public String addUser(User user) {
        if(userDao.getUser(user.getEmailId()) != null){
            throw new IllegalStateException("User with this EmailId already exists");
        }
        return userDao.saveUser(user);
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

    public UserLoginModel authenticateUser(String emailId, String password)
    {
        UserLoginModel userLoginModel=new UserLoginModel();
        User user=getUserByEmailId(emailId);

        if(user==null)
        {
           userLoginModel.setMessage("NOT_FOUND");
           return userLoginModel;
        }

        if(!user.getPassword().equals(password))
        {
            userLoginModel.setMessage("UNAUTHORIZED");
            return userLoginModel;
        }

        userLoginModel.setUser(user);
        userLoginModel.setMessage("SUCCESS");
        return userLoginModel;
    }
}

package com.yash.cafeconnect.service;

import com.yash.cafeconnect.entity.User;
import com.yash.cafeconnect.entity.dto.UserLoginModel;

import java.util.List;

/**
 * Service interface for User entity.
 */
public interface UserService {
    // Add a new User
    String addUser(User user);
    // Get User by EmailId
    User getUserByEmailId(String emailId);
    // Update User details
    void updateUser(User user);
    // Remove User by EmailId
    void removeUser(String emailId);
    // Get list of all Users
    List<User> getUsers();

    UserLoginModel authenticateUser(String emailId, String password);
}

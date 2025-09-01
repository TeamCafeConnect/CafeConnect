package com.yash.cafeconnect.dao;

import com.yash.cafeconnect.entity.User;
import java.util.List;

/**
 * The UserDao interface defines the standard operations to be performed on User entity.
 */
public interface UserDao {
    // Saves a new User
    String saveUser(User user);

    /**
     * Retrieves User based on emailId.
     * @param emailId
     * @return User object
     */
    User getUser(String emailId);

    // Update User (matched by emailId)
    void updateUser(User user);

    // Delete User by emailId
    void deleteUser(String emailId);

    List<User> getUsers();
}


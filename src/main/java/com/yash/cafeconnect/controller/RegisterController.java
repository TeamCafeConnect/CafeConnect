package com.yash.cafeconnect.controller;


import com.yash.cafeconnect.config.ViewResolver;
import com.yash.cafeconnect.dao.UserDao;
import com.yash.cafeconnect.entity.User;
import com.yash.cafeconnect.entity.enums.UserRoles;
import com.yash.cafeconnect.service.UserService;
import com.yash.cafeconnect.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/login")
public class RegisterController extends HttpServlet {

    private UserService userService;

    public RegisterController() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");
        String name=request.getParameter("name");
        String mobileNo=request.getParameter("mobileNo");
        int officeId=Integer.parseInt(request.getParameter("officeId"));
        User user=new User(emailId,name,mobileNo,password,officeId, UserRoles.CUSTOMER);

    }


}

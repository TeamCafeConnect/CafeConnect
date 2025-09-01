package com.yash.cafeconnect.controller;


import com.yash.cafeconnect.config.ViewResolver;
import com.yash.cafeconnect.entity.User;
import com.yash.cafeconnect.entity.dto.UserLoginModel;
import com.yash.cafeconnect.entity.enums.UserRoles;
import com.yash.cafeconnect.service.UserService;
import com.yash.cafeconnect.serviceImpl.UserServiceImpl;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginController extends HttpServlet {

    private UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");
        UserLoginModel userLoginModel=userService.authenticateUser(emailId,password);
        RequestDispatcher dispatcher;

        if(userLoginModel.getMessage().equals("SUCCESS"))
        {
            UserRoles userRoles=userLoginModel.getUser().getUserRoles();
            User user=userLoginModel.getUser();
            request.getSession().setAttribute("user", user);

            if(userRoles.equals(UserRoles.CUSTOMER))
            {
                dispatcher = request.getRequestDispatcher("user_dashboard.jsp");

            }else if(userRoles.equals(UserRoles.ADMIN))
            {
                dispatcher = request.getRequestDispatcher("admin.jsp");

            }else {
                dispatcher = request.getRequestDispatcher("cafe_dashboard.jsp");
            }
        }else {
            request.setAttribute("message",userLoginModel.getMessage());
            dispatcher = request.getRequestDispatcher("login.jsp");
        }

        dispatcher.forward(request, response);
    }
}

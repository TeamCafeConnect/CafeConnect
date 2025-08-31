package com.yash.cafeconnect.controller;


import com.yash.cafeconnect.config.ViewResolver;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ViewResolver.forward(request, response, "Login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");

        // This is dummy implementation need to connect with service
        if ("admin@yash.com".equals(emailId) && "admin123".equals(password)) {
            request.setAttribute("emailId", emailId);
            ViewResolver.forward(request, response, "home");
        } else {
            request.setAttribute("error", "Invalid username or password!");
            ViewResolver.forward(request, response, "login");
        }
    }


}

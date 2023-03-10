package com.example.demo.controller.servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.controller.ModelFactoryController;
import com.example.demo.models.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SvIndex", value = "/login")
public class SvIndex extends HttpServlet {
    private ModelFactoryController mfc = ModelFactoryController.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Map<String, String> error = new HashMap<>();

        if (email == null || email.isBlank() ){
            error.put("email", "Por favor ingrese el email");
        }
        if (password == null || password.isBlank()){
            error.put("password", "Por favor ingrese la contraseña");
        }
        if (!mfc.login(email, password)){
            error.put("invalid", "Datos inválidos");
        }else if(error.isEmpty()){
            response.sendRedirect("main.jsp");
        }
        else{
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
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

@WebServlet(name = "SvIndex", urlPatterns = "/login")
public class SvIndex extends HttpServlet {
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    Map<String, Book> books = mfc.loadBooks();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        System.out.println("oe sapo");
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
            System.out.println("Validando");
        }else if(error.isEmpty()){
            System.out.println("melo");
            HttpSession session = request.getSession();
            session.setAttribute("bookList", books);
            response.sendRedirect("main.jsp");
        }
        else{
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
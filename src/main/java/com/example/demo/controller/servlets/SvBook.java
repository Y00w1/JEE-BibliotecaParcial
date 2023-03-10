package com.example.demo.controller.servlets;

import com.example.demo.controller.ModelFactoryController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Biblioteca", value = "/book")
public class SvBook extends HttpServlet {
    public ModelFactoryController mfc = ModelFactoryController.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String units = req.getParameter("units");

        Map<String, String> errors = new HashMap<String, String>();

        if (title == null || title.isBlank()){
            errors.put("title", "Este campo es requerido");
        }
        if (author == null || author.isBlank()) {
            errors.put("author", "Campo requerido");
        }
        if (units == null || units.isBlank()) {
            errors.put("units", "Campo requerido");
        }if (errors.isEmpty()) {
            mfc.saveBook(title, author, units);
            resp.sendRedirect("main.jsp");
        }else{
            req.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/book.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


}

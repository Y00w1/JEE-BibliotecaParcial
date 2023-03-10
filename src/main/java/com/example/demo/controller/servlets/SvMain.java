package com.example.demo.controller.servlets;

import com.example.demo.controller.ModelFactoryController;
import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.mysql.cj.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Biblioteca", value = "/main")
public class SvMain extends HttpServlet {
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    Map<String, Book> books = mfc.loadBooks();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String idBook = req.getParameter("idBook");
        Book book = mfc.findBook(idBook);
        User user = mfc.getUser();

        HttpSession session = req.getSession();
        session.setAttribute("bookList", books);

        mfc.makeLoan(user, book);
        PrintWriter out = resp.getWriter();
        String mensaje = "El prestamo se ha efectuado";
        String ventanaEmergente = "<script>alert('" + mensaje + "');</script>";
        out.println(ventanaEmergente);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        HttpSession session = req.getSession();
        session.setAttribute("bookList", books);
        super.doGet(req, resp);
    }


}

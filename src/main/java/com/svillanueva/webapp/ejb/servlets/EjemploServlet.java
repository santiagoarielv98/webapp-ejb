package com.svillanueva.webapp.ejb.servlets;

import com.svillanueva.webapp.ejb.service.ServiceEjb;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet({"/index", "/"})
public class EjemploServlet extends HttpServlet {

    @EJB
    private ServiceEjb serviceEjb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("saludo", serviceEjb.saludar("Sergio"));


        req.getRequestDispatcher("/index.jsp")
                .forward(req, resp);
    }
}

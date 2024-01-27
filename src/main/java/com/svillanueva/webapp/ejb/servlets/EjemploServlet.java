package com.svillanueva.webapp.ejb.servlets;

import com.svillanueva.webapp.ejb.service.ServiceEjb;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet({"/index", "/"})
public class EjemploServlet extends HttpServlet {

    @Inject
    private ServiceEjb serviceEjb;

    @Inject
    private ServiceEjb serviceEjb2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("service si es igual a service2: " + (serviceEjb.equals(serviceEjb2)));

        req.setAttribute("saludo", serviceEjb.saludar("Sergio"));

        req.setAttribute("saludo2", serviceEjb2.saludar("Santiago"));

        req.getRequestDispatcher("/index.jsp")
                .forward(req, resp);
    }
}

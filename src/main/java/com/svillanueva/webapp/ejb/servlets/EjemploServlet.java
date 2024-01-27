package com.svillanueva.webapp.ejb.servlets;

import com.svillanueva.webapp.ejb.service.ServiceEjb;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;


@WebServlet({"/index", "/"})
public class EjemploServlet extends HttpServlet {

//    @Inject
//    private ServiceEjb serviceEjb;
//
//    @Inject
//    private ServiceEjb serviceEjb2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceEjb serviceEjb;
        ServiceEjb serviceEjb2;

        try {
            InitialContext ctx = new InitialContext();
            serviceEjb = (ServiceEjb) ctx.lookup("java:global/webapp-ejb/ServiceEjb!com.svillanueva.webapp.ejb.service.ServiceEjb");
            serviceEjb2 = (ServiceEjb) ctx.lookup("java:global/webapp-ejb/ServiceEjb!com.svillanueva.webapp.ejb.service.ServiceEjb");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        System.out.println("service si es igual a service2: " + (serviceEjb.equals(serviceEjb2)));

        req.setAttribute("saludo", serviceEjb.saludar("Sergio"));

        req.setAttribute("saludo2", serviceEjb2.saludar("Santiago"));

        req.getRequestDispatcher("/index.jsp")
                .forward(req, resp);
    }
}

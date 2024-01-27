package com.svillanueva.webapp.ejb.service;


import jakarta.ejb.Stateless;

@Stateless
public class ServiceEjb {
    public String saludar(String nombre) {
        return "Hola que tal " + nombre;
    }
}

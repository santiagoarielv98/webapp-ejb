package com.svillanueva.webapp.ejb.service;


import jakarta.ejb.Stateful;
import jakarta.enterprise.context.RequestScoped;

@Stateful
@RequestScoped
public class ServiceEjb {

    private int contador;

    public String saludar(String nombre) {
        System.out.println("Imprimiendo desde el EJB: " + this);
        contador++;
        System.out.println("Contador: " + contador);
        return "Hola que tal " + nombre;
    }
}

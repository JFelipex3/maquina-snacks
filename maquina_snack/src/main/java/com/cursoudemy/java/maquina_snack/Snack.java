package com.cursoudemy.java.maquina_snack;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    
    private static int contadorSnacks = 0;
    private int idSnack;
    private String nombre;
    private double precio;

    public Snack() {
        this.idSnack = ++Snack.contadorSnacks;
    }

    public Snack(String nombre, double precio) {
        this(); // Llama al constructor sin parámetros para inicializar idSnack, debe se la primera línea del constructor
        this.nombre = nombre;
        this.precio = precio;
    }

    public static int getContadorSnacks() {
        return contadorSnacks;
    }

    public int getIdSnack() {
        return idSnack;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Snack {idSnack=" + idSnack + ", nombre=" + nombre + ", precio=" + precio + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, nombre, precio);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Snack other = (Snack) obj;

        return idSnack == other.idSnack && Double.compare(precio, other.precio) == 0 && Objects.equals(nombre, other.nombre);
    }
}

package com.jah.mi_playlist;

public class Cancion {

    private String titulo;
    private String nombre;
    private int cancion;

    public Cancion(){}

    public Cancion(String titulo, String nombre, int cancion) {
        this.titulo = titulo;
        this.nombre = nombre;
        this.cancion = cancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCancion() {
        return cancion;
    }

    public void setCancion(int cancion) {
        this.cancion = cancion;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "titulo='" + titulo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cancion=" + cancion +
                '}';
    }
}

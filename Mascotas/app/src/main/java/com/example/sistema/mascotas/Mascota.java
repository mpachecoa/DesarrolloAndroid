package com.example.sistema.mascotas;

import java.util.Date;

/**
 * Created by Sistema on 21/04/2017.
 */

public class Mascota {
    private String nombre;
    private int foto;
    private int favorito;

    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
        this.favorito = 0;
    }

    public Mascota(String nombre, int foto, int favorito) {
        this.nombre   = nombre;
        this.foto     = foto;
        this.favorito = 0;
        this.favorito = favorito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

}

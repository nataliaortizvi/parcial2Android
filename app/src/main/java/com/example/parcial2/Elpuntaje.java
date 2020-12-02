package com.example.parcial2;

public class Elpuntaje {
    String id;
    int puntaje;

    public Elpuntaje() {
    }

    public Elpuntaje(String id, int puntaje) {
        this.id = id;
        this.puntaje = puntaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}

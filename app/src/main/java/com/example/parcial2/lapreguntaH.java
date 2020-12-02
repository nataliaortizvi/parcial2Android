package com.example.parcial2;

public class lapreguntaH {

    String pregunta, id;

    public lapreguntaH() {
    }

    public lapreguntaH(String pregunta, String id) {
        this.pregunta = pregunta;
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

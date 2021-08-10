package com.example.amst_7.Libros;

public class Detalle_libro {
    private String titulo;
    private String detalle_libro;
    private int img;
    //No tocar :p
    public Detalle_libro(String titulo, String detalle_libro, int img) {
        this.titulo = titulo;
        this.detalle_libro = detalle_libro;
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle_libro() {
        return detalle_libro;
    }

    public void setDetalle_libro(String detalle_libro) {
        this.detalle_libro = detalle_libro;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

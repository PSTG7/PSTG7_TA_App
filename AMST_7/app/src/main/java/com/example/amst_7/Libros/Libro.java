package com.example.amst_7.Libros;

import android.view.LayoutInflater;

import java.io.Serializable;

public class Libro implements Serializable {

    private static LayoutInflater insflater = null;

    private String titulo;
    private String autor;
    private String editor;
    private String detalle;
    private int imgId;

    public Libro(String titulo, String autor, String editor, int imgId, String detalle){
        this.titulo = titulo;
        this.autor = autor;
        this.editor = editor;
        this.imgId = imgId;
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}

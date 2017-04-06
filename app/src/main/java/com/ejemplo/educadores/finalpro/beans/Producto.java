package com.ejemplo.educadores.finalpro.beans;

import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Educadores on 03/11/2016.
 */


/*CAMBIAR TODA ESTA CLASE PARA QUE CONTENGA DATOS DE TIPO ARRAY*/


public class Producto extends RecyclerView.LayoutManager {

    private String nombre;
    private float precio;

    public Producto(){

    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return null;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }



    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }


}




/*

public class Producto extends ArrayList<> {

    // public static  nombre;
    public static String nombre;
    public static float precio;

    public Producto (String nombre) {

        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto (float precio) {

        this.precio = precio;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio=precio;
    }

    public Producto() {
    }
}*/

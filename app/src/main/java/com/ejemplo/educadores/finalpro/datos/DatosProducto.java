package com.ejemplo.educadores.finalpro.datos;

import android.support.v7.widget.RecyclerView;

import com.ejemplo.educadores.finalpro.beans.Producto;

import java.util.ArrayList;

/**
 * Created by Educadores on 02/11/2016.
 */



public class DatosProducto {

    private static Producto producto;


    public static ArrayList<Producto> getListaProductos() {

        return listaProductos;
    }

    public static void setListaProductos(ArrayList<Producto> listaProductos) {
        DatosProducto.listaProductos = listaProductos;
    }

    private static ArrayList<Producto>listaProductos;


    public static Producto getProducto() {

        return producto;
    }

    public static void setProducto(Producto producto) {

        DatosProducto.producto = producto;
    }




}


// Datosproducto.getListaProductos;    ´No necesito adaptador solo poner el get en el metodo que saque la lista de productos



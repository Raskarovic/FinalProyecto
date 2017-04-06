package com.ejemplo.educadores.finalpro.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de datos estático para alimentar la aplicación
 */
public class Comida {
    private float precio;
    private String nombre;
    private int idDrawable;

    public Comida(float precio, String nombre, int idDrawable) {
        this.precio = precio;
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public static final List<Comida> COMIDAS_POPULARES = new ArrayList<Comida>();
    public static final List<Comida> BEBIDAS = new ArrayList<>();
    public static final List<Comida> POSTRES = new ArrayList<>();
    public static final List<Comida> PLATILLOS = new ArrayList<>();

    static {
        COMIDAS_POPULARES.add(new Comida(5, "Camarones Tismados", com.ejemplo.educadores.finalpro.R.drawable.camarones));
        COMIDAS_POPULARES.add(new Comida(3.2f, "Rosca Herbárea", com.ejemplo.educadores.finalpro.R.drawable.rosca));
        COMIDAS_POPULARES.add(new Comida(12f, "Sushi Extremo", com.ejemplo.educadores.finalpro.R.drawable.sushi));
        COMIDAS_POPULARES.add(new Comida(9, "Sandwich Deli", com.ejemplo.educadores.finalpro.R.drawable.sandwich));
        COMIDAS_POPULARES.add(new Comida(34f, "Lomo De Cerdo Austral", com.ejemplo.educadores.finalpro.R.drawable.lomo_cerdo));

        PLATILLOS.add(new Comida(5, "Camarones Tismados", com.ejemplo.educadores.finalpro.R.drawable.camarones));
        PLATILLOS.add(new Comida(3.2f, "Rosca Herbárea", com.ejemplo.educadores.finalpro.R.drawable.rosca));
        PLATILLOS.add(new Comida(12f, "Sushi Extremo", com.ejemplo.educadores.finalpro.R.drawable.sushi));
        PLATILLOS.add(new Comida(9, "Sandwich Deli", com.ejemplo.educadores.finalpro.R.drawable.sandwich));
        PLATILLOS.add(new Comida(34f, "Lomo De Cerdo Austral", com.ejemplo.educadores.finalpro.R.drawable.lomo_cerdo));

        BEBIDAS.add(new Comida(3, "Taza de Café", com.ejemplo.educadores.finalpro.R.drawable.cafe));
        BEBIDAS.add(new Comida(12, "Coctel Tronchatoro", com.ejemplo.educadores.finalpro.R.drawable.coctel));
        BEBIDAS.add(new Comida(5, "Jugo Natural", com.ejemplo.educadores.finalpro.R.drawable.jugo_natural));
        BEBIDAS.add(new Comida(24, "Coctel Jordano", com.ejemplo.educadores.finalpro.R.drawable.coctel_jordano));
        BEBIDAS.add(new Comida(30, "Botella Vino Tinto Darius", com.ejemplo.educadores.finalpro.R.drawable.vino_tinto));

        POSTRES.add(new Comida(2, "Postre De Vainilla", com.ejemplo.educadores.finalpro.R.drawable.postre_vainilla));
        POSTRES.add(new Comida(3, "Flan Celestial", com.ejemplo.educadores.finalpro.R.drawable.flan_celestial));
        POSTRES.add(new Comida(2.5f, "Cupcake Festival", com.ejemplo.educadores.finalpro.R.drawable.cupcakes_festival));
        POSTRES.add(new Comida(4, "Pastel De Fresa", com.ejemplo.educadores.finalpro.R.drawable.pastel_fresa));
        POSTRES.add(new Comida(5, "Muffin Amoroso", com.ejemplo.educadores.finalpro.R.drawable.muffin_amoroso));
    }

    public float getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }
}

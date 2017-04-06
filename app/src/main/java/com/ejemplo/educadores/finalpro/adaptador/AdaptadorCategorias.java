

package com.ejemplo.educadores.finalpro.adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ejemplo.educadores.finalpro.R;
import com.ejemplo.educadores.finalpro.beans.Producto;
import com.ejemplo.educadores.finalpro.datos.DatosProducto;
import com.ejemplo.educadores.finalpro.modelo.Comida;

import java.util.ArrayList;
import java.util.List;

//import finalpro.ejemplo.educadores.finalpro.R;

//import com.albertohdez.seas.menulateralfrgmentosprueba.beans.Recoge;

// Adaptador para comidas usadas en la sección "Categorías"

public class AdaptadorCategorias
        extends RecyclerView.Adapter<AdaptadorCategorias.ViewHolder> {
    //private ArrayList<String> carrito;
  //  ArrayList carrito=new ArrayList();

    private final List<Comida> items;
    private ArrayList<Producto>lstProductos=new ArrayList<>();
    private static Context padre;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView precio;
        public ImageView imagen;

        public ViewHolder(View v) {
            super(v);

            nombre = (TextView) v.findViewById(R.id.nom_comida);
            precio = (TextView) v.findViewById(R.id.prec_comida);
            imagen = (ImageView) v.findViewById(R.id.miniatura_comida);

            padre = v.getContext();
        }
    }


    public AdaptadorCategorias(List<Comida> items) {
        this.items = items;
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_categorias, viewGroup, false);
        return new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Comida item = items.get(i);



        Glide.with(viewHolder.itemView.getContext())
                .load(item.getIdDrawable())
                .centerCrop()
                .into(viewHolder.imagen);
        viewHolder.nombre.setText(item.getNombre());
        viewHolder.precio.setText( item.getPrecio() + " €");


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //AQUI MARCA EL PRODUCTO SELECCIONADO
                Toast.makeText(padre, item.getNombre() + " " + item.getPrecio(), Toast.LENGTH_LONG).show();
                Producto miProducto=new Producto();
               // ArrayList<Producto> miProducto=new ArrayList<Producto>();
                miProducto.setNombre(item.getNombre());
                miProducto.setPrecio(item.getPrecio());// modificado y añadido esto
                DatosProducto.setProducto(miProducto);
                lstProductos.add(miProducto);
                DatosProducto.setListaProductos(lstProductos);





            }

            private Context getBaseContext() {
                return null;
            }
        });


    }


}
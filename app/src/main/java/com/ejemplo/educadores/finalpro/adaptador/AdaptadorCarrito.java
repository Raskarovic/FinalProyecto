package com.ejemplo.educadores.finalpro.adaptador;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ejemplo.educadores.finalpro.R;
import com.ejemplo.educadores.finalpro.beans.Producto;
import com.ejemplo.educadores.finalpro.datos.DatosProducto;

import java.util.ArrayList;




public class AdaptadorCarrito extends RecyclerView.Adapter<AdaptadorCarrito.ViewHolder> {

    private ArrayList<DatosProducto> lista = new ArrayList<>();
    private static Context padre;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nomcomida;
        public TextView precomida;


        public ViewHolder(View v) {
            super(v);
            nomcomida = (TextView) v.findViewById(R.id.nombrecomida);
            precomida = (TextView) v.findViewById(R.id.preciocomida);
            padre = v.getContext();
        }
    }
    public AdaptadorCarrito() {


    }
    @Override
    public int getItemCount() {

        return lista.size();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragmento_compra, viewGroup, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

      /*  final Comida item = items.get(i);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getIdDrawable())
                .centerCrop()
                .into(viewHolder.imagen);
        viewHolder.nombre.setText(item.getNombre());*/





            DatosProducto item = lista.get(i);
            Glide.with(viewHolder.itemView.getContext())
                .load(item.getProducto())
                .centerCrop();
            viewHolder.itemView.getContext();


           viewHolder.nomcomida.setText((CharSequence) item.getProducto());

          // viewHolder.precomida.setText(item.getPrecio() + " €");
       // }

    }


}









package com.ejemplo.educadores.finalpro.fragmentos;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


//import com.albertohdez.seas.menulateralfrgmentosprueba.R;
import com.ejemplo.educadores.finalpro.R;
import com.ejemplo.educadores.finalpro.adaptador.AdaptadorCarrito;
import com.ejemplo.educadores.finalpro.datos.DatosProducto;





// Fragmento del carrito
public class FragmentoCarrito extends Fragment {


    protected static FragmentoCarrito fragmentoCarrito;
    private AdaptadorCarrito adaptador;
    private RecyclerView recicla;
    private LinearLayoutManager layoutManager;

    public TextView txtUser;
   // public RecyclerView txtUser;

    public FragmentoCarrito() {


    }

    public static FragmentoCarrito newInstance(Bundle datos) {
        if (fragmentoCarrito == null) {
            fragmentoCarrito =
                    new FragmentoCarrito();
        }

        if (datos != null) {
            fragmentoCarrito.setArguments(datos);
        }
        return fragmentoCarrito;


    }

    public void setArguments(Bundle datos) {

    }



    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_carrito, container, false);


        recicla=(RecyclerView)view.findViewById(R.id.cambiador);
        layoutManager=new LinearLayoutManager(getActivity());
        recicla.setLayoutManager(layoutManager);

        adaptador=new AdaptadorCarrito();

        recicla.setAdapter(adaptador);

      //  txtUser = (RecyclerView) view.findViewById(R.id.txtProducto);
      //  txtUser = (TextView) view.findViewById(R.id.txtProducto);
       // txtUser=(RecyclerView)view.findViewById(R.id.cambiador);

        return view;

    }

     /*    @Override
       public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            DatosProducto.getListaProductos();

         // LA SIGUIENTE LINEA FORMA PARTE DE LA PROGRAMACION ANTERIOR (FUNCIONA)
          txtUser.setText(DatosProducto.getProducto());
         //   txtUser.setText(DatosProducto.getProducto());
         //txtUser.setLayoutManager(DatosProducto.getProducto());
          //  txtNombre.setText(DatosProducto.getProducto().getNombre());
         //   txtPrecio.setText((int) DatosProducto.getProducto().getPrecio());

        }*/


    }









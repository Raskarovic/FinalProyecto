package com.ejemplo.educadores.finalpro.fragmentos;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ejemplo.educadores.finalpro.R;
import com.ejemplo.educadores.finalpro.beans.Local;
import com.ejemplo.educadores.finalpro.datos.GrouponData;
import com.ejemplo.educadores.finalpro.tools.Post;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentoMapa extends Fragment implements OnMapReadyCallback{
    /**
     * Este argumento del fragmento representa el título de cada
     * sección
     */
    public static final String ARG_SECTION_TITLE = "MAPA";
    private static FragmentoMapa fragmentoMapa;
    private GoogleMap mMap;
    private MapView mapa;
    public FragmentoMapa() {
        // Required empty public constructor
    }

    public static FragmentoMapa newInstance(Bundle datos){
        if(fragmentoMapa==null){
            fragmentoMapa =
                    new FragmentoMapa();
        }

        if(datos!=null){
            fragmentoMapa.setArguments(datos);
        }
        return fragmentoMapa;
    }
    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        TareaSegundoPlano tarea = new TareaSegundoPlano();
        tarea.execute("http://raskarevic.x10host.com/ofertas.php/");


    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapsInitializer.initialize(getActivity());
    }

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_fragmento_mapa,
                container, false);
        return vista;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private SupportMapFragment mapFragment;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setUpMap() {
        if (mMap != null) {
            // CORREGIR POSICION INICIAL DE GOOGLEMAPS
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(43.462178, -3.809991),15 )); //41.6697563, -0.8810787), 15));
        }

    }

    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {
        private ArrayList<Local> listaLocales = null;
        private HashMap<String, String> parametros = null;


        public TareaSegundoPlano(HashMap<String, String> parametros) {
            this.parametros = parametros;
        }

        public TareaSegundoPlano() {
        }

        /*
         * doInBackground().
         * Contendrá el código principal de nuestra tarea.
         * */
        @Override
        //este String es el que le pasamos arriba, en AsyncTask
        protected Boolean doInBackground(String... params) {
            String url_select = params[0];

            try {
                //crea el post
                Post post = new Post();
                // metemos en un array de json
                JSONArray result = post.getServerDataGet(url_select);
                listaLocales = Local.getArrayListFromJSon(result);
                GrouponData.setLstLocales(listaLocales);
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
                //messageUser = "Error al conectar con el servidor. ";
            }

            return true;
        }

        /*
         * onPostExecute().
         * Se ejecutará cuando finalice nuestra tarea, o dicho de otra forma,
         * tras la finalización del método doInBackground().
         * */
        @Override
        protected void onPostExecute(Boolean resp) {
            try {
                ArrayList<Local> lstLocales = GrouponData.getLstLocales();
                if (resp && listaLocales != null && listaLocales.size() > 0) {
                    Local local = null;
                    for (int i = 0; i < lstLocales.size(); i++) {
                        local = lstLocales.get(i);
                        Double lati = Double.parseDouble(local.getLocalLatitud());
                        Double longi = Double.parseDouble(local.getLocalLongitud());
                        mMap.addMarker(new MarkerOptions().position(new LatLng(longi, lati)).title(local.getLocalName())
                                .snippet(local.getLocalDescription())

                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurante)));
                    }

                } else {
                    Toast.makeText(getActivity().getBaseContext(), "" +
                            "Lista incorrecta. ", Toast.LENGTH_SHORT).show();
                }

                // Uno cada punto con el anterior
                //1º punto
                Local local1 = lstLocales.get(0);
                // Os recuerdo que nos vienen invertidas
                for (int i = 1; i < lstLocales.size(); i++) {
                    Double lati1 = Double.parseDouble(local1.getLocalLongitud());
                    Double longi1 = Double.parseDouble(local1.getLocalLatitud());

                    Local local2 = lstLocales.get(i);
                    Double lati2 = Double.parseDouble(local2.getLocalLongitud());
                    Double longi2 = Double.parseDouble(local2.getLocalLatitud());

                    PolylineOptions lineas = new PolylineOptions()
                            .add(new LatLng(lati1, longi1))
                            .add(new LatLng(lati2, longi2));

                    lineas.width(8);
                    lineas.color(Color.RED);

                    mMap.addPolyline(lineas);
                    // Me guardo el punto anterior
                    local1 = local2;
                }

                // Establezo la cámara del móvil
                setUpMap();
            } catch (Exception e) {

                Log.e("log_tag", "Error parsing data " + e.toString());
            }
        }
    }
}

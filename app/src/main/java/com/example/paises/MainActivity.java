package com.example.paises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.paises.Adaptadores.PaisAdapter;
import com.example.paises.Models.Pais;
import com.example.paises.Models.Respuesta;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    ArrayList <Pais> lstPaises= new ArrayList<Pais> ();
    RequestQueue requestCola;
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recicler_paises);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        requestCola = Volley.newRequestQueue(this);
        requestCola.start();
        obtenerDataPaises();
    }
    public void obtenerDataPaises(){
        String url = "http://www.geognos.com/api/en/countries/info/all.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Respuesta respuesta= objectMapper.readValue(response, Respuesta.class);
                            lstPaises= Pais.JsonObjectsBuild(respuesta);

                            int resId = R.anim.layout_animation_down_to_up;
                            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                                    resId);
                            recyclerView.setLayoutAnimation(animation);


                            PaisAdapter adaptadorPais = new PaisAdapter(MainActivity.this, lstPaises);
                            recyclerView.setAdapter(adaptadorPais);
                        } catch (JsonProcessingException e) {
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                });
        requestCola.add(stringRequest);
    }
}
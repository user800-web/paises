package com.example.paises.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.paises.Models.Pais;
import com.example.paises.R;

import java.util.List;

public class PaisAdapter extends RecyclerView.Adapter<PaisAdapter.PaisViewHolder> {
    private Context Ctx;
    private List<Pais> lista_paises;

    public PaisAdapter(Context mCtx, List<Pais> paises) {
        this.lista_paises = paises;
        Ctx = mCtx;
    }

    @Override
    public PaisAdapter.PaisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.ly_pais, null);
        return new PaisAdapter.PaisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PaisAdapter.PaisViewHolder holder, int position) {
        Pais pais = lista_paises.get(position);
        holder.txtNombrePais.setText("Nombre del país: "+pais.getName());
        holder.txtAbreviatura.setText("Capital: "+pais.getCapital());
        holder.txtTelPref.setText("Prefijo telefónico: "+pais.getTelPref());
        holder.txtCountryInfo.setText("Link de información: "+pais.getCountryInfo());

        Glide.with(Ctx)
                .load(pais.getUrlBandera())
                .into(holder.imgBandera);
    }

    @Override
    public int getItemCount() {
        return lista_paises.size();
    }

    class PaisViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombrePais;
        TextView txtAbreviatura;
        TextView txtTelPref;
        TextView txtCountryInfo;
        ImageView imgBandera;
        public PaisViewHolder(View itemView) {
            super(itemView);
            imgBandera = itemView.findViewById(R.id.imgBandera);
            txtNombrePais = itemView.findViewById(R.id.txtNombrePais);
            txtAbreviatura = itemView.findViewById(R.id.txtAbreviatura);
            txtTelPref = itemView.findViewById(R.id.txtTelPref);
            txtCountryInfo = itemView.findViewById(R.id.txtCountryInfo);
        }

    }
}

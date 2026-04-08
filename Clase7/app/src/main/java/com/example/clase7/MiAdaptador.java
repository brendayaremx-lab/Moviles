package com.example.clase7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiViewHolder> {

    private ArrayList<String> nombres;

    //constructor ahora recibe arreglo
    public MiAdaptador(ArrayList<String> listaNombres) {
        nombres = listaNombres;
    }

    @Override
    public MiViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);
        return new MiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MiViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(nombres.get(position));
    }

    @Override
    public int getItemCount() {
        return nombres.size();
    }


    public void agregarNombre(String nombre) {
        nombres.add(nombre);
        notifyItemInserted(nombres.size() - 1); //nuevo item
    }
}




package com.example.clase12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase12.R;
import com.example.clase12.Asistencia;

import java.util.List;

public class AsistenciaAdapter extends RecyclerView.Adapter<AsistenciaAdapter.AsistenciaViewHolder> {

    private List<Asistencia> lista;

    public AsistenciaAdapter(List<Asistencia> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public AsistenciaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_asistencia, parent, false);
        return new AsistenciaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsistenciaViewHolder holder, int position) {
        Asistencia asistencia = lista.get(position);
        holder.tvFecha.setText(asistencia.fecha);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class AsistenciaViewHolder extends RecyclerView.ViewHolder {
        TextView tvFecha;

        public AsistenciaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFecha = itemView.findViewById(R.id.tvFecha);
        }
    }
}
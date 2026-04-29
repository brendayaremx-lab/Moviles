package com.example.clase12;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase12.R;
import com.example.clase12.Alumno;

import java.util.List;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {

    private List<Alumno> lista;
    private OnAlumnoClick listener;

    public interface OnAlumnoClick {
        void onClick(Alumno alumno);
    }

    public AlumnoAdapter(List<Alumno> lista, OnAlumnoClick listener) {
        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_alumno, parent, false);
        return new AlumnoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder holder, int position) {
        Alumno alumno = lista.get(position);
        holder.tvNombre.setText(alumno.nombre);
        holder.tvApellidoPaterno.setText(alumno.apellidoPaterno);
        holder.tvApellidoMaterno.setText(alumno.apellidoMaterno);
        holder.itemView.setOnClickListener(v -> listener.onClick(alumno));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class AlumnoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvApellidoPaterno, tvApellidoMaterno;

        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellidoPaterno = itemView.findViewById(R.id.tvApellidoPaterno);
            tvApellidoMaterno = itemView.findViewById(R.id.tvApellidoMaterno);
        }
    }
}

package com.example.clase12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase12.R;
import com.example.clase12.Curso;

import java.util.List;

public class CursoAdapter extends RecyclerView.Adapter<CursoAdapter.CursoViewHolder> {

    private List<Curso> lista;
    private OnCursoClick listener;

    public interface OnCursoClick {
        void onClick(Curso curso);
    }

    public CursoAdapter(List<Curso> lista, OnCursoClick listener) {
        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CursoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_curso, parent, false);
        return new CursoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CursoViewHolder holder, int position) {
        Curso curso = lista.get(position);
        holder.tvClave.setText(curso.clave);
        holder.tvNombreCurso.setText(curso.nombre);
        holder.itemView.setOnClickListener(v -> listener.onClick(curso));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class CursoViewHolder extends RecyclerView.ViewHolder {
        TextView tvClave, tvNombreCurso;

        public CursoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClave = itemView.findViewById(R.id.tvClave);
            tvNombreCurso = itemView.findViewById(R.id.tvNombreCurso);
        }
    }
}
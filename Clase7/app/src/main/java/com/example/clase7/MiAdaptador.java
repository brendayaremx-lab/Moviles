package com.example.clase7;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

//miAdaptador es la clase que conecta los datos y el recycleView
public class MiAdaptador extends RecyclerView.Adapter<MiViewHolder> {

    private ArrayList<Personaje> localDataSet;

    public MiAdaptador(ArrayList<Personaje> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MiViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new MiViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MiViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Personaje personaje = localDataSet.get(position);
        // Aqui el set de datos
        String name = personaje.getName();
        viewHolder.getTextView().setText(name);

        String url = personaje.getPhoto();
        // Aqui la imagen
        Glide
                .with(viewHolder.itemView.getContext())
                .load(url)
                .centerCrop()
                .into(viewHolder.getImageView());

        //clicl para los detalles
        viewHolder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetalleActivity.class);
            intent.putExtra("name", personaje.getName());
            intent.putExtra("desc", personaje.getDesc());
            intent.putExtra("photo", personaje.getPhoto());
            intent.putExtra("atack", personaje.getAtack());
            intent.putExtra("def", personaje.getDef());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public void addElemento(Personaje newElement) {
        localDataSet.add(newElement);
    }
}

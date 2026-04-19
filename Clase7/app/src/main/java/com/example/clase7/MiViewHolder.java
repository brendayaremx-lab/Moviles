package com.example.clase7;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;


//MiViewHolder representa visualmente a solo un item de la lista
//recyclerView reutiliza los viewHolders  cuando haces scroll (por eso se llama recicler)
    //scroll es cuando el contenido no cabe en la pantalla y le hags para abajo
//en lugar de crear una nueva vista por cada elemento recicla las que ya no se ven
public class MiViewHolder extends RecyclerView.ViewHolder {

    //TextView: elemento donde se muestra el video del nombre
    //es final porque siempre apunta al mismo TextView dentro de este item
    private final TextView textView;

    
    private ImageView imageView;

    public MiViewHolder(View view) {
        super(view);
        // Define click listener for the ViewHolder's View
        textView = (TextView) view.findViewById(R.id.textView);
        imageView = view.findViewById(R.id.imageView);
    }

    public TextView getTextView() {
        return textView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}

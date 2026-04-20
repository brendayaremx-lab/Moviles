package com.example.climabd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    //lista con los datos del clima
    private List<Weather> listaClima;

    // el constructor que recibe la lista de datos cuando se crea el adaptador
    public WeatherAdapter(List<Weather> listaClima) {
        this.listaClima = listaClima;
    }

    // el XML item_weather se hace en una vista real
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_weather, parent, false);
        return new ViewHolder(vista);
    }

    // position indica qué elemento de la lista se ve
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // traemos el objeto de la posición actual
        Weather w = listaClima.get(position);

        // el textView con los datos del objeto
        holder.tvFecha.setText("Fecha: " + w.fecha);
        holder.tvTemperatura.setText(w.temperatura + "°C");
        holder.tvCondicion.setText("Clima: " + w.condicion);
        holder.tvHumedad.setText("Humedad: " + w.humedad + "%");
        holder.tvViento.setText("Viento: " + w.vientoKph + " kph");
    }

    @Override
    public int getItemCount() {
        return listaClima.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFecha, tvTemperatura, tvCondicion, tvHumedad, tvViento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // findViewById conecta la variable con el elemento del xml
            tvFecha = itemView.findViewById(R.id.tvDate);
            tvTemperatura = itemView.findViewById(R.id.tvTemp);
            tvCondicion = itemView.findViewById(R.id.tvCondition);
            tvHumedad = itemView.findViewById(R.id.tvHumidity);
            tvViento = itemView.findViewById(R.id.tvWind);
        }
    }
}
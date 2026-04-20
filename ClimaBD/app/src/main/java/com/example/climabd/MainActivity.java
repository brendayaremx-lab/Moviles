package com.example.climabd;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "34db6d961bf240c4afe233021261904";
    private static final String CIUDAD = "Mexico City";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                // 1. Llamar a la API del clima de hoy
                String urlStr = "https://api.weatherapi.com/v1/current.json?key="
                        + API_KEY + "&q=" + CIUDAD.replace(" ", "%20");
                URL url = new URL(urlStr);
                HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                conexion.setRequestMethod("GET");

                BufferedReader lector = new BufferedReader(
                        new InputStreamReader(conexion.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String linea;
                while ((linea = lector.readLine()) != null) sb.append(linea);
                lector.close();

                // 2. Parsear JSON
                JSONObject json = new JSONObject(sb.toString());
                JSONObject actual = json.getJSONObject("current");
                JSONObject condicion = actual.getJSONObject("condition");

                double temperatura = actual.getDouble("temp_c");
                String condicionTexto = condicion.getString("text");
                int humedad = actual.getInt("humidity");
                double viento = actual.getDouble("wind_kph");
                String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm",
                        Locale.getDefault()).format(new Date());

                // 3. Guardar en Room
                WeatherDao dao = AppDatabase.getInstance(this).weatherDao();
                Weather clima = new Weather(CIUDAD, temperatura, condicionTexto,
                        humedad, viento, fecha);
                dao.insertar(clima);
                Log.i("WeatherDB", "Guardado: " + temperatura + "°C");

                // 4. Mostrar historial en pantalla
                List<Weather> historial = dao.obtenerTodos();
                runOnUiThread(() -> {
                    WeatherAdapter adaptador = new WeatherAdapter(historial);
                    recyclerView.setAdapter(adaptador);
                });

            } catch (Exception e) {
                Log.e("WeatherDB", "Error: " + e.getMessage());
            }
        });
    }
}
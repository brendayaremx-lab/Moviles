package com.example.clase7;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MiCliente {

    private String url = "https://steadfast-essence-funcion.up.railway.app/api/characters";

    OkHttpClient client = new OkHttpClient();

    private ArrayList<String> run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String respuesta = response.body().string();

            ArrayList<String> elementos = new ArrayList<>();
            JSONArray array = new JSONArray(respuesta);

            for (int i = 0; i < array.length(); i++) {
                String elemento = array.getString(i);
                elementos.add(elemento);
            }
            return elementos;

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getElements() {
        try {
            return run(url);
        } catch (IOException e) {
            Log.e("bren", "Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
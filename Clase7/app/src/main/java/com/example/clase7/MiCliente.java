package com.example.clase7;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class MiCliente {

    private String url = "https://steadfast-essence-funcion.up.railway.app/api/characters";
    OkHttpClient client = new OkHttpClient();

    public ArrayList<Personaje> getElements() {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            ArrayList<Personaje> elementos = new ArrayList<>();

            // CORRECCIÓN: Leemos directamente un JSONArray en lugar de un JSONObject
            JSONArray array = new JSONArray(response.body().string());

            for (int i = 0; i < array.length(); i++){ // Simplificado el límite del for
                JSONObject elemento = array.getJSONObject(i);
                String name = elemento.getString("name");
                String desc = elemento.getString("desc");
                String photo = elemento.getString("photo");
                int atack = elemento.getInt("atack");
                int def = elemento.getInt("def");

                Personaje personaje = new Personaje(
                        name,
                        desc,
                        photo,
                        atack,
                        def
                );
                elementos.add(personaje);
            }
            return elementos;
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}

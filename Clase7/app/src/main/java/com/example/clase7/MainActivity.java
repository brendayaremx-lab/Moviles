package com.example.clase7;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MiAdaptador adaptador;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.my_recycler_view);
        editText = findViewById(R.id.ingresar);
        button = findViewById(R.id.button);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MiCliente miCliente = new MiCliente();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> misDatos = miCliente.getElements();
                runOnUiThread(() -> {
                    adaptador = new MiAdaptador(misDatos);
                    recyclerView.setAdapter(adaptador);
                });
            }
        });

        // Botón para agregar
        button.setOnClickListener(v -> {
            String nuevoNombre = editText.getText().toString().trim();
            if (!nuevoNombre.isEmpty() && adaptador != null) {
                adaptador.agregarNombre(nuevoNombre);
                editText.setText("");
                recyclerView.scrollToPosition(adaptador.getItemCount() - 1);
            }
        });
    }
}



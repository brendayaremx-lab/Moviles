package com.example.clase10;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.loader.content.AsyncTaskLoader;
import java.util.concurrent.Executors;


import java.util.List;

//main es la pantalla principal
//addCompatActitity es clase base de andoird para actividades con soporte de versiones anteriores
public class MainActivity extends AppCompatActivity {

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
        Executors.newSingleThreadExecutor().execute(() -> {
            UserDao userDao = AppDatabase.getInstance(this).userDao();
            userDao.insertAll(new User("Maria", "Felix"));
            List<User> usuarios = userDao.getAll();
            runOnUiThread(() -> {
                for (User user : usuarios) {
                    Log.i("Bren", "firstName: " + user.firstName);
                    Log.i("Bren", "lastName: " + user.lastName);
                    Log.i("Bren", "uid: " + user.uid);
                }
            });
        });
    }
}
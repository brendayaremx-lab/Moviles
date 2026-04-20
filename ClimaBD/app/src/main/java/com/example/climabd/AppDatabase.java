package com.example.climabd;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Weather.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {

    // instancia única de la base de datos
    private static AppDatabase instancia;

    // getinstance es para obtener la base de datos
    public static synchronized AppDatabase getInstance(Context context) {
        if (instancia == null) {
            // databaseBuilder crea el archivo de base de datos en el celular
            instancia = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "weather-db"
                    )
                    // nueva bd solo si cambia la estructura
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instancia;
    }

    public abstract WeatherDao weatherDao();
}
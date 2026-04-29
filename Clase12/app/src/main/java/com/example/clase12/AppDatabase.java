package com.example.clase12;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.clase12.AlumnoDao;
import com.example.clase12.AsistenciaDao;
import com.example.clase12.CursoDao;
import com.example.clase12.Alumno;
import com.example.clase12.Asistencia;
import com.example.clase12.Curso;

@Database(entities = {Curso.class, Alumno.class, Asistencia.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instancia;

    public abstract CursoDao cursoDao();
    public abstract AlumnoDao alumnoDao();
    public abstract AsistenciaDao asistenciaDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instancia == null) {
            instancia = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "clase12_db"
                    )
                    .allowMainThreadQueries()
                    .build();
        }
        return instancia;
    }
}
package com.example.clase12;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.clase12.Asistencia;

import java.util.List;

@Dao
public interface AsistenciaDao {

    @Insert
    void insertar(Asistencia asistencia);

    @Query("SELECT * FROM asistencias WHERE alumno_id = :alumnoId")
    List<Asistencia> obtenerPorAlumno(int alumnoId);
}
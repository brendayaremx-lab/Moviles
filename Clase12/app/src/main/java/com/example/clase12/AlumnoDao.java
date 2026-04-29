package com.example.clase12;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.clase12.Alumno;

import java.util.List;

@Dao
public interface AlumnoDao {

    @Insert
    void insertar(Alumno alumno);

    @Query("SELECT * FROM alumnos WHERE curso_id = :cursoId")
    List<Alumno> obtenerPorCurso(int cursoId);
}
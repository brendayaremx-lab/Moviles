package com.example.clase12;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.clase12.Curso;

import java.util.List;

@Dao
public interface CursoDao {

    @Insert
    void insertar(Curso curso);

    @Query("SELECT * FROM cursos")
    List<Curso> obtenerTodos();
}
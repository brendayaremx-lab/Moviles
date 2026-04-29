package com.example.clase12;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "alumnos")
public class Alumno {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "apellido_paterno")
    public String apellidoPaterno;

    @ColumnInfo(name = "apellido_materno")
    public String apellidoMaterno;

    @ColumnInfo(name = "curso_id")
    public int cursoId;
}
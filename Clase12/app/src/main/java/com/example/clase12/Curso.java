package com.example.clase12;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cursos")
public class Curso {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "clave")
    public String clave;

    @ColumnInfo(name = "nombre")
    public String nombre;
}
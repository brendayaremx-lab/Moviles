package com.example.clase12;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "asistencias")
public class Asistencia {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "fecha")
    public String fecha;

    @ColumnInfo(name = "alumno_id")
    public int alumnoId;
}
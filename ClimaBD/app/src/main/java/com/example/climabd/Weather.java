package com.example.climabd;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// @entity le dice a room que es una tabla en la base de datos
@Entity
public class Weather {

    // autoGenerate = da el id 1, 2, 3 y asi
    @PrimaryKey(autoGenerate = true)
    public int id;

    // @columnInfo pone el nombre de la columna en la base de datos
    @ColumnInfo(name = "ciudad")
    public String ciudad;

    @ColumnInfo(name = "temperatura")
    public double temperatura;

    @ColumnInfo(name = "condicion")
    public String condicion;

    @ColumnInfo(name = "humedad")
    public int humedad;

    @ColumnInfo(name = "viento_kph")
    public double vientoKph;

    // se guarda la fecha del día del clima histórico
    @ColumnInfo(name = "fecha")
    public String fecha;

    //el contructor para crear el objeti weather antes de guardarlo
    public Weather(String ciudad, double temperatura, String condicion,
                   int humedad, double vientoKph, String fecha) {
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.condicion = condicion;
        this.humedad = humedad;
        this.vientoKph = vientoKph;
        this.fecha = fecha;
    }
}
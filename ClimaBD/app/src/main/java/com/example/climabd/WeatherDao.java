package com.example.climabd;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface WeatherDao {

    @Insert
    void insertar(Weather weather);

    @Query("SELECT * FROM weather ORDER BY id DESC")
    List<Weather> obtenerTodos();

    @Query("DELETE FROM weather")
    void borrarTodos();
}
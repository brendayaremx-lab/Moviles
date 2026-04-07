package com.example.calculadora;

public class Operacion {
    Double x, y;
    OperationType type;

    public Operacion(Double x, Double y, OperationType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public Double getX() { return x; }
    public Double getY() { return y; }
    public OperationType getType() { return type; }
}
package com.example.calculadora;

import java.util.ArrayList;

public class ViewModel {

    //instanceamos para que haga lass cuentas basicas
    private ICalculadora calculadora = new Calculadora();

    public Double hacerOperacion(Operacion operacion) {
        if (operacion == null) return 0.0;

        switch (operacion.getType()) {
            case ADD:
                return calculadora.sum(operacion.getX(), operacion.getY());
            case MINUS:
                return calculadora.minus(operacion.getX(), operacion.getY());
            case MULTIPLY:
                return calculadora.multiply(operacion.getX(), operacion.getY());
            case DIV:
                return calculadora.divide(operacion.getX(), operacion.getY());
            default:
                return 0.0;
        }
    }

    //recibimos el paquete del builder
    public Double makeOperation(Operacion[] operaciones) {

        //si no hay nada, se pone 0
        if(operaciones == null || operaciones.length == 0) return 0.0;

        //dos listas para numeros y para signos
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<OperationType> signos = new ArrayList<>();

        // las listas en el arreglo de operaciones
        for (int i = 0; i < operaciones.length; i++) {
            if (i == 0) {
                numeros.add(operaciones[i].getX());
            }
            numeros.add(operaciones[i].getY());
            signos.add(operaciones[i].getType());
        }

        //jrarquia de operaciones
        //primero busca los x y /
        for(int i = 0; i < signos.size(); i ++ ){
            OperationType tipoActual = signos.get(i);

            if (tipoActual == OperationType.MULTIPLY || tipoActual == OperationType.DIV){

                Double resultadoProvisional = 0.0;

                //la calculadora hce la cuenta
                if(tipoActual == OperationType.MULTIPLY){
                    resultadoProvisional = calculadora.multiply(numeros.get(i), numeros.get(i + 1));
                } else {
                    resultadoProvisional = calculadora.divide(numeros.get(i), numeros.get(i + 1));
                }

                //ponemos el resultado donde estaba el primer numero
                numeros.set(i, resultadoProvisional);
                //quitamos el numero y el signo que sigue
                numeros.remove(i + 1);
                signos.remove(i);

                //para que i no se adelante
                i--;
            }
        }

        //otra para suma y resta
        Double resultadoFinal = numeros.get(0);

        for (int i = 0; i < signos.size(); i++){
            OperationType tipoActual = signos.get(i);

            if(tipoActual == OperationType.ADD){
                resultadoFinal = calculadora.sum(resultadoFinal, numeros.get(i + 1));
            } else if (tipoActual == OperationType.MINUS) {
                resultadoFinal = calculadora.minus(resultadoFinal, numeros.get(i + 1));
            }
        }

        return resultadoFinal;
    }
}
package com.example.calculadora;

import org.junit.Assert;
import org.junit.Test;

public class ViewModelTest {

    @Test
    public void testMakeOperationSuma(){
        ViewModel viewModel = new ViewModel();
        Operacion operacion = new Operacion(5.0, 5.0, OperationType.ADD);
        Double resultado = viewModel.hacerOperacion(operacion);
        Assert.assertEquals(10.0, resultado, 0.0);
    }

    @Test
    public void testMakeOperationMult(){
        ViewModel viewModel = new ViewModel();
        Operacion operacion = new Operacion(5.0, 5.0, OperationType.MULTIPLY);
        Double resultado = viewModel.hacerOperacion(operacion);
        Assert.assertEquals(25.0, resultado, 0.0);
    }

    @Test
    public void testMakeOperationsJerarquia(){
        // Esta prueba valida el 1 + 5 * 3
        ViewModel viewModel = new ViewModel();
        Operacion op1 = new Operacion(1.0, 5.0, OperationType.ADD);
        Operacion op2 = new Operacion(5.0, 3.0, OperationType.MULTIPLY);
        Double resultado = viewModel.makeOperation(new Operacion[]{ op1, op2 });
        Assert.assertEquals(16.0, resultado, 0.0);
    }
}
package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView txvResult, txvOperation;
    private String textoPantalla = "";
    private ViewModel miCerebro = new ViewModel();
    private List<Operacion> listaParaCalcular = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvResult = findViewById(R.id.txvResult);
        txvOperation = findViewById(R.id.txvOperation);

        conectarBotones();
    }

    private void conectarBotones(){
        int[] idsNumeros = {R.id.btnCero, R.id.btnUno,R.id.btnDos, R.id.btnTres, R.id.btnCuatro, R.id.btnCinco, R.id.btnSeis, R.id.btnSiete, R.id.btnOcho, R.id.btnNueve};

        View.OnClickListener vigilanteDeNumeros = v -> {
            Button botonPulsado = (Button) v;
            textoPantalla += botonPulsado.getText().toString();
            txvResult.setText(textoPantalla);
        };

        for (int id : idsNumeros){
            findViewById(id).setOnClickListener(vigilanteDeNumeros);
        }

        findViewById(R.id.btnSumar).setOnClickListener(v -> prepararOperacion(OperationType.ADD));
        findViewById(R.id.btnRestar).setOnClickListener(v -> prepararOperacion(OperationType.MINUS));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> prepararOperacion(OperationType.MULTIPLY));
        findViewById(R.id.btnDivide).setOnClickListener(v -> prepararOperacion(OperationType.DIV));

        findViewById(R.id.btnIgual).setOnClickListener(v -> mostrarResultado());
        findViewById(R.id.btnAC).setOnClickListener(v -> botonAC());
        findViewById(R.id.btnDelete).setOnClickListener(v -> borrar());
    }

    private String traducirSigno(OperationType tipo) {
        switch (tipo) {
            case ADD: return "+";
            case MINUS: return "-";
            case MULTIPLY: return "*";
            case DIV: return "/";
            default: return "";
        }
    }

    private void prepararOperacion(OperationType tipo){
        if (textoPantalla.isEmpty()) return;
        Double num = Double.parseDouble(textoPantalla);

        listaParaCalcular.add(new Operacion(num, 0.0, tipo));

        txvOperation.setText(txvOperation.getText().toString() + textoPantalla + " " + traducirSigno(tipo) + " ");
        textoPantalla = "";
        txvResult.setText("0");
    }

    private void mostrarResultado(){
        if (textoPantalla.isEmpty() || listaParaCalcular.isEmpty()) return;

        double ultimoNumero = Double.parseDouble(textoPantalla);

        Operacion[] opsArray = new Operacion[listaParaCalcular.size()];
        for (int i = 0; i < listaParaCalcular.size(); i++) {
            Operacion op = listaParaCalcular.get(i);
            double valorY = (i == listaParaCalcular.size() - 1) ? ultimoNumero : listaParaCalcular.get(i+1).getX();
            opsArray[i] = new Operacion(op.getX(), valorY, op.getType());
        }

        Double resultadoFinal = miCerebro.makeOperation(opsArray);

        txvResult.setText(String.valueOf(resultadoFinal));
        txvOperation.setText("");

        listaParaCalcular.clear();
        textoPantalla = String.valueOf(resultadoFinal);
    }

    private void borrar(){
        if (textoPantalla.length() > 0){
            textoPantalla = textoPantalla.substring(0, textoPantalla.length() -1);
            txvResult.setText(textoPantalla.isEmpty() ? "0" : textoPantalla);
        }
    }

    private void botonAC(){
        listaParaCalcular.clear();
        textoPantalla = "";
        txvResult.setText("0");
        txvOperation.setText("");
    }
}
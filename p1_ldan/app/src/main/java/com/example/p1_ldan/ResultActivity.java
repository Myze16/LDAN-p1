package com.example.p1_ldan;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Integer periodo = getIntent().getIntExtra("periodo", 0);
        double valorDesejado = getIntent().getDoubleExtra("ValorDesejado", 0);
        double taxa = getIntent().getDoubleExtra("taxa", 0);

        double resultado = this.calcularAposentadoria(valorDesejado, taxa, periodo);

        // pegar o elemento xml
        TextView valueDisplay = findViewById(R.id.amount);
        // setar resultado no elemento
        valueDisplay.setText(String.valueOf(resultado));
    }

    private double calcularAposentadoria(double fv, double i, int n) {

        //double resultado = (fv * i) / (((1 + i) ** n) - 1);
        double resultado = (fv * i) / (Math.pow((1 + i), n) - 1);
        return resultado;
    }
}
// C = (FV * i) / (((1 + i) ** n) - 1)
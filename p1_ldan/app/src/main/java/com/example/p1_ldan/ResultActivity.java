package com.example.p1_ldan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        int periodo = getIntent().getIntExtra("periodo", 0);
        double valorDesejado = getIntent().getDoubleExtra("valorDesejado", 0);
        double taxa = getIntent().getDoubleExtra("taxa", 0);

        double resultado = this.calcularAposentadoria(valorDesejado, taxa, periodo);

        TextView textResult = findViewById(R.id.resultado);
        textResult.setText(String.valueOf(resultado));

        TextView periodoResult = findViewById(R.id.result_periodo);
        periodoResult.setText(String.valueOf(periodo));
        TextView taxaResult = findViewById(R.id.result_taxa);
        taxaResult.setText(String.valueOf(taxa));
        TextView valorResult = findViewById(R.id.result_valor);
        valorResult.setText(String.valueOf(valorDesejado));

        listenVoltarOnClick();
    }

    private double calcularAposentadoria(double fv, double i, int n) {
        double potencia = Math.pow((1 + i), n);
        return (fv * i) / (potencia - 1);
    }

    private void listenVoltarOnClick() {
        findViewById(R.id.btn_voltar).setOnClickListener(view -> finish());
    }
}
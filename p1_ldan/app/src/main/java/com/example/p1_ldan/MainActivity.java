package com.example.p1_ldan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button button = findViewById(R.id.calcular);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText iValorDesejado = findViewById(R.id.valor_desejado);
                EditText iTaxa = findViewById(R.id.taxa);
                EditText iPeriodo = findViewById(R.id.periodo);

                double valorDesejado = Double.parseDouble(iValorDesejado.getText().toString());
                double taxa = Double.parseDouble(iTaxa.getText().toString());
                int periodo = Integer.parseInt(iPeriodo.getText().toString());

                Intent resultCDI = new Intent(MainActivity.this, ResultActivity.class);
                resultCDI.putExtra("taxa", taxa);
                resultCDI.putExtra("valorDesejado", valorDesejado);
                resultCDI.putExtra("periodo", periodo);
                startActivity(resultCDI);
            }
        });
    }
}

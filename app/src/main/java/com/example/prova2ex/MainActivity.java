package com.example.prova2ex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnVoltarIMC, btnVoltarFah, btnCalcIMC, btnCalcFah, btnIMC, btnFah;
    EditText edtAlt, edtPeso, edtCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarregarTelaPrincipal();
    }

    public void CarregarTelaPrincipal(){
        setContentView(R.layout.activity_main);
        btnIMC = findViewById(R.id.btnCalcularIMC);
        btnFah = findViewById(R.id.btnConvers);

        btnIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaIMC();
            }
        });

        btnFah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaFah();
            }
        });
    }

    public void CarregarTelaIMC(){
        setContentView(R.layout.pag_imc);
        btnCalcIMC = findViewById(R.id.btnCalcularIMC);
        btnVoltarIMC = findViewById(R.id.btnVoltarIMC);
        edtAlt = findViewById(R.id.edtAlt);
        edtPeso = findViewById(R.id.edtPeso);
        btnCalcIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double alt = Double.parseDouble(edtAlt.getText().toString());
                double peso = Double.parseDouble(edtPeso.getText().toString());
                double result = peso/(alt*alt);
                String msgIMC = "";
                if(result < 17){
                    msgIMC = "Muito Abaixo do Peso";
                } else if(result < 18.5){
                    msgIMC = "Abaixo do Peso";
                } else if(result < 25){
                    msgIMC = "Peso Normal";
                } else if(result < 30){
                    msgIMC = "Acima do peso";
                } else if(result < 35){
                    msgIMC = "Obesidade Grau I";
                }else if(result < 40){
                    msgIMC = "Obesidade Grau II";
                }else{
                    msgIMC = "Obesidade Grau III";
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Resultado");
                alert.setMessage(msgIMC);
                alert.setNeutralButton("Fechar", null);
                alert.show();
            }
        });

        btnVoltarIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });
    }

    public void CarregarTelaFah(){
        setContentView(R.layout.pag_fah);
        btnCalcFah = findViewById(R.id.btnConvert);
        btnVoltarFah = findViewById(R.id.btnVoltarConv);
        edtCelsius = findViewById(R.id.edtCelsius);

        btnCalcFah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double celsius = 0, fahrenheit = 0;
                celsius = Double.parseDouble(edtCelsius.getText().toString());
                fahrenheit = (celsius*1.8) + 32;
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Resultado");
                alert.setMessage("O Resultado é: " + fahrenheit +" Fahrenheit");
                alert.setNeutralButton("Fechar", null);
                alert.show();

            }
        });

        btnVoltarFah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });

    }
}
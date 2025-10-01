package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {
    public EditText txt1;
    public EditText txt2;
    public EditText txt3;
    public TextView aviso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        txt1 = findViewById(R.id.editPeso);
        txt2 = findViewById(R.id.editAltura);
        txt3 = findViewById(R.id.editNome);
        aviso = findViewById(R.id.alerta);
    }
    public void onCalcule(View v){
        String peso = txt1.getText().toString();
        String altura = txt2.getText().toString();
        String nome = txt3.getText().toString();
        try {
            float p = Integer.parseInt(String.valueOf(peso));
            float a = Integer.parseInt(String.valueOf(altura));
            a /= 100;
            float resultado = p / (a*a);
            Intent intent = new Intent(getApplicationContext(),ActivityResultado.class);
            intent.putExtra("imc", resultado);
            intent.putExtra("nome", nome);
            intent.putExtra("altura", altura);
            intent.putExtra("peso", peso);
            startActivity(intent);
        } catch (Exception e){
            aviso.setText("Digite numeros inteiros");
        }
    }
}
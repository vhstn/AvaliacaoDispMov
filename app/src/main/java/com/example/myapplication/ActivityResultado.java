package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class ActivityResultado extends AppCompatActivity {
    public TextView txtImc;
    public TextView txtMsgImc;
    public TextView txtNome;
    public ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Bundle bundle = getIntent().getExtras();
        float imc = bundle.getFloat("imc");
        int altura = bundle.getInt("altura");
        int peso = bundle.getInt("peso");
        String nome = bundle.getString("nome");
        String imcFormatado = String.valueOf(imc).replace(".", ",");

        txtNome = findViewById(R.id.imcNome);
        txtImc = findViewById(R.id.imcValorResultado);
        txtMsgImc = findViewById(R.id.imcResultado);

        txtNome.setText(String.format("Nome: %s", nome));
        txtImc.setText(String.format("IMC: %s", imcFormatado));
        txtMsgImc.setText(calculaKgs(imc, altura, peso));
    }

    private String calculaKgs(float imc, int altura, int peso){
        if (imc >= 20.0 && imc <= 25.0){
            return "Seu IMC está saudável";
        }
        if (imc < 20){
            return "Seu IMC está abaixo do saudável. O ideal é entre 20 e 25.";
        }
        if (imc > 25){
            return "Seu IMC está acima do saudável. O ideal é entre 20 e 25.";
        }
        return "";
    }
}



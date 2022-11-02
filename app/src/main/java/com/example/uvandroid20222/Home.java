package com.example.uvandroid20222;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    public  double valorPagar, valorPagar2, precioLeche, precioAgua, valorTotal;
    EditText mostrar1, mostrar2, mostrar3;
    public Integer cantidad, cantidad2, cantidadTotal;
    Button btnPintar, btnCL, btnCA, Total;

    //Nueva variable
    private TextView tv1, etPrecioA, etCantA, etValorA, etCantTotal, etValorTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Cambios
        tv1 = findViewById(R.id.tv1);
        String dato = getIntent().getStringExtra("dato");
        tv1.setText("Hola "+ dato );
        btnCL = findViewById(R.id.btnCL);
        btnCA = findViewById(R.id.btnCA);

            //Captura de datos Agua
        etPrecioA = findViewById(R.id.etPrecioA);
        etCantA = findViewById(R.id.etCantA);
        etValorA = findViewById(R.id.etValorA);

        Total = findViewById(R.id.btnTotal);

        etCantTotal = findViewById(R.id.etCantTotal);
        etValorTotal = findViewById(R.id.etValorTotal);
        //FIN CAMBIOS

        mostrar1 = findViewById(R.id.edCampoMostrar);
        mostrar2 = findViewById(R.id.edCampoMostrar2);
        mostrar3 = findViewById(R.id.edCampoMostrar3);
        btnPintar = findViewById(R.id.btnPintar);
        Bundle bundle = getIntent().getExtras();
        valorPagar=bundle.getDouble("valorPagar");
        cantidad=bundle.getInt("cantidad");
        cantidad2=bundle.getInt("cantidad2");
        precioLeche=bundle.getDouble("precioLeche");
        precioAgua=bundle.getDouble("precioAgua");
        etPrecioA.setText("Precio unitario: "+ precioAgua);
        etCantA.setText("Cantidad: "+ cantidad2);
        etValorA.setText("Total a pagar: "+ valorPagar2);
        mostrar1.setText("precio unitario: " + precioLeche);
        mostrar2.setText("cantidad: " + cantidad);
        mostrar3.setText("Total a pagar: " + valorPagar);
    }

    public void Total(View view){
        cantidadTotal = cantidad + cantidad2;
        etCantTotal.setText("Cantidad total de artículos: "+cantidadTotal);
        valorTotal = valorPagar + valorPagar2;
        etValorTotal.setText("Valor total a pagar: "+valorTotal);
    }

    public void ComprarLeche(View view){
        cantidad = cantidad + 1;
        mostrar2.setText("Cantidad: "+cantidad);
        valorPagar = cantidad*precioLeche;
        mostrar3.setText("Total leche: "+ valorPagar);
    }
    public void ComprarAgua(View view){
        cantidad2 = cantidad2 +1;
        etCantA.setText("Cantidad: "+cantidad2);
        valorPagar2  = cantidad2 * precioAgua;
        etValorA.setText("Total agua: "+ valorPagar2);
    }

    public  void volver(View cosa){
        Intent navegar = new Intent(this,MainActivity.class);
        //navegar.addFlags(navegar.FLAG_ACTIVITY_CLEAR_TASK | navegar.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle data = new Bundle();
        data.putInt("cantidadTotal",cantidadTotal);
        data.putDouble("valorPagarTotal", valorTotal);
        navegar.putExtras(data);
        startActivity(navegar);
    }

    public  void pintar (View f) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            tv1.setBackgroundColor(Color.rgb(aleatorio(),aleatorio(),aleatorio()));
           /* mostrar1.setBackgroundColor(Color.rgb(aleatorio(),aleatorio(),aleatorio()));
            mostrar2.setBackgroundColor(Color.rgb(aleatorio(),aleatorio(),aleatorio()));
            mostrar3.setBackgroundColor(Color.rgb(aleatorio(),aleatorio(),aleatorio()));
            etPrecioA.setBackgroundColor(Color.rgb(aleatorio(),aleatorio(),aleatorio()));
            etCantA.setBackgroundColor(Color.rgb(aleatorio(),aleatorio(),aleatorio()));
            etValorA.setBackgroundColor(Color.rgb(aleatorio(),aleatorio(),aleatorio())); */
            btnPintar.setText("Has cambiado el color");
        }
    }

    public int aleatorio(){
        return (int)(Math.random()*255+1);
    }


}
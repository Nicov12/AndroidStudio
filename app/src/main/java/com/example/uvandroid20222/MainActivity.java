package com.example.uvandroid20222;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin, btnDelegado, btnInterfaz;
    EditText edCantidad, edValor;
    public  double precioLeche = 8000;
    public  double precioAgua = 2000;
    public  double valorPagar;
    public Integer cantidad, cantidad2;

    private EditText et1;
    private TextView etRecibo;
    private LinearLayout recibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Cambios realizados
        et1 = (EditText)findViewById(R.id.et1);
        etRecibo = findViewById(R.id.etRecibo);
        recibo = findViewById(R.id.recibo);
        //Fin cambios realizados
        //enlazamiento
        cantidad = 0;
        cantidad2=0;
        //btnLogin = findViewById(R.id.btnLogin);
        btnInterfaz = findViewById(R.id.btnInterfaz);
        btnDelegado = findViewById(R.id.btnDelegado);
        //Datos del recibo
        edCantidad = findViewById(R.id.edCantidad);

        edValor = findViewById(R.id.edValor);
      //  double valorT = getIntent().getStringExtra("valorTotal");
        //edValor.setText("Valor Pagado: "+valorT);
        //Fin datos del recibo
        // Anado un evento por medio de interfaz
        btnInterfaz.setOnClickListener(this);
        // Delegado
        btnDelegado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Home.class);
                i.putExtra("dato", et1.getText().toString());
                Bundle data = new Bundle();
                data.putInt("cantidad",cantidad);
                data.putDouble("valorPagar", valorPagar);
                i.putExtras(data);
                i.putExtra("precioLeche",precioLeche);
                i.putExtra("precioAgua",precioAgua);
                i.addFlags(i.FLAG_ACTIVITY_CLEAR_TASK | i.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

                //Toast.makeText(getApplicationContext(), "Hola boton 2", Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        //Toast.makeText(this, "Hola soy el metodo onPostResume", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "Hola soy el metodo onPause", Toast.LENGTH_LONG).show();
    }

    public void saludar(View h){
        //enlazamiento
        //Pasamos los datos para formar el recibo
        //btnLogin = (Button) h;
        //btnLogin.setText("Ya me tocaste");
       // cantidad = cantidad + 1;
        //String cantT = getIntent().getStringExtra("cantidadTotal");
        //edCantidad.setText("Cantidad Total: "+cantT);
       // valorPagar = cantidad*precioLeche;
        //edValor.setText("TOTAL PAGADO: ");
        //recibo.setVisibility(LinearLayout.GONE);
        edCantidad.setVisibility(View.VISIBLE);
        edValor.setVisibility(View.VISIBLE);
        etRecibo.setVisibility(View.VISIBLE);
        Bundle bundle = getIntent().getExtras();
        valorPagar=bundle.getDouble("valorPagarTotal");
        cantidad=bundle.getInt("cantidadTotal");
        edCantidad.setText("Cantidad Total: " + cantidad);
        edValor.setText("Valor Pagado: " + valorPagar);

    }

    public void Saludar2(View view){
        Toast.makeText(this, "Hola boton 3: "+et1.getText(), Toast.LENGTH_LONG).show();
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("valorPagar", valorPagar);
        outState.putInt("cantidad", cantidad);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle paquete) {
        super.onRestoreInstanceState(paquete);
        cantidad = paquete.getInt("cantidad");
        valorPagar = paquete.getInt("valorPagar");
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "¡Hola "+et1.getText()+"!", Toast.LENGTH_LONG).show();
    }
}
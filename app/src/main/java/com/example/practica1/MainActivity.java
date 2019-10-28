package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String genero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] letra = {"Casado","Separado","Divorciado","Otro"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letra));


        final EditText txtNombre = (EditText)findViewById(R.id.txtNombre1);
        final EditText txtApellidos = (EditText)findViewById(R.id.txtApellidos1);
        final EditText txtEdad = (EditText)findViewById(R.id.txtEdad1);
        Editable nombrefinal = txtNombre.getText();

        final RadioButton hombreRadio = findViewById(R.id.radioButtonHombre);




        final TextView txtView = (TextView)findViewById(R.id.textView1);

        final Button btnBoton1 = (Button)findViewById(R.id.btngenerartexto);
        btnBoton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if(hombreRadio.isChecked()){
                    genero = "Hombre";
                }
                else{
                    genero = "Mujer";
                }
                if(txtNombre.isEmpty()){

                }
                txtView.setText(txtApellidos.getText()+", "+txtNombre.getText()+", Edad = "+txtEdad.getText()+", " +genero+""); } } );
    }
}

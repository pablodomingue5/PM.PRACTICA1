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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean nombreVacio=false;
    boolean apellidosVacio=false;
    boolean edadVacio=false;
    

    String nombre;
    String apellidos;
    int edad;
    String genero;
    String tienehijos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Parte de los EditText
        final EditText txtNombre = (EditText)findViewById(R.id.txtNombre1);
        final EditText txtApellidos = (EditText)findViewById(R.id.txtApellidos1);
        final EditText txtEdad = (EditText)findViewById(R.id.txtEdad1);
        Editable nombrefinal = txtNombre.getText();
        //Parte de RadioButtons
        final RadioButton radioHombre = findViewById(R.id.radioButtonHombre);
        final RadioButton radioMujer = findViewById(R.id.radioButtonMujer);
        //Parte SPINNER
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] letra = {"Casado","Separado","Divorciado","Otro"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letra));
        //Parte Switch
        final Switch SwitchHijos = (Switch) findViewById(R.id.switch1);
        //TextView FINAL
        final TextView txtView = (TextView)findViewById(R.id.textView1);

        final Button btnBoton1 = (Button)findViewById(R.id.btngenerartexto);
        btnBoton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            if(txtNombre.getText().toString().isEmpty()){
                nombreVacio=true;
            }else{
                nombre = txtNombre.getText().toString();
            }
            if(txtApellidos.getText().toString().isEmpty()){
                    apellidosVacio=true;
            }else{
                    apellidos = txtApellidos.getText().toString();
            }
            try {
                    edad = Integer.parseInt(txtEdad.getText().toString());
                    String mayoriaedad = "";
                    if(edad>=18){
                        mayoriaedad="Mayor de Edad";
                    }else{
                        mayoriaedad="Menor de Edad";
                    }
                }catch (NumberFormatException nfe){
                    edadVacio=true;
                }
            if(radioHombre.isChecked()){
                genero="Hombre";
            }
            if(radioMujer.isChecked()){
                genero="Mujer";
            }
            String estadoSpinner = spinner.getSelectedItem().toString();
            if(SwitchHijos.isChecked()){
                tienehijos="Tiene hijos";
            }else{
                tienehijos="No tiene hijos";
            }






                                         }
            })
    ;}
}
                //txtView.setText(txtApellidos.getText()+", "+txtNombre.getText()+", Edad = "+txtEdad.getText()+", " +genero+""); } } );

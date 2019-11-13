package com.example.practica1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
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
    boolean nombreVacio = false;
    boolean apellidosVacio = false;
    boolean edadVacio = false;

    String nombre;
    String apellidos;
    int edad;
    String genero;
    String tienehijos;
    String mostrarFinal = "";
    String mayoriaedad = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Parte de los EditText
        final EditText txtNombre = (EditText) findViewById(R.id.txtNombre1);
        final EditText txtApellidos = (EditText) findViewById(R.id.txtApellidos1);
        final EditText txtEdad = (EditText) findViewById(R.id.txtEdad1);
        //Parte de RadioButtons
        final RadioButton radioHombre = findViewById(R.id.radioButtonHombre);
        final RadioButton radioMujer = findViewById(R.id.radioButtonMujer);
        //Parte SPINNER
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adaptadorTipoFichero;
        adaptadorTipoFichero = ArrayAdapter.createFromResource(this, R.array.spinner2, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adaptadorTipoFichero);
        //Parte Switch
        final Switch SwitchHijos = (Switch) findViewById(R.id.switch1);
        //TextView FINAL
        final TextView txtView = (TextView) findViewById(R.id.textView1);


        final Button btnBoton1 = (Button) findViewById(R.id.btngenerartexto);
        btnBoton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                nombreVacio=false;
                apellidosVacio=false;
                edadVacio=false;

                if (txtApellidos.getText().toString().isEmpty()) {
                    apellidosVacio=true;
                } else {
                    apellidos = txtApellidos.getText().toString();
                }
                if (txtNombre.getText().toString().isEmpty()) {
                    nombreVacio=true;
                } else {
                    nombre=txtNombre.getText().toString();
                }
                try {
                    edad = Integer.parseInt(txtEdad.getText().toString());
                    String mayoriaedad = "";
                    if (edad >= 18) {
                        mayoriaedad = "Mayor de Edad";
                    } else {
                        mayoriaedad = "Menor de Edad";
                    }
                } catch (NumberFormatException nfe) {
                    edadVacio = true;
                }
                if (radioHombre.isChecked()) {
                    genero = "Hombre";
                }
                if (radioMujer.isChecked()) {
                    genero = "Mujer";
                }
                String estadoSpinner = spinner.getSelectedItem().toString();
                if (SwitchHijos.isChecked()) {
                    tienehijos = "Tiene hijos";
                } else {
                    tienehijos = "No tiene hijos";
                }
                System.out.println(nombreVacio+""+apellidosVacio+""+edadVacio+"");


                    if (nombreVacio == true) {
                        mostrarFinal = "El nombre está vacío";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            txtView.setTextColor(getColor(R.color.colorAccent));
                        }else
                        {
                            txtView.setTextColor(Color.RED);
                        }
                        txtView.setText(mostrarFinal);
                    }
                    if (apellidosVacio == true) {
                        mostrarFinal = "El apellido está vacío";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            txtView.setTextColor(getColor(R.color.colorAccent));
                        }else
                        {
                            txtView.setTextColor(Color.RED);
                        }
                        txtView.setText(mostrarFinal);
                    }
                    if (edadVacio == true) {
                        mostrarFinal = "La edad está vacía";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            txtView.setTextColor(getColor(R.color.colorAccent));
                        }else
                        {
                            txtView.setTextColor(Color.RED);
                        }
                        txtView.setText(mostrarFinal);
                    }

                    if (nombreVacio == true && apellidosVacio == true) {
                        mostrarFinal = "El nombre y el apellido están vacíos";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            txtView.setTextColor(getColor(R.color.colorAccent));
                        }else
                        {
                            txtView.setTextColor(Color.RED);
                        }
                        txtView.setText(mostrarFinal);
                    }
                    if (nombreVacio == true && edadVacio == true) {
                        mostrarFinal = "El nombre y la edad están vacíos";
                        txtView.setTextColor(Color.RED);
                        txtView.setText(mostrarFinal);
                    }
                    if (apellidosVacio == true && edadVacio == true) {
                        mostrarFinal = "Los apellidos y la edad están vacíos";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            txtView.setTextColor(getColor(R.color.colorAccent));
                        }else
                        {
                            txtView.setTextColor(Color.RED);
                        }
                        txtView.setText(mostrarFinal);
                    }
                        if (apellidosVacio == true && edadVacio == true && nombreVacio == true) {
                         mostrarFinal = "El nombre, apellidos y la edad están vacíos";
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                txtView.setTextColor(getColor(R.color.colorAccent));
                            }else
                            {
                                txtView.setTextColor(Color.RED);
                            }
                        txtView.setText(mostrarFinal);
                        }
                    if (nombreVacio == false && apellidosVacio == false && edadVacio == false) {
                        txtView.setTextColor(Color.BLACK);
                        mostrarFinal = txtApellidos.getText() + ", " + txtNombre.getText() + ", Edad = " + txtEdad.getText() + ", " + estadoSpinner + mayoriaedad + ", " + genero + ", " + tienehijos + "";
                        txtView.setText(mostrarFinal);
                    }


            }
        });

        final Button btnBoton2 = (Button) findViewById(R.id.button2);
        btnBoton2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View arg0) {
                txtNombre.setText("");
                txtApellidos.setText("");
                txtEdad.setText("");
                radioHombre.setChecked(false);
                radioMujer.setChecked(false);
                spinner.setSelection(0);
                SwitchHijos.setChecked(false);
                mostrarFinal="Aquí se mostrará el texto";
                txtView.setTextColor(getColor(R.color.colorParaTexto));
                txtView.setText(mostrarFinal);
            }
        })
        ;
    }
}



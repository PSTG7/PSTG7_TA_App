package com.example.amst_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EditText etNombres, etApellidos, etUsuario, etClave, etCorreo, etCelular, etFavorito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNombres = (EditText) findViewById(R.id.editTextNombres);
        etApellidos = (EditText) findViewById(R.id.editTextApellidos);
        etUsuario = (EditText) findViewById(R.id.editTextUsuario);
        etClave = (EditText) findViewById(R.id.editTextClave);
        etCorreo = (EditText) findViewById(R.id.editTextCorreo);
        etCelular = (EditText) findViewById(R.id.editTextCelular);
        etFavorito = (EditText) findViewById(R.id.editTextFavorito);
    }

    public void registrar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nombres = etNombres.getText().toString();
        String apellidos = etApellidos.getText().toString();
        String usuario = etUsuario.getText().toString();
        String clave = etClave.getText().toString();
        String correo = etCorreo.getText().toString();
        String celular = etCelular.getText().toString();
        String favorito = etFavorito.getText().toString();

        if (!nombres.isEmpty() && !apellidos.isEmpty() && !usuario.isEmpty() && !clave.isEmpty() && !correo.isEmpty() &&
                !celular.isEmpty() && !favorito.isEmpty()) {
            try {
                bd.execSQL("insert into usuarios (usuario,nombres,apellidos,clave,correo,celular,favorito) " +
                        "values ('" + usuario + "','" + nombres + "','" + apellidos + "','" + clave + "','" + correo + "','" + celular + "','" + favorito + "')");
                bd.close();
                etNombres.setText("");
                etApellidos.setText("");
                etUsuario.setText("");
                etClave.setText("");
                etCorreo.setText("");
                etCelular.setText("");
                etFavorito.setText("");
                Toast.makeText(this, "Registro de usuario exitoso",
                        Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Fallo de registro. Pruebe con otro usuario",
                        Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Por favor ingrese todos los datos",
                    Toast.LENGTH_SHORT).show();
        }


    }

    public void regresar(View v) {
        finish();
    }
}
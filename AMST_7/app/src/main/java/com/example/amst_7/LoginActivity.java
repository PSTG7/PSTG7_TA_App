package com.example.amst_7;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsuario, etClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = (EditText) findViewById(R.id.editTextUsuario);
        etClave = (EditText) findViewById(R.id.editTextClave);
    }

    public void ingresar(View v) {

        String usuario = etUsuario.getText().toString();
        String clave = etClave.getText().toString();

        if (!usuario.isEmpty() && !clave.isEmpty()) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                    "administracion", null, 1);
            SQLiteDatabase bd = admin.getReadableDatabase();
            Cursor fila = bd.rawQuery(
                    "select * from usuarios where usuario='" + usuario + "'", null);
            if (fila.moveToFirst()) {
                if (clave.equals(fila.getString(3))) {
                    etUsuario.setText("");
                    etClave.setText("");
                    Intent i = new Intent(this, AplicationActivity.class);
                    i.putExtra("usuario", usuario);
                    i.putExtra("nombres", fila.getString(1));
                    i.putExtra("apellidos", fila.getString(2));
                    i.putExtra("correo", fila.getString(4));
                    i.putExtra("celular", fila.getString(5));
                    i.putExtra("favorito", fila.getString(6));
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Clave incorrecta",
                            Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Usuario no registrado",
                        Toast.LENGTH_SHORT).show();
            }
            bd.close();
        } else {
            Toast.makeText(this, "Ingrese sus credenciales",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void crearCuenta(View v) {
        etUsuario.setText("");
        etClave.setText("");
        Intent i = new Intent(this, RegistroActivity.class);
        startActivity(i);
    }
}

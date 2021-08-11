package com.example.amst_7;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.amst_7.Interfaces.IComunicarFragments;
import com.example.amst_7.Libros.Libro;
import com.example.amst_7.Libros.Libros;
import com.example.amst_7.fragmentos.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AplicationActivity extends AppCompatActivity implements IComunicarFragments {

    private String usuario, nombres, apellidos, correo, celular, favorito;
    BottomNavigationView menu_navigation;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    DetallesFragment dtFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplication);

        Bundle bundle = getIntent().getExtras();
        usuario = bundle.getString("usuario");
        nombres = bundle.getString("nombres");
        apellidos = bundle.getString("apellidos");
        correo = bundle.getString("correo");
        celular = bundle.getString("celular");
        favorito = bundle.getString("favorito");

        showSelectedFragment(new PerfilFragment());

        menu_navigation = (BottomNavigationView) findViewById(R.id.bottomnavigation_menu);
        menu_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                                                                @Override
                                                                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                                                                    if (menuItem.getItemId() == R.id.menu_cotegorias){
                                                                        showSelectedFragment(new CategoriasFragment());
                                                                    }
                                                                    if (menuItem.getItemId() == R.id.menu_inicio){
                                                                        showSelectedFragment(new InicioFragment());
                                                                    }
                                                                    if (menuItem.getItemId() == R.id.menu_perfil){
                                                                        showSelectedFragment(new PerfilFragment());
                                                                    }
                                                                    return true;
                                                                }
                                                            }
        );
    }

    private void showSelectedFragment (Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public String getUsuario(){
        return usuario;
    }
    public String getNombres(){
        return nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getCorreo(){
        return correo;
    }
    public String getCelular(){
        return celular;
    }
    public String getFavorito(){
        return favorito;
    }

    public void login(View v){
        finish();
    }

    @Override
    public void enviarDatosLibros(Libro libro) {
        //Se realiza el envio
        dtFragment = new DetallesFragment();
        //Creamos el Bundle
        Bundle bundle = new Bundle();
        //Enviamos el objeto serializado
        bundle.putSerializable("libro", libro);
        dtFragment.setArguments(bundle);
        //abrimos nuevo fragmento
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, dtFragment);
        fragmentTransaction.commit();
    }
}
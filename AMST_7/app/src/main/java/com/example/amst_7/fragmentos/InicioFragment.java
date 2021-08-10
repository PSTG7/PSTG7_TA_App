package com.example.amst_7.fragmentos;

import android.app.AppComponentFactory;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amst_7.AplicationActivity;
import com.example.amst_7.Libros.Libro;
import com.example.amst_7.Libros.Libros;
import com.example.amst_7.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment {

    Libros libros;
    RecyclerView recyclerView;
    ArrayList<Libro> librosArr;

    String[][] datos = {
            {"Viaje al centro de la tierra","Julio Verne", "Alianza"},
            {"Doctor Sueño", "Stephen King", "Charles ScriptnerSon"},
            {"El principito", "Antoine de Saint-Exupéry", "Reynal & Hitchcock"}
    };

    int[] datosImg = {R.drawable.viaje_ctr,R.drawable.dr_suenio,R.drawable.el_principito};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InicioFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);
        recyclerView = v.findViewById(R.id.recyckerView);
        librosArr = new ArrayList<>();
        //Cargamos la lista
        cargarLista();
        //Mostramos datos
        mostrarDatos();
        return v;
    }

    public void cargarLista(){
        for(int i=0;i<datos.length;i++){
            librosArr.add(new Libro(datos[i][0],datos[i][1],datos[i][2],datosImg[i]));
        }
    }

    public void mostrarDatos(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        libros = new Libros(getContext(), librosArr);
        recyclerView.setAdapter(libros);
        //No tocar :p
        libros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = librosArr.get(recyclerView.getChildAdapterPosition(view)).getTitulo();
                Toast.makeText(getContext(), "Seleccionaste: "+titulo, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
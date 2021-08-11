package com.example.amst_7.fragmentos;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import com.example.amst_7.Interfaces.IComunicarFragments;
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
            {"Viaje al centro de la tierra","Julio Verne", "Alianza","Viaje al centro de la Tierra (Voyage au centre de la Terre) es una novela de Julio Verne, publicada el 25 de noviembre de 1864, que trata de la expedición de un profesor de mineralogía el profesor Lidenbrock, su sobrino Axel y un guía llamado Hans, viajan al interior de la Tierra y se encuentran en su aventura con una gran sorpresa al llegar."},
            {"Doctor Sueño", "Stephen King", "Charles ScriptnerSon","Seguimos a Danny Torrace, traumatizado y con problemas de ira y alcoholismo. Estos problemas reflejan los de su propio padre, que cuando tiene sus habilidades psíquicas de vuelta, contacta con una niña, Abra Stone, a la que debe de rescatar de un grupo de viajeros que se alimentan de niños."},
            {"El principito", "Antoine de Saint-Exupéry", "Reynal & Hitchcock","El principito es una narración corta del escritor francés Antoine de Saint-Exupéry, que trata de la historia de un pequeño príncipe que parte de su asteroide a una travesía por el universo, en la cual descubre la extraña forma en que los adultos ven la vida y comprende el valor del amor y la amistad."},
            {"It (Eso)", "Stephen King", "DeBolsillo","Tras veintisiete años de tranquilidad y lejanía, una antigua promesa infantil les hace volver al lugar en el que vivieron su infancia y juventud como una terrible pesadilla. Regresan a Derry para enfrentarse con su pasado y enterrar definitivamente la amenaza que los amargó durante su niñez."},
            {"Dracula", "Bram Stoker", "De Bolsillo", "La obra comienza con Jonathan Harker, un joven abogado londinense comprometido con Wilhemina Murray (Mina), el cual se encuentra en la ciudad de Bistritz como parte de una viaje de negocios, que continuará a través del desfiladero del Borgo hasta el remoto castillo de su cliente, el conde Drácula."}
    };

    int[] datosImg = {R.drawable.viaje_ctr,R.drawable.dr_suenio,R.drawable.el_principito, R.drawable.it, R.drawable.dracula};

    //referencias para comunicar Fragments
    Activity actividad;
    IComunicarFragments icFragments;

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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            this.actividad = (Activity) context;
            icFragments = (IComunicarFragments) this.actividad;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
            librosArr.add(new Libro(datos[i][0],datos[i][1],datos[i][2],datosImg[i],datos[i][3]));
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
                icFragments.enviarDatosLibros(librosArr.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }
}
package com.example.amst_7.Libros;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amst_7.R;

import java.util.ArrayList;

public class Libros extends RecyclerView.Adapter<Libros.ViewHolder> implements View.OnClickListener{

    ArrayList<Libro> modelo;
    LayoutInflater inflater;

    //Listener
    private View.OnClickListener listener;

    public Libros(Context context, ArrayList<Libro> modelo){
        this.inflater = LayoutInflater.from(context);
        this.modelo = modelo;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_libro, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String titulo = modelo.get(position).getTitulo();
        String autor = modelo.get(position).getAutor();
        String editor = modelo.get(position).getEditor();
        int img = modelo.get(position).getImgId();
        holder.titulo.setText(titulo);
        holder.autor.setText(autor);
        holder.editor.setText(editor);
        holder.img.setImageResource(img);

    }

    @Override
    public int getItemCount() {
        return modelo.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView autor;
        TextView editor;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tituloLibro);
            autor = itemView.findViewById(R.id.autorLibro);
            editor = itemView.findViewById(R.id.editorialLibro);
            img = itemView.findViewById(R.id.imgLibro);
        }
    }
}
package com.jah.mi_playlist;

import android.content.Context;
import android.service.controls.Control;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorCanciones extends RecyclerView.Adapter<AdaptadorCanciones.HolderCancion>{

    List<Cancion> dataSet;
    Context context;
    Cancion c;

    public AdaptadorCanciones(List<Cancion> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public AdaptadorCanciones.HolderCancion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.cancion, parent, false);
        return new HolderCancion(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCanciones.HolderCancion holder, int position) {
        c = dataSet.get(position);

        holder.imgPortada.setImageResource(R.drawable.portada);
        holder.lblTitulo.setText(c.getTitulo());
        holder.lblNombre.setText(c.getNombre());
        holder.imgPlay.setOnClickListener(view -> ControladorMediaPlayer.play(dataSet.get(holder.getAdapterPosition()), context, holder.sbBarra));
        holder.imgPause.setOnClickListener(view -> ControladorMediaPlayer.pause());
        holder.imgStop.setOnClickListener(view -> ControladorMediaPlayer.stop(holder.sbBarra));
        holder.sbBarra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int posicion, boolean fromUser) {
                if(fromUser){
                    ControladorMediaPlayer.seekTo(posicion);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class HolderCancion extends RecyclerView.ViewHolder {

        ImageView imgPortada, imgPlay, imgPause, imgStop;
        SeekBar sbBarra;
        TextView lblNombre, lblTitulo;

        public HolderCancion(@NonNull View itemView) {
            super(itemView);
            imgPortada = itemView.findViewById(R.id.imgPortada);
            imgPlay = itemView.findViewById(R.id.imgPlay);
            imgPause = itemView.findViewById(R.id.imgPause);
            imgStop = itemView.findViewById(R.id.imgStop);
            sbBarra = itemView.findViewById(R.id.sbBarra);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblTitulo = itemView.findViewById(R.id.lblTitulo);
        }
    }
}

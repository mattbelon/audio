package com.efectivaweb.audio;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorSonidos extends RecyclerView.Adapter<AdaptadorSonidos.SonidoViewHolder> {

    MediaPlayer mediaPlayer;
    Context context;
    List<Sonido> listaSonidos;

    public AdaptadorSonidos(Context context, List<Sonido> listaSonidos) {
        this.context = context;
        this.listaSonidos = listaSonidos;
    }


    @NonNull
    @Override
    public AdaptadorSonidos.SonidoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item, viewGroup, false) ;
        return new SonidoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorSonidos.SonidoViewHolder sonidoViewHolder, final int i) {

        sonidoViewHolder.tvNombre.setText(listaSonidos.get(i).getNombre());

        sonidoViewHolder.btnReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }

                if (listaSonidos.get(i).getSonido().equals("sonidoUno")) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.mariposa);
                    mediaPlayer.start();
                }

                if (listaSonidos.get(i).getSonido().equals("sonidoDos")) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.november);
                    mediaPlayer.start();
                }

                if (listaSonidos.get(i).getSonido().equals("sonidoTres")) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.spy_suite);
                    mediaPlayer.start();
                }

            }
        });

        sonidoViewHolder.btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null ){
                mediaPlayer.stop();

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaSonidos.size();
    }

    public class SonidoViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombre;
        Button btnReproducir, btnDetener;

        public SonidoViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            btnReproducir = itemView.findViewById(R.id.btnReproducir);
            btnDetener = itemView.findViewById(R.id.btnDetener);
        }
    }

}

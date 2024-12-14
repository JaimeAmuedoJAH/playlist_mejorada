package com.jah.mi_playlist;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.service.controls.Control;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCanciones;
    LinearLayoutManager disposicionP;
    AdaptadorCanciones adaptadorCanciones;
    List<Cancion> listCanciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        rvCanciones = findViewById(R.id.rvCanciones);
        cargarDatos();
        disposicionP = new LinearLayoutManager(getApplicationContext());
        rvCanciones.setLayoutManager(disposicionP);
        adaptadorCanciones = new AdaptadorCanciones(listCanciones);
        rvCanciones.setAdapter(adaptadorCanciones);
    }

    public void cargarDatos(){
        listCanciones = new ArrayList<>();
        listCanciones.add(new Cancion("To Ashes and blood", "Woodkid", R.raw.to_ashes_and_blood));
        listCanciones.add(new Cancion("Hellfire", "Fever 333", R.raw.hellfire_));
        listCanciones.add(new Cancion("Playground", "Bea Miller", R.raw.playground));
        listCanciones.add(new Cancion("Cant hear it now", "Freya Ridings", R.raw.can_t_hear_it_now));
        listCanciones.add(new Cancion("Heavy is the crown", "Mike Shinoda", R.raw.heavy_is_the_crown));
        listCanciones.add(new Cancion("Ma meilleure ennemie", "Strommae Pomme", R.raw.ma_meilleure_ennemie));
        listCanciones.add(new Cancion("Enemy", "Imagine Dragons", R.raw.imagine_dragons));
        listCanciones.add(new Cancion("Paint the town blue", "Ashnikko", R.raw.paint_the_town_blue));
        listCanciones.add(new Cancion("Remember me", "D4dv", R.raw.remember_me));
        listCanciones.add(new Cancion("Sucker", "Marcus King", R.raw.sucker));
        listCanciones.add(new Cancion("The line", "Twenty One Pilots", R.raw.the_line));
        listCanciones.add(new Cancion("Wasteland", "Royal the serpent", R.raw.wasteland));
    }
}
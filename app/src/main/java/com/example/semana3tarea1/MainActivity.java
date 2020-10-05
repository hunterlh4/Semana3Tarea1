package com.example.semana3tarea1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton pelicula1, pelicula2;

    int VotosA=0, VotosB=0;
    FragmentTransaction transaction;
    Fragment fragmeninicio,fragmentpelicula,fragmentpelicula2;
    String ganador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pelicula1 =  findViewById(R.id.btn_pelicula1);
        pelicula2 =  findViewById(R.id.btn_pelicula2);





        fragmeninicio = new Iniciofragment();
        fragmentpelicula =new PeliculaFragment();
        fragmentpelicula2 =new PeliculaFragment2();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,fragmeninicio).commit();

        pelicula1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VotosA = VotosA + 1;
                Toast.makeText(getApplicationContext(),VotosA+" Votos para ", Toast.LENGTH_SHORT).show();
            }
        });
        pelicula2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VotosB = VotosB + 1;
                Toast.makeText(getApplicationContext(),VotosB+" Votos para "  , Toast.LENGTH_SHORT).show();
            }
        });



        Button resultado = (Button)findViewById(R.id.btn_contarvotos);
        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction=getSupportFragmentManager().beginTransaction();


                int A = VotosA;
                int B = VotosB;

                if (A>B){
                    transaction.replace(R.id.contenedor,fragmentpelicula);
                    transaction.addToBackStack(null);
                }
                else if(B>A){
                    transaction.replace(R.id.contenedor,fragmentpelicula2);
                    transaction.addToBackStack(null);
                }
                else {
                    Toast.makeText(getApplicationContext()," EMPATE "  , Toast.LENGTH_SHORT).show();
                }
                transaction.commit();

            }
        });




    }

}
package com.example.raul.tetris;

import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private int matrizTablero[][] = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};
    int cordX, cordY, cordGrid, figura, orientacion, score;
    GridLayout gridLayout;
    Runnable run;



    public void iniciar(){
        gridLayout = (GridLayout) findViewById(R.id.gridTablero);

        Button start = (Button) findViewById(R.id.buttonStart);
        start.setEnabled(false);
        Random rand = new Random();
        figura = rand.nextInt(7);

        //figura = 6;
        orientacion = 1;
        //orientacion = rand.nextInt(4);

        cordX = 4;
        cordY = 0;
        cordGrid = 4;
        if(figura == 0){
            View subview = gridLayout.getChildAt(4);
            ImageView subviewImage = (ImageView) subview;
            if(subview instanceof ImageView){
                subviewImage.setImageResource(R.drawable.greensquare);  //Barra
                if(matrizTablero[cordY][cordX] == 1){
                    perder();
                }else{
                    matrizTablero[cordY][cordX] = 1;
                }
            }
        }else if(figura == 1){
            View subview = gridLayout.getChildAt(4);
            View subview2 = gridLayout.getChildAt(5);
            ImageView subviewImage = (ImageView) subview;
            ImageView subviewImage2 = (ImageView) subview2;
            if(subview instanceof ImageView){
                subviewImage.setImageResource(R.drawable.orangesquare);     //L invertida
                subviewImage2.setImageResource(R.drawable.orangesquare);
                if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1){
                    perder();
                }else{
                    matrizTablero[cordY][cordX] = 1;
                    cordX += 1;
                    cordGrid += 1;
                    matrizTablero[cordY][cordX] = 1;
                }
            }
        }else if(figura == 2){
            View subview = gridLayout.getChildAt(4);
            View subview2 = gridLayout.getChildAt(5);
            ImageView subviewImage = (ImageView) subview;
            ImageView subviewImage2 = (ImageView) subview2;
            if(subview instanceof ImageView){
                subviewImage.setImageResource(R.drawable.bluesquare);       //L
                subviewImage2.setImageResource(R.drawable.bluesquare);
                if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1){
                    perder();
                }else{
                    matrizTablero[cordY][cordX] = 1;
                    matrizTablero[cordY][cordX + 1] = 1;
                }

            }
        }else if(figura == 3){
            View subview = gridLayout.getChildAt(4);
            View subview2 = gridLayout.getChildAt(5);
            ImageView subviewImage = (ImageView) subview;
            ImageView subviewImage2 = (ImageView) subview2;
            if(subview instanceof ImageView){
                subviewImage.setImageResource(R.drawable.redsquare);        //Cuadro
                subviewImage2.setImageResource(R.drawable.redsquare);
                if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1){
                    perder();
                }else{
                    matrizTablero[cordY][cordX] = 1;
                    matrizTablero[cordY][cordX + 1] = 1;
                }

            }
        }else if(figura == 4){
            View subview = gridLayout.getChildAt(4);
            View subview2 = gridLayout.getChildAt(5);
            ImageView subviewImage = (ImageView) subview;
            ImageView subviewImage2 = (ImageView) subview2;
            if(subview instanceof ImageView){
                subviewImage.setImageResource(R.drawable.lightbluesquare);      //Z invertida
                subviewImage2.setImageResource(R.drawable.lightbluesquare);
                if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1){
                    perder();
                }else{
                    matrizTablero[cordY][cordX] = 1;
                    matrizTablero[cordY][cordX + 1] = 1;
                }

            }
        }else if(figura == 5){
            View subview = gridLayout.getChildAt(4);
            View subview2 = gridLayout.getChildAt(5);
            ImageView subviewImage = (ImageView) subview;
            ImageView subviewImage2 = (ImageView) subview2;
            if(subview instanceof ImageView){
                subviewImage.setImageResource(R.drawable.yellowsquare);         //Z
                subviewImage2.setImageResource(R.drawable.yellowsquare);
                if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1){
                    perder();
                }else{
                    matrizTablero[cordY][cordX] = 1;
                    matrizTablero[cordY][cordX + 1] = 1;
                }
            }
        }else if(figura == 6){
            View subview = gridLayout.getChildAt(4);
            ImageView subviewImage = (ImageView) subview;
            if(subview instanceof ImageView){
                subviewImage.setImageResource(R.drawable.purplesquare);         //T
                if(matrizTablero[cordY][cordX] == 1){
                    perder();
                }else{
                    matrizTablero[cordY][cordX] = 1;

                }
            }
        }
    }


    public void onClickedStart(View view){
        iniciar();
        final Handler handler = new Handler();

        gridLayout.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {
                rotateClicked();
                //Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                moverDerecha();
                //Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                moverIzquierda();
                //Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                //Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
                dibujarFigura();
            }

        });

        run = new Runnable() {
            @Override
            public void run() {
                //Log.i("Runnable", "Ha sido ejecutado");
                dibujarFigura();
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(run);
    }



    public void onClickedReiniciar(View view){
        for (int i = 0; i <= 19; i++){
            for (int j = 0; j <= 19; j++){
                matrizTablero[i][j] = 0;
            }
        }

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layoutPerder);

        relativeLayout.setVisibility(View.INVISIBLE);

        score = 0;
    }


    public int[] revisarFilas(){
        int sumador;
        int filasBuenas[] = {-1, -1, -1, -1};
        int c = 0;
        for(int i = 0; i <= 19; i++){
            sumador = 0;
            for(int j = 0; j <= 9; j++){
                if(matrizTablero[i][j] == 0){
                    j += 20;
                    sumador = 0;
                }else{
                    sumador += matrizTablero[i][j];
                }
            }

            if(sumador == 10){
                filasBuenas[c] = i;
                c++;
            }
        }
        //Log.i("Runnable", Integer.toString(filasBuenas[0])+" "+Integer.toString(filasBuenas[1])+" "+Integer.toString(filasBuenas[2])+" "+Integer.toString(filasBuenas[3]));
        return filasBuenas;
    }


    public void eliminarFilas(){
        int filasAEliminar[] = revisarFilas();
        for(int i = 0; i <=3; i++){
            if(filasAEliminar[i] != -1){
                for(int j = filasAEliminar[i]; j > 0; j--){
                    for (int k = 0; k < 10; k++){
                        matrizTablero[j][k] = matrizTablero[j - 1][k];

                        View subview = gridLayout.getChildAt(j * 10 + k);
                        View subview2 = gridLayout.getChildAt(j * 10 + k - 10);


                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;

                        subviewImage.setImageDrawable(subviewImage2.getDrawable());
                    }
                }
                score += 1000;

                TextView textScore = (TextView) findViewById(R.id.textViewScore);
                textScore.setText(Integer.toString(score));
            }
        }
    }


    public void perder(){
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layoutPerder);
        TextView textView = (TextView) findViewById(R.id.textViewPerder);

        relativeLayout.setVisibility(View.VISIBLE);
        textView.setText("Has Perdido!\nTu Puntuacion fue de: "+Integer.toString(score));

        Handler handler = new Handler();
        handler.removeCallbacks(run);

    }


    public void rotateClicked(){
        if(figura == 0){
            if(orientacion == 1 || orientacion == 3){
                if((cordX + 2) <= 19 || (cordX - 1) >= 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY][cordX + 1] == 0 && matrizTablero[cordY][cordX + 2] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        orientacion = 2;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid + 2);
                        View subview3 = gridLayout.getChildAt(cordGrid + 3);


                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.greensquare);  //Barra
                            subviewImage2.setImageResource(R.drawable.greensquare);
                            subviewImage3.setImageResource(R.drawable.greensquare);
                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY][cordX + 2] = 1;
                            matrizTablero[cordY][cordX + 3] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 9);
                        subview2 = gridLayout.getChildAt(cordGrid - 19);
                        subview3 = gridLayout.getChildAt(cordGrid - 29);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Barra
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);
                            matrizTablero[cordY - 1][cordX + 1] = 0;
                            matrizTablero[cordY - 2][cordX + 1] = 0;
                            matrizTablero[cordY - 3][cordX + 1] = 0;
                        }
                    }
                }
            }else{
                if((cordY + 3) <= 19){
                    if(matrizTablero[cordY - 1][cordX + 1] == 0 && matrizTablero[cordY - 2][cordX + 1] == 0 && matrizTablero[cordY - 3][cordX + 1] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        orientacion = 1;
                        View subview = gridLayout.getChildAt(cordGrid - 10);
                        View subview2 = gridLayout.getChildAt(cordGrid - 20);
                        View subview3 = gridLayout.getChildAt(cordGrid - 30);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.greensquare);  //Barra
                            subviewImage2.setImageResource(R.drawable.greensquare);
                            subviewImage3.setImageResource(R.drawable.greensquare);

                            matrizTablero[cordY - 1][cordX] = 1;
                            matrizTablero[cordY - 2][cordX] = 1;
                            matrizTablero[cordY - 3][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 1);
                        subview3 = gridLayout.getChildAt(cordGrid + 2);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Barra
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);

                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY][cordX + 1] = 0;
                            matrizTablero[cordY][cordX + 2] = 0;
                        }
                    }
                }
            }
        }else if(figura == 1){
            if(orientacion == 1){
                if((cordX + 2) <= 19){
                    if(matrizTablero[cordY][cordX + 1] == 0 && matrizTablero[cordY][cordX + 2] == 0){
                        orientacion = 2;
                        View subview = gridLayout.getChildAt(cordGrid + 1);
                        View subview2 = gridLayout.getChildAt(cordGrid + 2);


                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                            subviewImage2.setImageResource(R.drawable.orangesquare);
                            matrizTablero[cordY][cordX + 1] = 1;
                            matrizTablero[cordY][cordX + 2] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 20);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L invertida
                            subviewImage2.setImageResource(0);

                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY - 2][cordX ] = 0;
                        }
                    }
                }
            }else if(orientacion == 2){
                if((cordY + 2) <= 19){
                    if(matrizTablero[cordY + 1][cordX] == 0 && matrizTablero[cordY + 2][cordX] == 0){
                        orientacion = 3;
                        View subview = gridLayout.getChildAt(cordGrid + 10);
                        View subview2 = gridLayout.getChildAt(cordGrid + 20);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                            subviewImage2.setImageResource(R.drawable.orangesquare);

                            matrizTablero[cordY + 1][cordX] = 1;
                            matrizTablero[cordY + 2][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 10);
                        subview2 = gridLayout.getChildAt(cordGrid + 2);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L invertida
                            subviewImage2.setImageResource(0);

                            matrizTablero[cordY - 1][cordX] = 0;
                            matrizTablero[cordY][cordX + 2] = 0;
                        }
                    }
                }
            }else if(orientacion == 3){
                if((cordX - 2) >= 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY][cordX - 2] == 0){
                        orientacion = 4;
                        View subview = gridLayout.getChildAt(cordGrid - 1);
                        View subview2 = gridLayout.getChildAt(cordGrid - 2);


                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                            subviewImage2.setImageResource(R.drawable.orangesquare);
                            matrizTablero[cordY][cordX - 1] = 1;
                            matrizTablero[cordY][cordX - 2] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 20);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L invertida
                            subviewImage2.setImageResource(0);

                            matrizTablero[cordY][cordX + 1] = 0;
                            matrizTablero[cordY + 2][cordX ] = 0;
                        }
                    }
                }
            }else{
                if((cordY - 2) >= 0){
                    if(matrizTablero[cordY - 1][cordX] == 0 && matrizTablero[cordY - 2][cordX] == 0){
                        orientacion = 1;
                        View subview = gridLayout.getChildAt(cordGrid - 10);
                        View subview2 = gridLayout.getChildAt(cordGrid - 20);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                            subviewImage2.setImageResource(R.drawable.orangesquare);

                            matrizTablero[cordY - 1][cordX] = 1;
                            matrizTablero[cordY - 2][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 10);
                        subview2 = gridLayout.getChildAt(cordGrid - 2);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L invertida
                            subviewImage2.setImageResource(0);

                            matrizTablero[cordY + 1][cordX] = 0;
                            matrizTablero[cordY][cordX - 2] = 0;
                        }
                    }
                }
            }
        }else if(figura == 2){
            if(orientacion == 1){
                if((cordX + 2) <= 19 && (cordY + 1) <= 19){
                    if(matrizTablero[cordY][cordX + 2] == 0 && matrizTablero[cordY + 1][cordX] == 0){
                        orientacion = 2;
                        View subview = gridLayout.getChildAt(cordGrid + 10);
                        View subview2 = gridLayout.getChildAt(cordGrid + 2);


                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.bluesquare);  //L
                            subviewImage2.setImageResource(R.drawable.bluesquare);
                            matrizTablero[cordY + 1][cordX] = 1;
                            matrizTablero[cordY][cordX + 2] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 10);
                        subview2 = gridLayout.getChildAt(cordGrid - 20);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);

                            matrizTablero[cordY - 1][cordX] = 0;
                            matrizTablero[cordY - 2][cordX ] = 0;
                        }
                    }
                }
            }else if(orientacion == 2){
                if((cordY + 2) <= 19 && (cordX - 1) >= 0){
                    if(matrizTablero[cordY + 2][cordX] == 0 && matrizTablero[cordY][cordX - 1] == 0){
                        orientacion = 3;
                        View subview = gridLayout.getChildAt(cordGrid - 1);
                        View subview2 = gridLayout.getChildAt(cordGrid + 20);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.bluesquare);  //L
                            subviewImage2.setImageResource(R.drawable.bluesquare);

                            matrizTablero[cordY][cordX - 1] = 1;
                            matrizTablero[cordY + 2][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 2);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);

                            matrizTablero[cordY][cordX + 1] = 0;
                            matrizTablero[cordY][cordX + 2] = 0;
                        }
                    }
                }
            }else if(orientacion == 3){
                if((cordX - 2) >= 0){
                    if(matrizTablero[cordY][cordX - 2] == 0 && matrizTablero[cordY - 1][cordX] == 0){
                        orientacion = 4;
                        View subview = gridLayout.getChildAt(cordGrid - 10);
                        View subview2 = gridLayout.getChildAt(cordGrid - 2);


                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.bluesquare);  //L
                            subviewImage2.setImageResource(R.drawable.bluesquare);
                            matrizTablero[cordY - 1][cordX] = 1;
                            matrizTablero[cordY][cordX - 2] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 10);
                        subview2 = gridLayout.getChildAt(cordGrid + 20);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);

                            matrizTablero[cordY + 1][cordX] = 0;
                            matrizTablero[cordY + 2][cordX ] = 0;
                        }
                    }
                }
            }else{
                if((cordY - 2) >= 0 && (cordX + 1) <= 19){
                    if(matrizTablero[cordY][cordX + 1] == 0 && matrizTablero[cordY - 2][cordX] == 0){
                        orientacion = 1;
                        View subview = gridLayout.getChildAt(cordGrid + 1);
                        View subview2 = gridLayout.getChildAt(cordGrid - 20);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.bluesquare);  //L
                            subviewImage2.setImageResource(R.drawable.bluesquare);

                            matrizTablero[cordY][cordX + 1] = 1;
                            matrizTablero[cordY - 2][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 2);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);

                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY][cordX - 2] = 0;
                        }
                    }
                }
            }
        }else if(figura == 3){

        }else if(figura == 4){
            if(orientacion == 1 || orientacion == 3){
                if((cordY - 2) >= 0){
                    if(matrizTablero[cordY - 1][cordX] == 0 && matrizTablero[cordY - 2][cordX] == 0){
                        orientacion = 2;
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid - 11);
                        View subview2 = gridLayout.getChildAt(cordGrid - 21);


                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.lightbluesquare);  //Z invertida
                            subviewImage2.setImageResource(R.drawable.lightbluesquare);
                            matrizTablero[cordY - 1][cordX - 1] = 1;
                            matrizTablero[cordY - 2][cordX - 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 9);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);

                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY - 1][cordX + 1] = 0;
                        }
                    }
                }
            }else if(orientacion == 2 || orientacion == 4){
                if((cordX + 1) <= 19){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY - 1][cordX + 1] == 0){
                        orientacion = 3;
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 8);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.lightbluesquare);  //Z invertida
                            subviewImage2.setImageResource(R.drawable.lightbluesquare);

                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX + 2] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 10);
                        subview2 = gridLayout.getChildAt(cordGrid - 20);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Z invertida
                            subviewImage2.setImageResource(0);

                            matrizTablero[cordY - 1][cordX] = 0;
                            matrizTablero[cordY - 2][cordX] = 0;
                        }
                    }
                }
            }
        }else if(figura == 5){
            if(orientacion == 1 || orientacion == 3){
                if((cordY - 2) >= 0){
                    if(matrizTablero[cordY - 1][cordX + 1] == 0 && matrizTablero[cordY - 2][cordX + 1] == 0){
                        orientacion = 2;
                        cordY -= 1;
                        cordGrid -= 10;
                        View subview = gridLayout.getChildAt(cordGrid + 1);
                        View subview2 = gridLayout.getChildAt(cordGrid - 9);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.yellowsquare);  //Z
                            subviewImage2.setImageResource(R.drawable.yellowsquare);
                            matrizTablero[cordY - 1][cordX + 1] = 1;
                            matrizTablero[cordY][cordX + 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 11);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);

                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY + 1][cordX + 1] = 0;
                        }
                    }
                }
            }else if(orientacion == 2 || orientacion == 4){
                if((cordX - 1) >= 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY + 1][cordX + 1] == 0){
                        orientacion = 1;
                        cordY += 1;
                        cordGrid += 10;
                        View subview = gridLayout.getChildAt(cordGrid + 1);
                        View subview2 = gridLayout.getChildAt(cordGrid - 11);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.yellowsquare);  //Z
                            subviewImage2.setImageResource(R.drawable.yellowsquare);

                            matrizTablero[cordY][cordX + 1] = 1;
                            matrizTablero[cordY - 1][cordX - 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 9);
                        subview2 = gridLayout.getChildAt(cordGrid - 19);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Z
                            subviewImage2.setImageResource(0);

                            matrizTablero[cordY - 1][cordX + 1] = 0;
                            matrizTablero[cordY - 2][cordX + 1] = 0;
                        }
                    }
                }
            }
        }else{
            if(orientacion == 1){
                if((cordX - 1) >= 0 && (cordY - 2) >= 0){
                    if(matrizTablero[cordY - 2][cordX] == 0){
                        orientacion = 2;
                        cordX -= 1;
                        cordY -= 1;
                        cordGrid -= 11;
                        View subview = gridLayout.getChildAt(cordGrid - 9);

                        ImageView subviewImage = (ImageView) subview;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.purplesquare);  //T
                            matrizTablero[cordY - 1][cordX + 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 2);

                        subviewImage = (ImageView) subview;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //T

                            matrizTablero[cordY][cordX + 2] = 0;
                        }
                    }
                }
            }else if(orientacion == 2){
                if((cordX + 2) <= 19){
                    if(matrizTablero[cordY][cordX + 2] == 0){
                        orientacion = 3;
                        cordX += 1;
                        cordY -= 1;
                        cordGrid -= 9;
                        View subview = gridLayout.getChildAt(cordGrid + 11);

                        ImageView subviewImage = (ImageView) subview;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.purplesquare);  //T

                            matrizTablero[cordY + 1][cordX + 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 20);

                        subviewImage = (ImageView) subview;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //T

                            matrizTablero[cordY + 2][cordX] = 0;
                        }
                    }
                }
            }else if(orientacion == 3){
                if((cordY + 2) <= 19){
                    if(matrizTablero[cordY + 2][cordX] == 0){
                        orientacion = 4;
                        cordX += 1;
                        cordY += 1;
                        cordGrid += 11;
                        View subview = gridLayout.getChildAt(cordGrid + 9);

                        ImageView subviewImage = (ImageView) subview;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.purplesquare);  //T
                            matrizTablero[cordY + 1][cordX - 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 2);

                        subviewImage = (ImageView) subview;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //T

                            matrizTablero[cordY][cordX - 2] = 0;
                        }
                    }
                }
            }else{
                if((cordX - 2) >= 0){
                    if(matrizTablero[cordY][cordX - 2] == 0){
                        orientacion = 1;
                        cordX -= 1;
                        cordY += 1;
                        cordGrid += 9;
                        View subview = gridLayout.getChildAt(cordGrid - 11);

                        ImageView subviewImage = (ImageView) subview;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.purplesquare);  //T

                            matrizTablero[cordY - 1][cordX - 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 20);

                        subviewImage = (ImageView) subview;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //T

                            matrizTablero[cordY - 2][cordX] = 0;
                        }
                    }
                }
            }
        }
    }


    public void moverDerecha(){
        if(figura == 0){
            if(orientacion == 1 || orientacion == 3){
                if(cordX < 19){
                    if(matrizTablero[cordY][cordX + 1] == 0 && matrizTablero[cordY - 1][cordX + 1] == 0 && matrizTablero[cordY - 2][cordX + 1] == 0 && matrizTablero[cordY - 3][cordX + 1] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 10);
                        View subview3 = gridLayout.getChildAt(cordGrid - 20);
                        View subview4 = gridLayout.getChildAt(cordGrid - 30);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        ImageView subviewImage4 = (ImageView) subview4;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.greensquare);  //Barra
                            subviewImage2.setImageResource(R.drawable.greensquare);
                            subviewImage3.setImageResource(R.drawable.greensquare);
                            subviewImage4.setImageResource(R.drawable.greensquare);
                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX] = 1;
                            matrizTablero[cordY - 2][cordX] = 1;
                            matrizTablero[cordY - 3][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 11);
                        subview3 = gridLayout.getChildAt(cordGrid - 21);
                        subview4 = gridLayout.getChildAt(cordGrid - 31);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        subviewImage4 = (ImageView) subview4;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Barra
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);
                            subviewImage4.setImageResource(0);
                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY - 1][cordX - 1] = 0;
                            matrizTablero[cordY - 2][cordX - 1] = 0;
                            matrizTablero[cordY - 3][cordX - 1] = 0;
                        }
                    }
                }
            }else{
                if((cordX + 3) < 19){
                    if(matrizTablero[cordY][cordX + 4] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid + 3);

                        ImageView subviewImage = (ImageView) subview;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.greensquare);  //Barra

                            matrizTablero[cordY][cordX + 3] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);

                        subviewImage = (ImageView) subview;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Barra

                            matrizTablero[cordY][cordX - 1] = 0;
                        }
                    }
                }
            }
        }else if(figura == 1){
            if(orientacion == 1){
                if(cordX < 19){
                    if(matrizTablero[cordY][cordX + 1] == 0 && matrizTablero[cordY - 1][cordX + 1] == 0 && matrizTablero[cordY - 2][cordX + 1] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 10);
                        View subview3 = gridLayout.getChildAt(cordGrid - 20);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                            subviewImage2.setImageResource(R.drawable.orangesquare);
                            subviewImage3.setImageResource(R.drawable.orangesquare);
                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX] = 1;
                            matrizTablero[cordY - 2][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 2);
                        subview2 = gridLayout.getChildAt(cordGrid - 11);
                        subview3 = gridLayout.getChildAt(cordGrid - 21);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L invertida
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);
                            matrizTablero[cordY][cordX - 2] = 0;
                            matrizTablero[cordY - 1][cordX - 1] = 0;
                            matrizTablero[cordY - 2][cordX - 1] = 0;
                        }
                    }
                }
            }else if(orientacion == 2){
                if((cordX + 2) < 19){
                    if(matrizTablero[cordY][cordX + 3] == 0 && matrizTablero[cordY - 1][cordX + 1] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid + 2);
                        View subview2 = gridLayout.getChildAt(cordGrid - 10);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                            subviewImage2.setImageResource(R.drawable.orangesquare);
                            matrizTablero[cordY][cordX + 2] = 1;
                            matrizTablero[cordY - 1][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 11);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L invertida
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY - 1][cordX - 1] = 0;
                        }
                    }
                }
            }else if(orientacion == 3){
                if((cordX + 1) < 19){
                    if(matrizTablero[cordY][cordX + 2] == 0 && matrizTablero[cordY + 1][cordX + 1] == 0 && matrizTablero[cordY + 2][cordX + 1] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid + 1);
                        View subview2 = gridLayout.getChildAt(cordGrid + 10);
                        View subview3 = gridLayout.getChildAt(cordGrid + 20);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                            subviewImage2.setImageResource(R.drawable.orangesquare);
                            subviewImage3.setImageResource(R.drawable.orangesquare);
                            matrizTablero[cordY][cordX + 1] = 1;
                            matrizTablero[cordY + 1][cordX] = 1;
                            matrizTablero[cordY + 2][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 9);
                        subview3 = gridLayout.getChildAt(cordGrid + 19);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L invertida
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);
                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY + 1][cordX - 1] = 0;
                            matrizTablero[cordY + 2][cordX - 1] = 0;
                        }
                    }
                }
            }else{
                if(cordX < 19){
                    if(matrizTablero[cordY][cordX + 1] == 0 && matrizTablero[cordY + 1][cordX + 1] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid + 10);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                            subviewImage2.setImageResource(R.drawable.orangesquare);
                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY + 1][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 9);
                        subview2 = gridLayout.getChildAt(cordGrid - 3);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L invertida
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY + 1][cordX - 1] = 0;
                            matrizTablero[cordY][cordX - 3] = 0;
                        }
                    }
                }
            }
        }else if(figura == 2){
            if(orientacion == 1){
                if((cordX + 1) < 19){
                    if(matrizTablero[cordY][cordX + 2] == 0 && matrizTablero[cordY - 1][cordX + 1] == 0 && matrizTablero[cordY - 2][cordX + 1] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid + 1);
                        View subview2 = gridLayout.getChildAt(cordGrid - 10);
                        View subview3 = gridLayout.getChildAt(cordGrid - 20);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.bluesquare);  //L
                            subviewImage2.setImageResource(R.drawable.bluesquare);
                            subviewImage3.setImageResource(R.drawable.bluesquare);
                            matrizTablero[cordY][cordX + 1] = 1;
                            matrizTablero[cordY - 1][cordX] = 1;
                            matrizTablero[cordY - 2][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 11);
                        subview3 = gridLayout.getChildAt(cordGrid - 21);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);
                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY - 1][cordX - 1] = 0;
                            matrizTablero[cordY - 2][cordX - 1] = 0;
                        }
                    }
                }
            }else if(orientacion == 2){
                if((cordX + 2) < 19){
                    if(matrizTablero[cordY][cordX + 3] == 0 && matrizTablero[cordY + 1][cordX + 1] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid + 2);
                        View subview2 = gridLayout.getChildAt(cordGrid + 10);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.bluesquare);  //L
                            subviewImage2.setImageResource(R.drawable.bluesquare);
                            matrizTablero[cordY][cordX + 2] = 1;
                            matrizTablero[cordY + 1][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 9);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY + 1][cordX - 1] = 0;
                        }
                    }
                }
            }else if(orientacion == 3){
                if(cordX < 19){
                    if(matrizTablero[cordY][cordX + 1] == 0 && matrizTablero[cordY + 2][cordX + 1] == 0 && matrizTablero[cordY + 1][cordX + 1] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid + 10);
                        View subview3 = gridLayout.getChildAt(cordGrid + 20);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.bluesquare);  //L
                            subviewImage2.setImageResource(R.drawable.bluesquare);
                            subviewImage3.setImageResource(R.drawable.bluesquare);
                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY + 1][cordX] = 1;
                            matrizTablero[cordY + 2][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 2);
                        subview2 = gridLayout.getChildAt(cordGrid + 9);
                        subview3 = gridLayout.getChildAt(cordGrid + 19);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);
                            matrizTablero[cordY][cordX - 2] = 0;
                            matrizTablero[cordY + 1][cordX - 1] = 0;
                            matrizTablero[cordY + 2][cordX - 1] = 0;
                        }
                    }
                }
            }else{
                if(cordX < 19){
                    if(matrizTablero[cordY][cordX + 1] == 0 && matrizTablero[cordY - 1][cordX + 1] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 10);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.bluesquare);  //L
                            subviewImage2.setImageResource(R.drawable.bluesquare);
                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 11);
                        subview2 = gridLayout.getChildAt(cordGrid - 3);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY - 1][cordX - 1] = 0;
                            matrizTablero[cordY][cordX - 3] = 0;
                        }
                    }
                }
            }
        }else if(figura == 3){
            if((cordX + 1) < 19){
                if(matrizTablero[cordY][cordX + 2] == 0 && matrizTablero[cordY - 1][cordX + 2] == 0){
                    cordX += 1;
                    cordGrid += 1;
                    View subview = gridLayout.getChildAt(cordGrid + 1);
                    View subview2 = gridLayout.getChildAt(cordGrid - 9);

                    ImageView subviewImage = (ImageView) subview;
                    ImageView subviewImage2 = (ImageView) subview2;
                    if(subview instanceof ImageView){
                        subviewImage.setImageResource(R.drawable.redsquare);  //Cuadro
                        subviewImage2.setImageResource(R.drawable.redsquare);
                        matrizTablero[cordY][cordX + 1] = 1;
                        matrizTablero[cordY - 1][cordX + 1] = 1;
                    }

                    subview = gridLayout.getChildAt(cordGrid - 1);
                    subview2 = gridLayout.getChildAt(cordGrid - 11);

                    subviewImage = (ImageView) subview;
                    subviewImage2 = (ImageView) subview2;
                    if(subview instanceof ImageView){
                        subviewImage.setImageResource(0);  //L
                        subviewImage2.setImageResource(0);
                        matrizTablero[cordY][cordX - 1] = 0;
                        matrizTablero[cordY - 1][cordX - 1] = 0;
                    }
                }
            }
        }else if(figura == 4){
            if(orientacion == 1 || orientacion == 3){
                if((cordX + 2) < 19){
                    if(matrizTablero[cordY][cordX + 2] == 0 && matrizTablero[cordY - 1][cordX + 3] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid + 1);
                        View subview2 = gridLayout.getChildAt(cordGrid - 8);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.lightbluesquare);  //Z invertida
                            subviewImage2.setImageResource(R.drawable.lightbluesquare);

                            matrizTablero[cordY][cordX + 1] = 1;
                            matrizTablero[cordY - 1][cordX + 2] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 10);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Z invertida
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY - 1][cordX] = 0;
                        }
                    }
                }
            }else{
                if(cordX < 19){
                    if(matrizTablero[cordY][cordX + 1] == 0 && matrizTablero[cordY - 1][cordX + 1] == 0 && matrizTablero[cordY - 2][cordX] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 10);
                        View subview3 = gridLayout.getChildAt(cordGrid - 21);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.lightbluesquare);  //Z invertida
                            subviewImage2.setImageResource(R.drawable.lightbluesquare);
                            subviewImage3.setImageResource(R.drawable.lightbluesquare);

                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX] = 1;
                            matrizTablero[cordY - 2][cordX -1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 12);
                        subview3 = gridLayout.getChildAt(cordGrid - 22);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Z invertida
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);

                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY - 1][cordX - 2] = 0;
                            matrizTablero[cordY - 2][cordX - 2] = 0;
                        }
                    }
                }
            }
        }else if(figura == 5){
            if(orientacion == 1 || orientacion == 3){
                if((cordX + 1) < 19){
                    if(matrizTablero[cordY][cordX + 2] == 0 && matrizTablero[cordY - 1][cordX + 1] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid + 1);
                        View subview2 = gridLayout.getChildAt(cordGrid - 10);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.yellowsquare);  //Z
                            subviewImage2.setImageResource(R.drawable.yellowsquare);

                            matrizTablero[cordY][cordX + 1] = 1;
                            matrizTablero[cordY - 1][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 12);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Z
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY - 1][cordX - 2] = 0;
                        }
                    }
                }
            }else{
                if((cordX + 1) < 19){
                    if(matrizTablero[cordY][cordX + 2] == 0 && matrizTablero[cordY - 1][cordX + 2] == 0 && matrizTablero[cordY + 1][cordX + 1] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid + 1);
                        View subview2 = gridLayout.getChildAt(cordGrid - 9);
                        View subview3 = gridLayout.getChildAt(cordGrid + 10);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.yellowsquare);  //Z
                            subviewImage2.setImageResource(R.drawable.yellowsquare);
                            subviewImage3.setImageResource(R.drawable.yellowsquare);

                            matrizTablero[cordY][cordX + 1] = 1;
                            matrizTablero[cordY - 1][cordX + 1] = 1;
                            matrizTablero[cordY + 1][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 9);
                        subview3 = gridLayout.getChildAt(cordGrid - 10);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Z
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);

                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY - 1][cordX] = 0;
                            matrizTablero[cordY + 1][cordX - 1] = 0;
                        }
                    }
                }
            }
        }else if(figura == 6){
            if(orientacion == 1){
                if((cordX + 1) < 19){
                    if(matrizTablero[cordY][cordX + 1] == 0 && matrizTablero[cordY - 1][cordX + 2] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 9);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.purplesquare);  //T
                            subviewImage2.setImageResource(R.drawable.purplesquare);

                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX + 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 12);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //T
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY - 1][cordX - 2] = 0;
                        }
                    }
                }
            }else if(orientacion == 2){
                if((cordX + 1) < 19){
                    if(matrizTablero[cordY][cordX + 2] == 0 && matrizTablero[cordY - 1][cordX + 2] == 0 && matrizTablero[cordY + 1][cordX + 2] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid + 1);
                        View subview2 = gridLayout.getChildAt(cordGrid - 9);
                        View subview3 = gridLayout.getChildAt(cordGrid + 11);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.purplesquare);  //T
                            subviewImage2.setImageResource(R.drawable.purplesquare);
                            subviewImage3.setImageResource(R.drawable.purplesquare);

                            matrizTablero[cordY][cordX + 1] = 1;
                            matrizTablero[cordY - 1][cordX + 1] = 1;
                            matrizTablero[cordY + 1][cordX + 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 10);
                        subview3 = gridLayout.getChildAt(cordGrid - 10);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //T
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);

                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY - 1][cordX] = 0;
                            matrizTablero[cordY + 1][cordX] = 0;
                        }
                    }
                }
            } else if(orientacion == 3){
                if((cordX + 1) < 19){
                    if(matrizTablero[cordY][cordX + 1] == 0 && matrizTablero[cordY + 1][cordX + 2] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid + 11);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.purplesquare);  //T
                            subviewImage2.setImageResource(R.drawable.purplesquare);

                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY + 1][cordX + 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 8);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //T
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY][cordX - 1] = 0;
                            matrizTablero[cordY + 1][cordX - 2] = 0;
                        }
                    }
                }
            } else{
                if(cordX < 19){
                    if(matrizTablero[cordY][cordX + 1] == 0 && matrizTablero[cordY - 1][cordX] == 0 && matrizTablero[cordY + 1][cordX] == 0){
                        cordX += 1;
                        cordGrid += 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 11);
                        View subview3 = gridLayout.getChildAt(cordGrid + 9);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.purplesquare);  //T
                            subviewImage2.setImageResource(R.drawable.purplesquare);
                            subviewImage3.setImageResource(R.drawable.purplesquare);

                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX - 1] = 1;
                            matrizTablero[cordY + 1][cordX - 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid - 2);
                        subview2 = gridLayout.getChildAt(cordGrid + 8);
                        subview3 = gridLayout.getChildAt(cordGrid - 12);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //T
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);

                            matrizTablero[cordY][cordX - 2] = 0;
                            matrizTablero[cordY - 1][cordX - 2] = 0;
                            matrizTablero[cordY + 1][cordX - 2] = 0;
                        }
                    }
                }
            }
        }
    }

    //*******************************************************************************************************************************************************************
    public void moverIzquierda(){
        if(figura == 0){
            if(orientacion == 1 || orientacion == 3){
                if(cordX > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY - 1][cordX - 1] == 0 && matrizTablero[cordY - 2][cordX - 1] == 0 && matrizTablero[cordY - 3][cordX - 1] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 10);
                        View subview3 = gridLayout.getChildAt(cordGrid - 20);
                        View subview4 = gridLayout.getChildAt(cordGrid - 30);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        ImageView subviewImage4 = (ImageView) subview4;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.greensquare);  //Barra
                            subviewImage2.setImageResource(R.drawable.greensquare);
                            subviewImage3.setImageResource(R.drawable.greensquare);
                            subviewImage4.setImageResource(R.drawable.greensquare);
                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX] = 1;
                            matrizTablero[cordY - 2][cordX] = 1;
                            matrizTablero[cordY - 3][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 9);
                        subview3 = gridLayout.getChildAt(cordGrid - 19);
                        subview4 = gridLayout.getChildAt(cordGrid - 29);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        subviewImage4 = (ImageView) subview4;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Barra
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);
                            subviewImage4.setImageResource(0);
                            matrizTablero[cordY][cordX + 1] = 0;
                            matrizTablero[cordY - 1][cordX + 1] = 0;
                            matrizTablero[cordY - 2][cordX + 1] = 0;
                            matrizTablero[cordY - 3][cordX + 1] = 0;
                        }
                    }
                }
            }else{
                if(cordX > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);

                        ImageView subviewImage = (ImageView) subview;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.greensquare);  //Barra

                            matrizTablero[cordY][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 4);

                        subviewImage = (ImageView) subview;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Barra

                            matrizTablero[cordY][cordX + 4] = 0;
                        }
                    }
                }
            }
        }else if(figura == 1){
            if(orientacion == 1){
                if((cordX + 1) > 0){
                    if(matrizTablero[cordY][cordX - 2] == 0 && matrizTablero[cordY - 1][cordX - 1] == 0 && matrizTablero[cordY - 2][cordX - 1] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid - 1);
                        View subview2 = gridLayout.getChildAt(cordGrid - 10);
                        View subview3 = gridLayout.getChildAt(cordGrid - 20);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                            subviewImage2.setImageResource(R.drawable.orangesquare);
                            subviewImage3.setImageResource(R.drawable.orangesquare);
                            matrizTablero[cordY][cordX - 1] = 1;
                            matrizTablero[cordY - 1][cordX] = 1;
                            matrizTablero[cordY - 2][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 9);
                        subview3 = gridLayout.getChildAt(cordGrid - 19);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L invertida
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);
                            matrizTablero[cordY][cordX + 1] = 0;
                            matrizTablero[cordY - 1][cordX + 1] = 0;
                            matrizTablero[cordY - 2][cordX + 1] = 0;
                        }
                    }
                }
            }else if(orientacion == 2){
                if(cordX > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY - 1][cordX - 1] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 10);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                            subviewImage2.setImageResource(R.drawable.orangesquare);
                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 3);
                        subview2 = gridLayout.getChildAt(cordGrid - 9);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L invertida
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY][cordX + 3] = 0;
                            matrizTablero[cordY - 1][cordX + 1] = 0;
                        }
                    }
                }
            }else if(orientacion == 3){
                if(cordX > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY + 1][cordX - 1] == 0 && matrizTablero[cordY + 2][cordX - 1] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid + 10);
                        View subview3 = gridLayout.getChildAt(cordGrid + 20);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                            subviewImage2.setImageResource(R.drawable.orangesquare);
                            subviewImage3.setImageResource(R.drawable.orangesquare);
                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY + 1][cordX] = 1;
                            matrizTablero[cordY + 2][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 2);
                        subview2 = gridLayout.getChildAt(cordGrid + 11);
                        subview3 = gridLayout.getChildAt(cordGrid + 21);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L invertida
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);
                            matrizTablero[cordY][cordX + 2] = 0;
                            matrizTablero[cordY + 1][cordX + 1] = 0;
                            matrizTablero[cordY + 2][cordX + 1] = 0;
                        }
                    }
                }
            }else{
                if((cordX + 2) < 19){
                    if(matrizTablero[cordY][cordX - 3] == 0 && matrizTablero[cordY + 1][cordX - 1] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid - 2);
                        View subview2 = gridLayout.getChildAt(cordGrid + 10);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                            subviewImage2.setImageResource(R.drawable.orangesquare);
                            matrizTablero[cordY][cordX - 2] = 1;
                            matrizTablero[cordY + 1][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 11);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L invertida
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY + 1][cordX + 1] = 0;
                            matrizTablero[cordY][cordX + 1] = 0;
                        }
                    }
                }
            }
        }else if(figura == 2){
            if(orientacion == 1){
                if(cordX > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY - 1][cordX - 1] == 0 && matrizTablero[cordY - 2][cordX - 1] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 10);
                        View subview3 = gridLayout.getChildAt(cordGrid - 20);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.bluesquare);  //L
                            subviewImage2.setImageResource(R.drawable.bluesquare);
                            subviewImage3.setImageResource(R.drawable.bluesquare);
                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX] = 1;
                            matrizTablero[cordY - 2][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 2);
                        subview2 = gridLayout.getChildAt(cordGrid - 9);
                        subview3 = gridLayout.getChildAt(cordGrid - 19);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);
                            matrizTablero[cordY][cordX + 2] = 0;
                            matrizTablero[cordY - 1][cordX + 1] = 0;
                            matrizTablero[cordY - 2][cordX + 1] = 0;
                        }
                    }
                }
            }else if(orientacion == 2){
                if(cordX > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY + 1][cordX - 1] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid + 10);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.bluesquare);  //L
                            subviewImage2.setImageResource(R.drawable.bluesquare);
                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY + 1][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 3);
                        subview2 = gridLayout.getChildAt(cordGrid + 11);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY][cordX + 3] = 0;
                            matrizTablero[cordY + 1][cordX + 1] = 0;
                        }
                    }
                }
            }else if(orientacion == 3){
                if((cordX - 1) > 0){
                    if(matrizTablero[cordY][cordX - 2] == 0 && matrizTablero[cordY + 2][cordX - 1] == 0 && matrizTablero[cordY + 1][cordX - 1] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid - 1);
                        View subview2 = gridLayout.getChildAt(cordGrid + 10);
                        View subview3 = gridLayout.getChildAt(cordGrid + 20);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.bluesquare);  //L
                            subviewImage2.setImageResource(R.drawable.bluesquare);
                            subviewImage3.setImageResource(R.drawable.bluesquare);
                            matrizTablero[cordY][cordX - 1] = 1;
                            matrizTablero[cordY + 1][cordX] = 1;
                            matrizTablero[cordY + 2][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 11);
                        subview3 = gridLayout.getChildAt(cordGrid + 21);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);
                            matrizTablero[cordY][cordX + 1] = 0;
                            matrizTablero[cordY + 1][cordX + 1] = 0;
                            matrizTablero[cordY + 2][cordX + 1] = 0;
                        }
                    }
                }
            }else{
                if(cordX > 0){
                    if(matrizTablero[cordY][cordX - 3] == 0 && matrizTablero[cordY - 1][cordX - 1] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid - 2);
                        View subview2 = gridLayout.getChildAt(cordGrid - 10);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.bluesquare);  //L
                            subviewImage2.setImageResource(R.drawable.bluesquare);
                            matrizTablero[cordY][cordX - 2] = 1;
                            matrizTablero[cordY - 1][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 9);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //L
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY - 1][cordX + 1] = 0;
                            matrizTablero[cordY][cordX + 1] = 0;
                        }
                    }
                }
            }
        }else if(figura == 3){
            if(cordX > 0){
                if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY - 1][cordX - 1] == 0){
                    cordX -= 1;
                    cordGrid -= 1;
                    View subview = gridLayout.getChildAt(cordGrid);
                    View subview2 = gridLayout.getChildAt(cordGrid - 10);

                    ImageView subviewImage = (ImageView) subview;
                    ImageView subviewImage2 = (ImageView) subview2;
                    if(subview instanceof ImageView){
                        subviewImage.setImageResource(R.drawable.redsquare);  //Cuadro
                        subviewImage2.setImageResource(R.drawable.redsquare);
                        matrizTablero[cordY][cordX] = 1;
                        matrizTablero[cordY - 1][cordX] = 1;
                    }

                    subview = gridLayout.getChildAt(cordGrid + 2);
                    subview2 = gridLayout.getChildAt(cordGrid - 8);

                    subviewImage = (ImageView) subview;
                    subviewImage2 = (ImageView) subview2;
                    if(subview instanceof ImageView){
                        subviewImage.setImageResource(0);  //L
                        subviewImage2.setImageResource(0);
                        matrizTablero[cordY][cordX + 2] = 0;
                        matrizTablero[cordY - 1][cordX + 2] = 0;
                    }
                }
            }
        }else if(figura == 4){
            if(orientacion == 1 || orientacion == 3){
                if(cordX > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY - 1][cordX] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 9);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.lightbluesquare);  //Z invertida
                            subviewImage2.setImageResource(R.drawable.lightbluesquare);

                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX + 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 2);
                        subview2 = gridLayout.getChildAt(cordGrid - 7);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Z invertida
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY][cordX + 2] = 0;
                            matrizTablero[cordY - 1][cordX + 3] = 0;
                        }
                    }
                }
            }else{
                if((cordX + 1) > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY - 1][cordX - 2] == 0 && matrizTablero[cordY - 2][cordX - 2] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 11);
                        View subview3 = gridLayout.getChildAt(cordGrid - 21);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.lightbluesquare);  //Z invertida
                            subviewImage2.setImageResource(R.drawable.lightbluesquare);
                            subviewImage3.setImageResource(R.drawable.lightbluesquare);

                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX - 1] = 1;
                            matrizTablero[cordY - 2][cordX -1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 9);
                        subview3 = gridLayout.getChildAt(cordGrid - 20);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Z invertida
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);

                            matrizTablero[cordY][cordX + 1] = 0;
                            matrizTablero[cordY - 1][cordX + 1] = 0;
                            matrizTablero[cordY - 2][cordX] = 0;
                        }
                    }
                }
            }
        }else if(figura == 5){
            if(orientacion == 1 || orientacion == 3){
                if((cordX - 1) > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY - 1][cordX - 2] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 11);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.yellowsquare);  //Z
                            subviewImage2.setImageResource(R.drawable.yellowsquare);

                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX - 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 2);
                        subview2 = gridLayout.getChildAt(cordGrid - 9);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Z
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY][cordX + 2] = 0;
                            matrizTablero[cordY - 1][cordX + 1] = 0;
                        }
                    }
                }
            }else{
                if(cordX > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY - 1][cordX] == 0 && matrizTablero[cordY + 1][cordX - 1] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 9);
                        View subview3 = gridLayout.getChildAt(cordGrid + 10);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.yellowsquare);  //Z
                            subviewImage2.setImageResource(R.drawable.yellowsquare);
                            subviewImage3.setImageResource(R.drawable.yellowsquare);

                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX + 1] = 1;
                            matrizTablero[cordY + 1][cordX] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 2);
                        subview2 = gridLayout.getChildAt(cordGrid + 11);
                        subview3 = gridLayout.getChildAt(cordGrid - 8);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //Z
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);

                            matrizTablero[cordY][cordX + 2] = 0;
                            matrizTablero[cordY - 1][cordX + 2] = 0;
                            matrizTablero[cordY + 1][cordX + 1] = 0;
                        }
                    }
                }
            }
        }else if(figura == 6){
            if(orientacion == 1){
                if((cordX - 1) > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY - 1][cordX - 2] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 11);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.purplesquare);  //T
                            subviewImage2.setImageResource(R.drawable.purplesquare);

                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX - 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 1);
                        subview2 = gridLayout.getChildAt(cordGrid - 8);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //T
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY][cordX + 1] = 0;
                            matrizTablero[cordY - 1][cordX + 2] = 0;
                        }
                    }
                }
            }else if(orientacion == 2){
                if(cordX > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY - 1][cordX] == 0 && matrizTablero[cordY + 1][cordX] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid - 9);
                        View subview3 = gridLayout.getChildAt(cordGrid + 11);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.purplesquare);  //T
                            subviewImage2.setImageResource(R.drawable.purplesquare);
                            subviewImage3.setImageResource(R.drawable.purplesquare);

                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY - 1][cordX + 1] = 1;
                            matrizTablero[cordY + 1][cordX + 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 2);
                        subview2 = gridLayout.getChildAt(cordGrid + 12);
                        subview3 = gridLayout.getChildAt(cordGrid - 8);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //T
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);

                            matrizTablero[cordY][cordX + 2] = 0;
                            matrizTablero[cordY - 1][cordX + 2] = 0;
                            matrizTablero[cordY + 1][cordX + 2] = 0;
                        }
                    }
                }
            } else if(orientacion == 3){
                if((cordX - 1) > 0){
                    if(matrizTablero[cordY][cordX - 1] == 0 && matrizTablero[cordY + 1][cordX - 2] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid + 9);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.purplesquare);  //T
                            subviewImage2.setImageResource(R.drawable.purplesquare);

                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY + 1][cordX - 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 12);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //T
                            subviewImage2.setImageResource(0);
                            matrizTablero[cordY][cordX + 1] = 0;
                            matrizTablero[cordY + 1][cordX + 2] = 0;
                        }
                    }
                }
            } else{
                if((cordX - 1) > 0){
                    if(matrizTablero[cordY][cordX - 2] == 0 && matrizTablero[cordY - 1][cordX - 2] == 0 && matrizTablero[cordY + 1][cordX - 2] == 0){
                        cordX -= 1;
                        cordGrid -= 1;
                        View subview = gridLayout.getChildAt(cordGrid - 1);
                        View subview2 = gridLayout.getChildAt(cordGrid - 11);
                        View subview3 = gridLayout.getChildAt(cordGrid + 9);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        ImageView subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.purplesquare);  //T
                            subviewImage2.setImageResource(R.drawable.purplesquare);
                            subviewImage3.setImageResource(R.drawable.purplesquare);

                            matrizTablero[cordY][cordX - 1] = 1;
                            matrizTablero[cordY - 1][cordX - 1] = 1;
                            matrizTablero[cordY + 1][cordX - 1] = 1;
                        }

                        subview = gridLayout.getChildAt(cordGrid + 1);
                        subview2 = gridLayout.getChildAt(cordGrid + 10);
                        subview3 = gridLayout.getChildAt(cordGrid - 10);

                        subviewImage = (ImageView) subview;
                        subviewImage2 = (ImageView) subview2;
                        subviewImage3 = (ImageView) subview3;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(0);  //T
                            subviewImage2.setImageResource(0);
                            subviewImage3.setImageResource(0);

                            matrizTablero[cordY][cordX + 1] = 0;
                            matrizTablero[cordY - 1][cordX] = 0;
                            matrizTablero[cordY + 1][cordX] = 0;
                        }
                    }
                }
            }
        }
    }

    //*****************************************************************************************************************************************************************
    public void dibujarFigura(){
        if(figura == 0){
            if(cordY <= 2){
                cordGrid += 10;
                cordY += 1;
                View subview = gridLayout.getChildAt(cordGrid);
                ImageView subviewImage = (ImageView) subview;
                if(subview instanceof ImageView){
                    if(matrizTablero[cordY][cordX] == 1){
                        perder();
                    }else{
                        matrizTablero[cordY][cordX] = 1;

                    }
                    subviewImage.setImageResource(R.drawable.greensquare);  //Barra
                }
            }else{
                cordGrid += 10;
                cordY += 1;
                if(cordY > 19){
                    eliminarFilas();
                    iniciar();
                }else {
                    if(orientacion == 1 || orientacion == 3){
                        if (matrizTablero[cordY][cordX] == 1) {
                            eliminarFilas();
                            iniciar();
                        } else {
                            View subview = gridLayout.getChildAt(cordGrid);
                            ImageView subviewImage = (ImageView) subview;
                            if (subview instanceof ImageView) {
                                subviewImage.setImageResource(R.drawable.greensquare);  //Barra

                                subview = gridLayout.getChildAt(cordGrid - 40);
                                subviewImage = (ImageView) subview;
                                if (subview instanceof ImageView) {
                                    subviewImage.setImageResource(0);
                                }
                                matrizTablero[cordY][cordX] = 1;
                                matrizTablero[cordY - 4][cordX] = 0;
                            }
                        }
                    }else {
                        if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1 || matrizTablero[cordY][cordX + 2] == 1 || matrizTablero[cordY][cordX + 3] == 1){
                            eliminarFilas();
                            iniciar();
                        }else{
                            View subview = gridLayout.getChildAt(cordGrid);
                            View subview2 = gridLayout.getChildAt(cordGrid + 1);
                            View subview3 = gridLayout.getChildAt(cordGrid + 2);
                            View subview4 = gridLayout.getChildAt(cordGrid + 3);

                            ImageView subviewImage = (ImageView) subview;
                            ImageView subviewImage2 = (ImageView) subview2;
                            ImageView subviewImage3 = (ImageView) subview3;
                            ImageView subviewImage4 = (ImageView) subview4;
                            if (subview instanceof ImageView) {
                                subviewImage.setImageResource(R.drawable.greensquare);  //Barra
                                subviewImage2.setImageResource(R.drawable.greensquare);
                                subviewImage3.setImageResource(R.drawable.greensquare);
                                subviewImage4.setImageResource(R.drawable.greensquare);

                                matrizTablero[cordY][cordX] = 1;
                                matrizTablero[cordY][cordX + 1] = 1;
                                matrizTablero[cordY][cordX + 2] = 1;
                                matrizTablero[cordY][cordX + 3] = 1;

                                subview = gridLayout.getChildAt(cordGrid - 10);
                                subview2 = gridLayout.getChildAt(cordGrid - 9);
                                subview3 = gridLayout.getChildAt(cordGrid - 8);
                                subview4 = gridLayout.getChildAt(cordGrid - 7);

                                subviewImage = (ImageView) subview;
                                subviewImage2 = (ImageView) subview2;
                                subviewImage3 = (ImageView) subview3;
                                subviewImage4 = (ImageView) subview4;
                                if (subview instanceof ImageView) {
                                    subviewImage.setImageResource(0);
                                    subviewImage2.setImageResource(0);
                                    subviewImage3.setImageResource(0);
                                    subviewImage4.setImageResource(0);
                                }
                                matrizTablero[cordY - 1][cordX] = 0;
                                matrizTablero[cordY - 1][cordX + 1] = 0;
                                matrizTablero[cordY - 1][cordX + 2] = 0;
                                matrizTablero[cordY - 1][cordX + 3] = 0;
                            }
                        }
                    }
                }

            }
        }else if(figura == 1){
            if(cordY <= 1){
                cordGrid += 10;
                cordY += 1;
                View subview = gridLayout.getChildAt(cordGrid);
                View subview2 = gridLayout.getChildAt(cordGrid - 1);

                ImageView subviewImage = (ImageView) subview;
                ImageView subviewImage2 = (ImageView) subview2;
                if(subview instanceof ImageView){
                    if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX - 1] == 1){
                        perder();
                    }else{
                        subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                        subviewImage2.setImageResource(R.drawable.orangesquare);

                        subview2 = gridLayout.getChildAt(cordGrid - 11);

                        subviewImage2 = (ImageView) subview2;
                        if(subview2 instanceof ImageView){
                            subviewImage2.setImageResource(0);
                        }
                        matrizTablero[cordY][cordX] = 1;
                        matrizTablero[cordY][cordX - 1] = 1;
                        matrizTablero[cordY - 1][cordX - 1] = 0;
                    }

                }
            }else{
                cordGrid += 10;
                cordY += 1;
                if(cordY > 19){
                    eliminarFilas();
                    iniciar();
                }else{
                    if(orientacion == 1){
                        if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX - 1] == 1){
                            eliminarFilas();
                            iniciar();
                        }else{
                            View subview = gridLayout.getChildAt(cordGrid);
                            View subview2 = gridLayout.getChildAt(cordGrid - 1);

                            ImageView subviewImage = (ImageView) subview;
                            ImageView subviewImage2 = (ImageView) subview2;
                            if(subview instanceof ImageView){
                                subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                                subviewImage2.setImageResource(R.drawable.orangesquare);

                                subview = gridLayout.getChildAt(cordGrid - 30);
                                subview2 = gridLayout.getChildAt(cordGrid - 11);

                                subviewImage = (ImageView) subview;
                                subviewImage2 = (ImageView) subview2;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(0);
                                    subviewImage2.setImageResource(0);
                                }
                                matrizTablero[cordY][cordX] = 1;
                                matrizTablero[cordY][cordX - 1] = 1;
                                matrizTablero[cordY - 1][cordX - 1] = 0;
                                matrizTablero[cordY - 3][cordX] = 0;
                            }
                        }
                    }else if(orientacion == 2){
                        if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1 || matrizTablero[cordY][cordX + 2] == 1){
                            eliminarFilas();
                            iniciar();
                        }else{
                            View subview = gridLayout.getChildAt(cordGrid);
                            View subview2 = gridLayout.getChildAt(cordGrid + 1);
                            View subview3 = gridLayout.getChildAt(cordGrid + 2);

                            ImageView subviewImage = (ImageView) subview;
                            ImageView subviewImage2 = (ImageView) subview2;
                            ImageView subviewImage3 = (ImageView) subview3;
                            if(subview instanceof ImageView){
                                subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                                subviewImage2.setImageResource(R.drawable.orangesquare);
                                subviewImage3.setImageResource(R.drawable.orangesquare);

                                matrizTablero[cordY][cordX] = 1;
                                matrizTablero[cordY][cordX + 1] = 1;
                                matrizTablero[cordY][cordX + 2] = 1;

                                subview = gridLayout.getChildAt(cordGrid - 20);
                                subview2 = gridLayout.getChildAt(cordGrid - 9);
                                subview3 = gridLayout.getChildAt(cordGrid - 8);

                                subviewImage = (ImageView) subview;
                                subviewImage2 = (ImageView) subview2;
                                subviewImage3 = (ImageView) subview3;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(0);
                                    subviewImage2.setImageResource(0);
                                    subviewImage3.setImageResource(0);
                                }
                                matrizTablero[cordY - 2][cordX] = 0;
                                matrizTablero[cordY - 1][cordX + 1] = 0;
                                matrizTablero[cordY - 1][cordX + 2] = 0;
                            }
                        }
                    }else if(orientacion == 3){
                        if(cordY < 18){
                            if(matrizTablero[cordY][cordX + 1] == 1 || matrizTablero[cordY + 2][cordX] == 1){
                                eliminarFilas();
                                iniciar();
                            }else{
                                View subview = gridLayout.getChildAt(cordGrid + 1);
                                View subview2 = gridLayout.getChildAt(cordGrid + 20);

                                ImageView subviewImage = (ImageView) subview;
                                ImageView subviewImage2 = (ImageView) subview2;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                                    subviewImage2.setImageResource(R.drawable.orangesquare);

                                    matrizTablero[cordY][cordX + 1] = 1;
                                    matrizTablero[cordY + 2][cordX] = 1;

                                    subview = gridLayout.getChildAt(cordGrid - 10);
                                    subview2 = gridLayout.getChildAt(cordGrid - 9);

                                    subviewImage = (ImageView) subview;
                                    subviewImage2 = (ImageView) subview2;
                                    if(subview instanceof ImageView){
                                        subviewImage.setImageResource(0);
                                        subviewImage2.setImageResource(0);
                                    }
                                    matrizTablero[cordY - 1][cordX + 1] = 0;
                                    matrizTablero[cordY - 1][cordX] = 0;
                                }
                            }
                        }else{
                            eliminarFilas();
                            iniciar();
                        }

                    }else{
                        if(cordY < 19){
                            if(matrizTablero[cordY + 1][cordX] == 1 || matrizTablero[cordY][cordX - 1] == 1 || matrizTablero[cordY][cordX - 2] == 1){
                                eliminarFilas();
                                iniciar();
                            }else{
                                View subview = gridLayout.getChildAt(cordGrid + 10);
                                View subview2 = gridLayout.getChildAt(cordGrid - 1);
                                View subview3 = gridLayout.getChildAt(cordGrid - 2);

                                ImageView subviewImage = (ImageView) subview;
                                ImageView subviewImage2 = (ImageView) subview2;
                                ImageView subviewImage3 = (ImageView) subview3;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(R.drawable.orangesquare);  //L invertida
                                    subviewImage2.setImageResource(R.drawable.orangesquare);
                                    subviewImage3.setImageResource(R.drawable.orangesquare);

                                    matrizTablero[cordY + 1][cordX] = 1;
                                    matrizTablero[cordY][cordX - 1] = 1;
                                    matrizTablero[cordY][cordX - 2] = 1;

                                    subview = gridLayout.getChildAt(cordGrid - 10);
                                    subview2 = gridLayout.getChildAt(cordGrid - 11);
                                    subview3 = gridLayout.getChildAt(cordGrid - 12);

                                    subviewImage = (ImageView) subview;
                                    subviewImage2 = (ImageView) subview2;
                                    subviewImage3 = (ImageView) subview3;
                                    if(subview instanceof ImageView){
                                        subviewImage.setImageResource(0);
                                        subviewImage2.setImageResource(0);
                                        subviewImage3.setImageResource(0);
                                    }
                                    matrizTablero[cordY - 1][cordX] = 0;
                                    matrizTablero[cordY - 1][cordX - 1] = 0;
                                    matrizTablero[cordY - 1][cordX - 2] = 0;
                                }
                            }
                        }else{
                            eliminarFilas();
                            iniciar();
                        }

                    }
                }

            }
        }else if(figura == 2){
            if(cordY <= 1){
                cordGrid += 10;
                cordY += 1;
                View subview = gridLayout.getChildAt(cordGrid);
                View subview2 = gridLayout.getChildAt(cordGrid + 1);

                ImageView subviewImage = (ImageView) subview;
                ImageView subviewImage2 = (ImageView) subview2;
                if(subview instanceof ImageView){
                    if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1){
                        perder();
                    }else{
                        subviewImage.setImageResource(R.drawable.bluesquare);  //L
                        subviewImage2.setImageResource(R.drawable.bluesquare);

                        subview2 = gridLayout.getChildAt(cordGrid - 9);

                        subviewImage2 = (ImageView) subview2;
                        if(subview2 instanceof ImageView){
                            subviewImage2.setImageResource(0);
                        }
                        matrizTablero[cordY][cordX] = 1;
                        matrizTablero[cordY][cordX + 1] = 1;
                        matrizTablero[cordY - 1][cordX + 1] = 0;
                    }
                }
            }else{
                cordGrid += 10;
                cordY += 1;
                if(cordY > 19){
                    eliminarFilas();
                    iniciar();
                }else{
                    if(orientacion == 1){
                        if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1){
                            iniciar();
                        }else{
                            View subview = gridLayout.getChildAt(cordGrid);
                            View subview2 = gridLayout.getChildAt(cordGrid + 1);

                            ImageView subviewImage = (ImageView) subview;
                            ImageView subviewImage2 = (ImageView) subview2;
                            if(subview instanceof ImageView){
                                subviewImage.setImageResource(R.drawable.bluesquare);  //L
                                subviewImage2.setImageResource(R.drawable.bluesquare);

                                subview = gridLayout.getChildAt(cordGrid - 30);
                                subview2 = gridLayout.getChildAt(cordGrid - 9);

                                subviewImage = (ImageView) subview;
                                subviewImage2 = (ImageView) subview2;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(0);
                                    subviewImage2.setImageResource(0);
                                }
                                matrizTablero[cordY][cordX] = 1;
                                matrizTablero[cordY][cordX + 1] = 1;
                                matrizTablero[cordY - 1][cordX + 1] = 0;
                                matrizTablero[cordY - 3][cordX] = 0;
                            }
                        }

                    }else if(orientacion == 2){
                        if(cordY < 19){
                            if(matrizTablero[cordY + 1][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1 || matrizTablero[cordY][cordX + 2] == 1){
                                eliminarFilas();
                                iniciar();
                            }else{
                                View subview = gridLayout.getChildAt(cordGrid + 10);
                                View subview2 = gridLayout.getChildAt(cordGrid + 1);
                                View subview3 = gridLayout.getChildAt(cordGrid + 2);

                                ImageView subviewImage = (ImageView) subview;
                                ImageView subviewImage2 = (ImageView) subview2;
                                ImageView subviewImage3 = (ImageView) subview3;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(R.drawable.bluesquare);  //L invertida
                                    subviewImage2.setImageResource(R.drawable.bluesquare);
                                        subviewImage3.setImageResource(R.drawable.bluesquare);

                                    matrizTablero[cordY + 1][cordX] = 1;
                                    matrizTablero[cordY][cordX + 1] = 1;
                                    matrizTablero[cordY][cordX + 2] = 1;

                                    subview = gridLayout.getChildAt(cordGrid - 10);
                                    subview2 = gridLayout.getChildAt(cordGrid - 9);
                                    subview3 = gridLayout.getChildAt(cordGrid - 8);

                                    subviewImage = (ImageView) subview;
                                    subviewImage2 = (ImageView) subview2;
                                    subviewImage3 = (ImageView) subview3;
                                    if(subview instanceof ImageView){
                                        subviewImage.setImageResource(0);
                                        subviewImage2.setImageResource(0);
                                        subviewImage3.setImageResource(0);
                                    }
                                    matrizTablero[cordY - 1][cordX] = 0;
                                    matrizTablero[cordY - 1][cordX + 1] = 0;
                                    matrizTablero[cordY - 1][cordX + 2] = 0;
                                }
                            }
                        }else{
                            eliminarFilas();
                            iniciar();
                        }
                    }else if(orientacion == 3){
                        if(cordY < 18){
                            if(matrizTablero[cordY][cordX - 1] == 1 || matrizTablero[cordY + 2][cordX] == 1){
                                eliminarFilas();
                                iniciar();
                            }else{
                                View subview = gridLayout.getChildAt(cordGrid - 1);
                                View subview2 = gridLayout.getChildAt(cordGrid + 20);

                                ImageView subviewImage = (ImageView) subview;
                                ImageView subviewImage2 = (ImageView) subview2;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(R.drawable.bluesquare);  //L invertida
                                    subviewImage2.setImageResource(R.drawable.bluesquare);

                                    matrizTablero[cordY][cordX - 1] = 1;
                                    matrizTablero[cordY + 2][cordX] = 1;

                                    subview = gridLayout.getChildAt(cordGrid - 10);
                                    subview2 = gridLayout.getChildAt(cordGrid - 11);

                                    subviewImage = (ImageView) subview;
                                    subviewImage2 = (ImageView) subview2;
                                    if(subview instanceof ImageView){
                                        subviewImage.setImageResource(0);
                                        subviewImage2.setImageResource(0);
                                    }
                                    matrizTablero[cordY - 1][cordX - 1] = 0;
                                    matrizTablero[cordY - 1][cordX] = 0;
                                }
                            }
                        }else{
                            eliminarFilas();
                            iniciar();
                        }

                    }else{
                        if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX - 1] == 1 || matrizTablero[cordY][cordX - 2] == 1){
                            eliminarFilas();
                            iniciar();
                        }else{
                            View subview = gridLayout.getChildAt(cordGrid);
                            View subview2 = gridLayout.getChildAt(cordGrid - 1);
                            View subview3 = gridLayout.getChildAt(cordGrid - 2);

                            ImageView subviewImage = (ImageView) subview;
                            ImageView subviewImage2 = (ImageView) subview2;
                            ImageView subviewImage3 = (ImageView) subview3;
                            if(subview instanceof ImageView){
                                subviewImage.setImageResource(R.drawable.bluesquare);  //L invertida
                                subviewImage2.setImageResource(R.drawable.bluesquare);
                                subviewImage3.setImageResource(R.drawable.bluesquare);

                                matrizTablero[cordY][cordX] = 1;
                                matrizTablero[cordY][cordX - 1] = 1;
                                matrizTablero[cordY][cordX - 2] = 1;

                                subview = gridLayout.getChildAt(cordGrid - 20);
                                subview2 = gridLayout.getChildAt(cordGrid - 11);
                                subview3 = gridLayout.getChildAt(cordGrid - 12);

                                subviewImage = (ImageView) subview;
                                subviewImage2 = (ImageView) subview2;
                                subviewImage3 = (ImageView) subview3;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(0);
                                    subviewImage2.setImageResource(0);
                                    subviewImage3.setImageResource(0);
                                }
                                matrizTablero[cordY - 2][cordX] = 0;
                                matrizTablero[cordY - 1][cordX - 1] = 0;
                                matrizTablero[cordY - 1][cordX - 2] = 0;
                            }
                        }

                    }
                }

            }
        }else if(figura == 3){
            if(cordY <= 0){
                cordGrid += 10;
                cordY += 1;
                View subview = gridLayout.getChildAt(cordGrid);
                View subview2 = gridLayout.getChildAt(cordGrid + 1);

                ImageView subviewImage = (ImageView) subview;
                ImageView subviewImage2 = (ImageView) subview2;
                if(subview instanceof ImageView){
                    if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1){
                        perder();
                    }else{
                        subviewImage.setImageResource(R.drawable.redsquare);  //Cuadro
                        subviewImage2.setImageResource(R.drawable.redsquare);

                        matrizTablero[cordY][cordX] = 1;
                        matrizTablero[cordY][cordX + 1] = 1;
                    }

                }
            }else{
                cordGrid += 10;
                cordY += 1;
                if(cordY > 19){
                    eliminarFilas();
                    iniciar();
                }else{
                    if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1){
                        eliminarFilas();
                        iniciar();
                    }else{
                        View subview = gridLayout.getChildAt(cordGrid);
                        View subview2 = gridLayout.getChildAt(cordGrid + 1);

                        ImageView subviewImage = (ImageView) subview;
                        ImageView subviewImage2 = (ImageView) subview2;
                        if(subview instanceof ImageView){
                            subviewImage.setImageResource(R.drawable.redsquare);  //Cuadro
                            subviewImage2.setImageResource(R.drawable.redsquare);

                            subview = gridLayout.getChildAt(cordGrid - 20);
                            subview2 = gridLayout.getChildAt(cordGrid - 19);

                            subviewImage = (ImageView) subview;
                            subviewImage2 = (ImageView) subview2;
                            if(subview instanceof ImageView){
                                subviewImage.setImageResource(0);
                                subviewImage2.setImageResource(0);
                            }
                            matrizTablero[cordY][cordX] = 1;
                            matrizTablero[cordY][cordX + 1] = 1;
                            matrizTablero[cordY - 2][cordX] = 0;
                            matrizTablero[cordY - 2][cordX + 1] = 0;
                        }
                    }
                }

            }
        }else if(figura == 4){
            if(cordY <= 0){
                cordGrid += 10;
                cordY += 1;
                View subview = gridLayout.getChildAt(cordGrid);
                View subview2 = gridLayout.getChildAt(cordGrid + 1);
                View subview3 = gridLayout.getChildAt(cordGrid - 8);

                ImageView subviewImage = (ImageView) subview;
                ImageView subviewImage2 = (ImageView) subview2;
                ImageView subviewImage3 = (ImageView) subview3;
                if(subview instanceof ImageView){
                    if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1 || matrizTablero[cordY - 1][cordX + 2] == 1){
                        perder();
                    }else{
                        subviewImage.setImageResource(R.drawable.lightbluesquare);  //Z invertida
                        subviewImage2.setImageResource(R.drawable.lightbluesquare);
                        subviewImage3.setImageResource(R.drawable.lightbluesquare);

                        subview2 = gridLayout.getChildAt(cordGrid - 10);

                        subviewImage2 = (ImageView) subview2;
                        if(subview2 instanceof ImageView){
                            subviewImage2.setImageResource(0);
                        }
                        matrizTablero[cordY][cordX] = 1;
                        matrizTablero[cordY][cordX + 1] = 1;
                        matrizTablero[cordY - 1][cordX + 2] = 1;
                        matrizTablero[cordY - 1][cordX] = 0;
                    }

                }
            }else{
                cordGrid += 10;
                cordY += 1;
                if(cordY > 19){
                    eliminarFilas();
                    iniciar();
                }else{
                    if(orientacion == 1 || orientacion == 3){
                        if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1 || matrizTablero[cordY - 1][cordX + 2] == 1){
                            eliminarFilas();
                            iniciar();
                        }else{
                            View subview = gridLayout.getChildAt(cordGrid);
                            View subview2 = gridLayout.getChildAt(cordGrid + 1);
                            View subview3 = gridLayout.getChildAt(cordGrid - 8);

                            ImageView subviewImage = (ImageView) subview;
                            ImageView subviewImage2 = (ImageView) subview2;
                            ImageView subviewImage3 = (ImageView) subview3;
                            if(subview instanceof ImageView){
                                subviewImage.setImageResource(R.drawable.lightbluesquare);  //Z invertida
                                subviewImage2.setImageResource(R.drawable.lightbluesquare);
                                subviewImage3.setImageResource(R.drawable.lightbluesquare);

                                subview = gridLayout.getChildAt(cordGrid - 19);
                                subview2 = gridLayout.getChildAt(cordGrid - 10);
                                subview3 = gridLayout.getChildAt(cordGrid - 18);

                                subviewImage = (ImageView) subview;
                                subviewImage2 = (ImageView) subview2;
                                subviewImage3 = (ImageView) subview3;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(0);
                                    subviewImage2.setImageResource(0);
                                    subviewImage3.setImageResource(0);
                                }
                                matrizTablero[cordY][cordX] = 1;
                                matrizTablero[cordY][cordX + 1] = 1;
                                matrizTablero[cordY - 1][cordX + 2] = 1;
                                matrizTablero[cordY - 1][cordX] = 0;
                                matrizTablero[cordY - 2][cordX + 1] = 0;
                                matrizTablero[cordY - 2][cordX + 2] = 0;
                            }
                        }
                    }else{
                        if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY - 1][cordX - 1] == 1){
                            eliminarFilas();
                            iniciar();
                        }else{
                            View subview = gridLayout.getChildAt(cordGrid);
                            View subview2 = gridLayout.getChildAt(cordGrid - 11);

                            ImageView subviewImage = (ImageView) subview;
                            ImageView subviewImage2 = (ImageView) subview2;
                            if(subview instanceof ImageView){
                                subviewImage.setImageResource(R.drawable.lightbluesquare);  //Z invertida
                                subviewImage2.setImageResource(R.drawable.lightbluesquare);

                                subview = gridLayout.getChildAt(cordGrid - 20);
                                subview2 = gridLayout.getChildAt(cordGrid - 31);

                                subviewImage = (ImageView) subview;
                                subviewImage2 = (ImageView) subview2;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(0);
                                    subviewImage2.setImageResource(0);
                                }
                                matrizTablero[cordY][cordX] = 1;
                                matrizTablero[cordY - 1][cordX - 1] = 1;
                                matrizTablero[cordY - 2][cordX] = 0;
                                matrizTablero[cordY - 3][cordX - 1] = 0;
                            }
                        }
                    }
                }

            }
        }else if(figura == 5){
            if(cordY <= 0){
                cordGrid += 10;
                cordY += 1;
                View subview = gridLayout.getChildAt(cordGrid);
                View subview2 = gridLayout.getChildAt(cordGrid + 1);
                View subview3 = gridLayout.getChildAt(cordGrid - 11);

                ImageView subviewImage = (ImageView) subview;
                ImageView subviewImage2 = (ImageView) subview2;
                ImageView subviewImage3 = (ImageView) subview3;
                if(subview instanceof ImageView){
                    if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1 || matrizTablero[cordY - 1][cordX - 1] == 1){
                        perder();
                    }else{
                        subviewImage.setImageResource(R.drawable.yellowsquare);  //Z
                        subviewImage2.setImageResource(R.drawable.yellowsquare);
                        subviewImage3.setImageResource(R.drawable.yellowsquare);

                        subview2 = gridLayout.getChildAt(cordGrid - 9);

                        subviewImage2 = (ImageView) subview2;
                        if(subview2 instanceof ImageView){
                            subviewImage2.setImageResource(0);
                        }
                        matrizTablero[cordY][cordX] = 1;
                        matrizTablero[cordY][cordX + 1] = 1;
                        matrizTablero[cordY - 1][cordX - 1] = 1;
                        matrizTablero[cordY - 1][cordX + 1] = 0;
                    }

                }
            }else{
                cordGrid += 10;
                cordY += 1;
                if(cordY > 19){
                    eliminarFilas();
                    iniciar();
                }else{
                    if(orientacion == 1 || orientacion == 3){
                        if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY][cordX + 1] == 1 || matrizTablero[cordY - 1][cordX - 1] == 1){
                            eliminarFilas();
                            iniciar();
                        }else{
                            View subview = gridLayout.getChildAt(cordGrid);
                            View subview2 = gridLayout.getChildAt(cordGrid + 1);
                            View subview3 = gridLayout.getChildAt(cordGrid - 11);

                            ImageView subviewImage = (ImageView) subview;
                            ImageView subviewImage2 = (ImageView) subview2;
                            ImageView subviewImage3 = (ImageView) subview3;
                            if(subview instanceof ImageView){
                                subviewImage.setImageResource(R.drawable.yellowsquare);  //Z
                                subviewImage2.setImageResource(R.drawable.yellowsquare);
                                subviewImage3.setImageResource(R.drawable.yellowsquare);

                                subview = gridLayout.getChildAt(cordGrid - 9);
                                subview2 = gridLayout.getChildAt(cordGrid - 20);
                                subview3 = gridLayout.getChildAt(cordGrid - 21);

                                subviewImage = (ImageView) subview;
                                subviewImage2 = (ImageView) subview2;
                                subviewImage3 = (ImageView) subview3;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(0);
                                    subviewImage2.setImageResource(0);
                                    subviewImage3.setImageResource(0);
                                }
                                matrizTablero[cordY][cordX] = 1;
                                matrizTablero[cordY][cordX + 1] = 1;
                                matrizTablero[cordY - 1][cordX - 1] = 1;
                                matrizTablero[cordY - 1][cordX + 1] = 0;
                                matrizTablero[cordY - 2][cordX - 1] = 0;
                                matrizTablero[cordY - 2][cordX] = 0;
                            }
                        }
                    }else{
                        if(cordY < 19){
                            if(matrizTablero[cordY][cordX + 1] == 1 || matrizTablero[cordY + 1][cordX] == 1){
                                eliminarFilas();
                                iniciar();
                            }else{
                                View subview = gridLayout.getChildAt(cordGrid + 10);
                                View subview2 = gridLayout.getChildAt(cordGrid + 1);

                                ImageView subviewImage = (ImageView) subview;
                                ImageView subviewImage2 = (ImageView) subview2;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(R.drawable.yellowsquare);  //Z invertida
                                    subviewImage2.setImageResource(R.drawable.yellowsquare);

                                    subview = gridLayout.getChildAt(cordGrid - 10);
                                    subview2 = gridLayout.getChildAt(cordGrid - 19);

                                    subviewImage = (ImageView) subview;
                                    subviewImage2 = (ImageView) subview2;
                                    if(subview instanceof ImageView){
                                        subviewImage.setImageResource(0);
                                        subviewImage2.setImageResource(0);
                                    }
                                    matrizTablero[cordY][cordX + 1] = 1;
                                    matrizTablero[cordY + 1][cordX] = 1;
                                    matrizTablero[cordY - 1][cordX] = 0;
                                    matrizTablero[cordY - 2][cordX + 1] = 0;
                                }
                            }
                        }
                    }
                }

            }
        }else if(figura == 6){
            if(cordY <= 0){
                cordGrid += 10;
                cordY += 1;
                View subview = gridLayout.getChildAt(cordGrid);
                View subview2 = gridLayout.getChildAt(cordGrid - 9);
                View subview3 = gridLayout.getChildAt(cordGrid - 11);

                ImageView subviewImage = (ImageView) subview;
                ImageView subviewImage2 = (ImageView) subview2;
                ImageView subviewImage3 = (ImageView) subview3;
                if(subview instanceof ImageView){
                    if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY - 1][cordX - 1] == 1 || matrizTablero[cordY - 1][cordX + 1] == 1){
                        perder();
                    }else{
                        subviewImage.setImageResource(R.drawable.purplesquare);  //T
                        subviewImage2.setImageResource(R.drawable.purplesquare);
                        subviewImage3.setImageResource(R.drawable.purplesquare);

                        matrizTablero[cordY][cordX] = 1;
                        matrizTablero[cordY - 1][cordX - 1] = 1;
                        matrizTablero[cordY - 1][cordX + 1] = 1;
                    }

                }
            }else{
                cordGrid += 10;
                cordY += 1;
                if(cordY > 19){
                    eliminarFilas();
                    iniciar();
                }else{
                    if(orientacion == 1){
                        if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY - 1][cordX + 1] == 1 || matrizTablero[cordY - 1][cordX - 1] == 1){
                            eliminarFilas();
                            iniciar();
                        }else{
                            View subview = gridLayout.getChildAt(cordGrid);
                            View subview2 = gridLayout.getChildAt(cordGrid - 9);
                            View subview3 = gridLayout.getChildAt(cordGrid - 11);

                            ImageView subviewImage = (ImageView) subview;
                            ImageView subviewImage2 = (ImageView) subview2;
                            ImageView subviewImage3 = (ImageView) subview3;
                            if(subview instanceof ImageView){
                                subviewImage.setImageResource(R.drawable.purplesquare);  //T
                                subviewImage2.setImageResource(R.drawable.purplesquare);
                                subviewImage3.setImageResource(R.drawable.purplesquare);

                                subview = gridLayout.getChildAt(cordGrid - 19);
                                subview2 = gridLayout.getChildAt(cordGrid - 20);
                                subview3 = gridLayout.getChildAt(cordGrid - 21);

                                subviewImage = (ImageView) subview;
                                subviewImage2 = (ImageView) subview2;
                                subviewImage3 = (ImageView) subview3;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(0);
                                    subviewImage2.setImageResource(0);
                                    subviewImage3.setImageResource(0);
                                }
                                matrizTablero[cordY][cordX] = 1;
                                matrizTablero[cordY - 1][cordX + 1] = 1;
                                matrizTablero[cordY - 1][cordX - 1] = 1;
                                matrizTablero[cordY - 2][cordX + 1] = 0;
                                matrizTablero[cordY - 2][cordX - 1] = 0;
                                matrizTablero[cordY - 2][cordX] = 0;
                            }
                        }
                    }else if(orientacion == 2){
                        if(cordY < 19){
                            if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY + 1][cordX + 1] == 1){
                                eliminarFilas();
                                iniciar();
                            }else{
                                View subview = gridLayout.getChildAt(cordGrid);
                                View subview2 = gridLayout.getChildAt(cordGrid + 11);

                                ImageView subviewImage = (ImageView) subview;
                                ImageView subviewImage2 = (ImageView) subview2;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(R.drawable.purplesquare);  //T
                                    subviewImage2.setImageResource(R.drawable.purplesquare);

                                    matrizTablero[cordY][cordX] = 1;
                                    matrizTablero[cordY + 1][cordX + 1] = 1;

                                    subview = gridLayout.getChildAt(cordGrid - 10);
                                    subview2 = gridLayout.getChildAt(cordGrid - 19);

                                    subviewImage = (ImageView) subview;
                                    subviewImage2 = (ImageView) subview2;
                                    if(subview instanceof ImageView){
                                        subviewImage.setImageResource(0);
                                        subviewImage2.setImageResource(0);
                                    }
                                    matrizTablero[cordY - 1][cordX] = 0;
                                    matrizTablero[cordY - 2][cordX + 1] = 0;
                                }
                            }
                        }else{
                            eliminarFilas();
                            iniciar();
                        }
                    }else if(orientacion == 3){
                        if(cordY < 19){
                            if(matrizTablero[cordY + 1][cordX] == 1 || matrizTablero[cordY + 1][cordX - 1] == 1  || matrizTablero[cordY + 1][cordX + 1] == 1){
                                eliminarFilas();
                                iniciar();
                            }else{
                                View subview = gridLayout.getChildAt(cordGrid + 10);
                                View subview2 = gridLayout.getChildAt(cordGrid + 11);
                                View subview3 = gridLayout.getChildAt(cordGrid + 9);

                                ImageView subviewImage = (ImageView) subview;
                                ImageView subviewImage2 = (ImageView) subview2;
                                ImageView subviewImage3 = (ImageView) subview3;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(R.drawable.purplesquare);  //T
                                    subviewImage2.setImageResource(R.drawable.purplesquare);
                                    subviewImage3.setImageResource(R.drawable.purplesquare);

                                    matrizTablero[cordY + 1][cordX] = 1;
                                    matrizTablero[cordY + 1][cordX + 1] = 1;
                                    matrizTablero[cordY + 1][cordX - 1] = 1;

                                    subview = gridLayout.getChildAt(cordGrid - 1);
                                    subview2 = gridLayout.getChildAt(cordGrid + 1);
                                    subview3 = gridLayout.getChildAt(cordGrid - 10);

                                    subviewImage = (ImageView) subview;
                                    subviewImage2 = (ImageView) subview2;
                                    subviewImage3 = (ImageView) subview3;
                                    if(subview instanceof ImageView){
                                        subviewImage.setImageResource(0);
                                        subviewImage2.setImageResource(0);
                                        subviewImage3.setImageResource(0);
                                    }
                                    matrizTablero[cordY][cordX - 1] = 0;
                                    matrizTablero[cordY][cordX + 1] = 0;
                                    matrizTablero[cordY - 1][cordX] = 0;
                                }
                            }
                        }else{
                            eliminarFilas();
                            iniciar();
                        }

                    }else{
                        if(cordY < 19){
                            if(matrizTablero[cordY][cordX] == 1 || matrizTablero[cordY + 1][cordX - 1] == 1){
                                eliminarFilas();
                                iniciar();
                            }else{
                                View subview = gridLayout.getChildAt(cordGrid);
                                View subview2 = gridLayout.getChildAt(cordGrid + 9);

                                ImageView subviewImage = (ImageView) subview;
                                ImageView subviewImage2 = (ImageView) subview2;
                                if(subview instanceof ImageView){
                                    subviewImage.setImageResource(R.drawable.purplesquare);  //T
                                    subviewImage2.setImageResource(R.drawable.purplesquare);

                                    matrizTablero[cordY][cordX] = 1;
                                    matrizTablero[cordY + 1][cordX - 1] = 1;

                                    subview = gridLayout.getChildAt(cordGrid - 10);
                                    subview2 = gridLayout.getChildAt(cordGrid - 21);

                                    subviewImage = (ImageView) subview;
                                    subviewImage2 = (ImageView) subview2;
                                    if(subview instanceof ImageView){
                                        subviewImage.setImageResource(0);
                                        subviewImage2.setImageResource(0);
                                    }
                                    matrizTablero[cordY - 1][cordX] = 0;
                                    matrizTablero[cordY - 2][cordX - 1] = 0;
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       // AsyncTask proceso = AsyncTask();


    }
}

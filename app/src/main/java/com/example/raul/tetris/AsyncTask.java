package com.example.raul.tetris;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

/**
 * Created by Raul on 3/5/2018.
 */

public class AsyncTask extends android.os.AsyncTask<Void, Void , String>{

private int figura, orientacion;
private Context context;
private GridLayout grid;

public AsyncTask(Context context, int pFigura, int pOrientacion, GridLayout pGrid) {
        this.figura = pFigura;
        this.orientacion = pOrientacion;
        this.context = context;
        this.grid = pGrid;
        }

@Override
protected void onPreExecute() {

        super.onPreExecute();
        }

@Override
protected String doInBackground(Void... params) {




return "";
}

@Override
protected void onPostExecute(String result) {

        super.onPostExecute(result);

        }
}
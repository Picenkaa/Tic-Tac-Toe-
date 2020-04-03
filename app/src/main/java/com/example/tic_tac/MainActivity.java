package com.example.tic_tac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;
import androidx.gridlayout.widget.GridLayout;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
  int[]gameState ={2,2,2,2,2,2,2,2,2};
  int[][] win ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer =0;
    String winner = "";
    boolean grajus =true;
public void dropin(View view){
    ImageView counter = (ImageView) view;
    int tappedCounter = Integer.parseInt(counter.getTag().toString());
    if(gameState[tappedCounter]==2 && grajus) {
        gameState[tappedCounter] = activePlayer;
        counter.getTag();
        counter.setTranslationY(-1500);
        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.x);
            activePlayer = 1;
        } else {
            counter.setImageResource(R.drawable.o);
            activePlayer = 0;
        }
        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
        for (int[] winas : win) {
            if (gameState[winas[0]] == gameState[winas[1]] && gameState[winas[1]] == gameState[winas[2]] && gameState[winas[0]] != 2) {
                //victory royale
                grajus = false;

                if (activePlayer == 1) {
                    winner = "X";
                } else {
                    winner = "O";
                }

               // Toast.makeText(this, winner + " laimejo!", Toast.LENGTH_LONG).show();
                Button darkarteli = (Button) findViewById(R.id.button2);
                TextView laimetojas = (TextView) findViewById(R.id.textView);
                laimetojas.setText(winner + " Laimejo! ");
                darkarteli.setVisibility(View.VISIBLE);
                laimetojas.setVisibility(View.VISIBLE);

            }


        }
    }
}
public void darkarta(View view){
    Button darkarteli = (Button) findViewById(R.id.button2);
    TextView laimetojas = (TextView) findViewById(R.id.textView);

    darkarteli.setVisibility(View.INVISIBLE);
    laimetojas.setVisibility(View.INVISIBLE);
    GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

    for(int i=0;i<gridLayout.getChildCount();i++){
        ImageView counter = (ImageView) gridLayout.getChildAt(i);
        counter.setImageDrawable(null);

    }
    for(int i=0;i<gameState.length;i++) {
        gameState[i]=2;
    }
     activePlayer =0;
     grajus =true;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

package com.firstapp.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    //player representation
    //0-x
    //1-o

    int activeplayer=0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    //state meaning
    //0-x
    //1-o
    //2-null
    int[][] winPositions= { {0,1,2},{3,4,5},{6,7,8},
                         {0,3,6},{1,4,7},{2,5,8},
                         {0,4,8},{2,4,6} };
    @SuppressLint("SetTextI18n")
    public void playerTap(View view){
        ImageView img= (ImageView) view;
        int tappedImage =Integer .parseInt(img.getTag(). toString());
        if (!gameActive){
            gameReset(view);
        }
            if(gamestate[tappedImage]==2) {
            gamestate[tappedImage] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.x);
                activeplayer = 1;
                TextView status=findViewById(R.id.status);
                status.setText("o's turn - tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                TextView status=findViewById(R.id.status);
                status.setText("x's turn - tap to play");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }
        //check if any player has won
        for (int[] winPosition: winPositions){
            if (gamestate[winPosition[0]] == gamestate[winPosition[1]] &&
                    gamestate[winPosition[1]] == gamestate[winPosition[2]] &&
                     gamestate[winPosition[0]]!=2) {
                //somebody has won
                String winnerStr;
                gameActive = false;
                if (gamestate[winPosition[0]] == 0) {
                    winnerStr = "x has won";
                }
                else {
                    winnerStr="o has won";
                }
                //update the status bar for winner announcement
                TextView status=findViewById(R.id.status);
                status.setText("winnerStr");
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void gameReset(View view){
        gameActive = true;
        activeplayer = 0;
        for (int i=0;i<gamestate.length;i++){
            gamestate[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView10)).setImageResource(0);

        TextView status=findViewById(R.id.status);
        status.setText("x's turn - tap to play");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
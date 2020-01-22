package com.markef.braincard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class level2 extends AppCompatActivity {

    ImageView curView = null;
    private int countPair = 0;
    final int[] drawable = new int[]{R.drawable.carta7,R.drawable.carta8,R.drawable.carta9,R.drawable.carta10,R.drawable.carta11,R.drawable.carta12};

    int[] pos = {0,1,2,3,4,5,0,1,2,3,4,5};
    int currentPos = -1;
    int moves = 30;

    TextView movView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        GridView gridView = findViewById(R.id.gridView);
        movView = findViewById(R.id.tVmoves);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);

        movView.setText(getString(R.string.moves_string1)+" "+moves);

        final MediaPlayer click = MediaPlayer.create(this, R.raw.click);
        final MediaPlayer gameover = MediaPlayer.create(this, R.raw.gameover);
        final MediaPlayer success = MediaPlayer.create(this, R.raw.success);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                moves--;
                movView.setText(getString(R.string.moves_string1)+" "+moves);
                click.start();
                if(currentPos <0){
                    currentPos = position;
                    curView = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }else{
                    if(currentPos == position){
                        ((ImageView)view).setImageResource(R.drawable.dorsal);
                    }else if(pos[currentPos]!=pos[position]){
                        curView.setImageResource(R.drawable.dorsal);
                        //Toast.makeText(getApplicationContext(),"Not match",Toast.LENGTH_SHORT).show();
                    }else{
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        countPair++;

                        if(countPair==6){
                            Toast.makeText(getApplicationContext(),getString(R.string.win2),Toast.LENGTH_LONG).show();
                            success.start();
                            startActivity(new Intent(level2.this, MainActivity.class));
                        }
                    }
                    currentPos = -1;
                }
                if(moves <= 0){
                    startActivity(new Intent(level2.this, MainActivity.class));
                    Toast.makeText(getApplicationContext(),getString(R.string.over2),Toast.LENGTH_LONG).show();
                    gameover.start();
                }
            }
        });
    }
}

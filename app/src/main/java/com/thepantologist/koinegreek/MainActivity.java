package com.thepantologist.koinegreek;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        TextView smallLetters = (TextView) findViewById(R.id.smallLetters);
        smallLetters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smallLettersIntent = new Intent(MainActivity.this, SmallLettersActivity.class);
                startActivity(smallLettersIntent);
            }
        });

        TextView capitalLetters = (TextView) findViewById(R.id.capitalLetters);
        capitalLetters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent capitalLettersIntent = new Intent(MainActivity.this, CapitalLettersActivity.class);
                startActivity(capitalLettersIntent);
            }
        });

        TextView diphthongs = (TextView) findViewById(R.id.diphthongs);
        diphthongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diphthongsIntent = new Intent(MainActivity.this, DiphthongsActivity.class);
                startActivity(diphthongsIntent);
            }
        });

        TextView vocab1 = (TextView) findViewById(R.id.vocab1);
        vocab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vocab1Intent = new Intent(MainActivity.this, Vocab1Activity.class);
                startActivity(vocab1Intent);
            }
        });

        TextView vocab2 = (TextView) findViewById(R.id.vocab2);
        vocab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vocab2Intent = new Intent(MainActivity.this, Vocab2Activity.class);
                startActivity(vocab2Intent);
            }
        });
    }
}

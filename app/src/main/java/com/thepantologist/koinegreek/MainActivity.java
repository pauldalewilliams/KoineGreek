package com.thepantologist.koinegreek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSmallLetters(View view) {
        Intent i = new Intent(this, SmallLettersActivity.class);
        startActivity(i);
    }

    public void openCapitalLetters(View view) {
        Intent i = new Intent(this, CapitalLettersActivity.class);
        startActivity(i);
    }

    public void openDiphthongs(View view) {
        Intent i = new Intent(this, DiphthongsActivity.class);
        startActivity(i);
    }

    public void openVocab1(View view) {
        Intent i = new Intent(this, Vocab1Activity.class);
        startActivity(i);
    }

    public void openVocab2(View view) {
        Intent i = new Intent(this, Vocab2Activity.class);
        startActivity(i);
    }
}

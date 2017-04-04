package com.thepantologist.koinegreek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DiphthongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letters_list);

        ArrayList<Letters> diphthongs = new ArrayList<>();
        diphthongs.add(new Letters("αι", "αι", "ai"));
        diphthongs.add(new Letters("ει", "ει", "ei"));
        diphthongs.add(new Letters("οι", "οι", "oi"));
        diphthongs.add(new Letters("αυ", "αυ", "au"));
        diphthongs.add(new Letters("ου", "ου", "ou"));
        diphthongs.add(new Letters("υι", "υι", "ui"));
        diphthongs.add(new Letters("ευ", "ευ", "eu"));
        diphthongs.add(new Letters("ηυ", "ηυ", "eu"));
        diphthongs.add(new Letters("γγ", "γγ", "ng"));
        diphthongs.add(new Letters("γκ", "γκ", "nk"));
        diphthongs.add(new Letters("γξ", "γξ", "nx"));
        diphthongs.add(new Letters("γχ", "γχ", "nch"));

        LettersAdapter itemsAdapter =
                new LettersAdapter(this, diphthongs, R.color.category_diphthongs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

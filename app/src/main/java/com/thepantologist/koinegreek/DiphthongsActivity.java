package com.thepantologist.koinegreek;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DiphthongsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letters_list);

        final ArrayList<Letters> diphthongs = new ArrayList<>();
        diphthongs.add(new Letters("αι", "αι", "ai", R.raw.ai));
        diphthongs.add(new Letters("ει", "ει", "ei", R.raw.ei));
        diphthongs.add(new Letters("οι", "οι", "oi", R.raw.oi));
        diphthongs.add(new Letters("αυ", "αυ", "au", R.raw.au));
        diphthongs.add(new Letters("ου", "ου", "ou", R.raw.ou));
        diphthongs.add(new Letters("υι", "υι", "ui", R.raw.ui));
        diphthongs.add(new Letters("ευ", "ευ", "eu", R.raw.eu));
        diphthongs.add(new Letters("ηυ", "ηυ", "eu", R.raw.eu));
        diphthongs.add(new Letters("γγ", "γγ", "ng", R.raw.g));
        diphthongs.add(new Letters("γκ", "γκ", "nk", R.raw.g));
        diphthongs.add(new Letters("γξ", "γξ", "nx", R.raw.g));
        diphthongs.add(new Letters("γχ", "γχ", "nch", R.raw.g));

        LettersAdapter itemsAdapter =
                new LettersAdapter(this, diphthongs, R.color.category_diphthongs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Letters letter = diphthongs.get(position);
                mMediaPlayer = MediaPlayer.create(DiphthongsActivity.this, letter.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}

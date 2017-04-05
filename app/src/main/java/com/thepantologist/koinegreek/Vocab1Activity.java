package com.thepantologist.koinegreek;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Vocab1Activity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        final ArrayList<Words> vocab1 = new ArrayList<>();
        vocab1.add(new Words("ἄγγελος", "aggelos", "angel, messenger", R.raw.aggelos));
        vocab1.add(new Words("ἀμήν", "amen", "verily, truly, amen, let it be so", R.raw.amen));
        vocab1.add(new Words("ἀπόστολος", "apostolos", "apostle, envoy, messenger, sent one", R.raw.apostolos));
        vocab1.add(new Words("θεός", "theos", "God, god", R.raw.theos));
        vocab1.add(new Words("Ἰησοῦς", "Iesous", "Jesus, Joshua", R.raw.iesous));
        vocab1.add(new Words("σωτήρ", "soter", "savior, deliverer", R.raw.soter));
        vocab1.add(new Words("υἱός", "huios", "son, descendant", R.raw.huios));
        vocab1.add(new Words("ὑπέρ", "huper", "in behalf of; above", R.raw.huper));
        vocab1.add(new Words("Χριστός", "Christos", "Christ, Messiah, Anointed One", R.raw.christos));

        WordsAdapter itemsAdapter =
                new WordsAdapter(this, vocab1, R.color.category_vocab1);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words word = vocab1.get(position);
                mMediaPlayer = MediaPlayer.create(Vocab1Activity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}

package com.thepantologist.koinegreek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Vocab1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Words> vocab1 = new ArrayList<>();
        vocab1.add(new Words("ἄγγελος", "angelos", "angel, messenger"));
        vocab1.add(new Words("ἀμήν", "amen", "verily, truly, amen, let it be so"));
        vocab1.add(new Words("ἀπόστολος", "apostolos", "apostle, envoy, messenger, sent one"));
        vocab1.add(new Words("θεός", "theos", "God, god"));
        vocab1.add(new Words("Ἰησοῦς", "Iesous", "Jesus, Joshua"));
        vocab1.add(new Words("σωτήρ", "soter", "savior, deliverer"));
        vocab1.add(new Words("υἱός", "huios", "son, descendant"));
        vocab1.add(new Words("ὑπέρ", "huper", "in behalf of; above"));
        vocab1.add(new Words("Χριστός", "Christos", "Christ, Messiah, Anointed One"));

        WordsAdapter itemsAdapter =
                new WordsAdapter(this, vocab1, R.color.category_vocab1);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

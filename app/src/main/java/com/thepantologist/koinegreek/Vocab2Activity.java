package com.thepantologist.koinegreek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import static com.thepantologist.koinegreek.R.id.vocab1;

public class Vocab2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Words> vocab2 = new ArrayList<>();
        vocab2.add(new Words("ἀδελφός", "adelphos", "brother"));
        vocab2.add(new Words("ἀνήρ, ἀνδρός", "aner, andros", "man, male, husband"));
        vocab2.add(new Words("ἄνθρωπος", "anthropos", "man, mankind, person, people, humankind, human being"));
        vocab2.add(new Words("γῆ", "ge", "earth, land, region, humanity"));
        vocab2.add(new Words("γυνή, γυναικός", "gyne, gynaikos", "woman, female, wife"));
        vocab2.add(new Words("ἡμέρα", "hemera", "day"));
        vocab2.add(new Words("κύριος", "kyrios", "Lord, lord, master, sir"));
        vocab2.add(new Words("λόγος", "logos", "word, Word, statement, message"));
        vocab2.add(new Words("μαθητής", "mathetes", "disciple"));
        vocab2.add(new Words("ὄνομα", "onoma", "name, reputation"));
        vocab2.add(new Words("οὐρανός", "ouranos", "heavens, heaven, sky"));
        vocab2.add(new Words("πατήρ, πατρός", "pater, patros", "father"));
        vocab2.add(new Words("πίστις", "pistis", "faith, belief"));
        vocab2.add(new Words("πνεῦμα", "pneuma", "spirit, Spirit, wind, breath, inner life"));

        WordsAdapter itemsAdapter =
                new WordsAdapter(this, vocab2, R.color.category_vocab2);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

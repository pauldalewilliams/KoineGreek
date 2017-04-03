package com.thepantologist.koinegreek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CapitalLettersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letters_list);

        ArrayList<Letters> capLetters = new ArrayList<>();
        capLetters.add(new Letters("ἌΛΦΑ", "ALPHA"));
        capLetters.add(new Letters("ΒΉΤΑ", "BETA"));
        capLetters.add(new Letters("ΓΆΜΜΑ", "GAMMA"));
        capLetters.add(new Letters("ΔΈΛΤΑ", "DELTA"));
        capLetters.add(new Letters("ἚΨΙΛΌΝ", "EPSILON"));
        capLetters.add(new Letters("ΖΉΤΑ", "ZETA"));
        capLetters.add(new Letters("ἮΤΑ", "ETA"));
        capLetters.add(new Letters("ΘΉΤΑ", "THETA"));
        capLetters.add(new Letters("ἸΌΤΑ", "IOTA"));
        capLetters.add(new Letters("ΚΆΠΠΑ", "KAPPA"));
        capLetters.add(new Letters("ΛΆΜΒΔΑ", "LAMBDA"));
        capLetters.add(new Letters("ΜΎ", "MU"));
        capLetters.add(new Letters("ΝΎ", "NU"));
        capLetters.add(new Letters("ΞΊ", "XI"));
        capLetters.add(new Letters("ὊΜΙΚΡΌΝ", "OMICRON"));
        capLetters.add(new Letters("ΠΊ", "PI"));
        capLetters.add(new Letters("ΡΏ", "RHO"));
        capLetters.add(new Letters("ΣΊΓΜΑ", "SIGMA"));
        capLetters.add(new Letters("ΤΑΎ", "TAU"));
        capLetters.add(new Letters("ΎΨΙΛΌΝ", "UPSILON"));
        capLetters.add(new Letters("ΦΙ", "PHI"));
        capLetters.add(new Letters("ΧΙ", "CHI"));
        capLetters.add(new Letters("ΨΙ", "PSI"));
        capLetters.add(new Letters("ὮΜΈΓΑ", "OMEGA"));

        LettersAdapter itemsAdapter =
                new LettersAdapter(this, capLetters);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

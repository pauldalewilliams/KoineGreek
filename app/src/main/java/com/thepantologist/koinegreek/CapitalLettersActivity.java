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
        capLetters.add(new Letters("Α", "ἌΛΦΑ", "ALPHA"));
        capLetters.add(new Letters("Β", "ΒΉΤΑ", "BETA"));
        capLetters.add(new Letters("Γ", "ΓΆΜΜΑ", "GAMMA"));
        capLetters.add(new Letters("Δ", "ΔΈΛΤΑ", "DELTA"));
        capLetters.add(new Letters("Ε", "ἚΨΙΛΌΝ", "EPSILON"));
        capLetters.add(new Letters("Ζ", "ΖΉΤΑ", "ZETA"));
        capLetters.add(new Letters("Η", "ἮΤΑ", "ETA"));
        capLetters.add(new Letters("Θ", "ΘΉΤΑ", "THETA"));
        capLetters.add(new Letters("Ι", "ἸΌΤΑ", "IOTA"));
        capLetters.add(new Letters("Κ", "ΚΆΠΠΑ", "KAPPA"));
        capLetters.add(new Letters("Λ", "ΛΆΜΒΔΑ", "LAMBDA"));
        capLetters.add(new Letters("Μ", "ΜΎ", "MU"));
        capLetters.add(new Letters("Ν", "ΝΎ", "NU"));
        capLetters.add(new Letters("Ξ", "ΞΊ", "XI"));
        capLetters.add(new Letters("Ο", "ὊΜΙΚΡΌΝ", "OMICRON"));
        capLetters.add(new Letters("Π", "ΠΊ", "PI"));
        capLetters.add(new Letters("Ρ", "ΡΏ", "RHO"));
        capLetters.add(new Letters("Σ", "ΣΊΓΜΑ", "SIGMA"));
        capLetters.add(new Letters("Τ", "ΤΑΎ", "TAU"));
        capLetters.add(new Letters("Υ", "ΎΨΙΛΌΝ", "UPSILON"));
        capLetters.add(new Letters("Φ", "ΦΙ", "PHI"));
        capLetters.add(new Letters("Χ", "ΧΙ", "CHI"));
        capLetters.add(new Letters("Ψ", "ΨΙ", "PSI"));
        capLetters.add(new Letters("Ω", "ὮΜΈΓΑ", "OMEGA"));

        LettersAdapter itemsAdapter =
                new LettersAdapter(this, capLetters, R.color.category_capitalLetters);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

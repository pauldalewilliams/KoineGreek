package com.thepantologist.koinegreek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SmallLettersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_letters);

        ArrayList<Letters> smLetters = new ArrayList<>();
        smLetters.add(new Letters("ἄλφα", "alpha"));
        smLetters.add(new Letters("βῆτα", "beta"));
        smLetters.add(new Letters("γάμμα", "gamma"));
        smLetters.add(new Letters("δέλτα", "delta"));
        smLetters.add(new Letters("ἒψιλόν", "epsilon"));
        smLetters.add(new Letters("ζήτα", "zeta"));
        smLetters.add(new Letters("ἦτα", "eta"));
        smLetters.add(new Letters("θῆτα", "theta"));
        smLetters.add(new Letters("ἰότα", "iota"));
        smLetters.add(new Letters("κάππα", "kappa"));
        smLetters.add(new Letters("λάμβδα", "lambda"));
        smLetters.add(new Letters("μῦ", "mu"));
        smLetters.add(new Letters("νῦ", "nu"));
        smLetters.add(new Letters("ξῖ", "xi"));
        smLetters.add(new Letters("ὂμικρόν", "omicron"));
        smLetters.add(new Letters("πῖ", "pi"));
        smLetters.add(new Letters("ῥῶ", "rho"));
        smLetters.add(new Letters("σίγμα", "sigma"));
        smLetters.add(new Letters("ταῦ", "tau"));
        smLetters.add(new Letters("ὖψιλόν", "upsilon"));
        smLetters.add(new Letters("φῖ", "phi"));
        smLetters.add(new Letters("χῖ", "chi"));
        smLetters.add(new Letters("ψῖ", "psi"));
        smLetters.add(new Letters("ὦμέγα", "omega"));

        LettersAdapter itemsAdapter =
                new LettersAdapter(this, smLetters);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

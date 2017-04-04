package com.thepantologist.koinegreek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SmallLettersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letters_list);

        ArrayList<Letters> smLetters = new ArrayList<>();
        smLetters.add(new Letters("α", "ἄλφα", "alpha"));
        smLetters.add(new Letters("β", "βῆτα", "beta"));
        smLetters.add(new Letters("γ", "γάμμα", "gamma"));
        smLetters.add(new Letters("δ", "δέλτα", "delta"));
        smLetters.add(new Letters("ε", "ἒψιλόν", "epsilon"));
        smLetters.add(new Letters("ζ", "ζήτα", "zeta"));
        smLetters.add(new Letters("η", "ἦτα", "eta"));
        smLetters.add(new Letters("θ", "θῆτα", "theta"));
        smLetters.add(new Letters("ι", "ἰότα", "iota"));
        smLetters.add(new Letters("κ", "κάππα", "kappa"));
        smLetters.add(new Letters("λ", "λάμβδα", "lambda"));
        smLetters.add(new Letters("μ", "μῦ", "mu"));
        smLetters.add(new Letters("ν", "νῦ", "nu"));
        smLetters.add(new Letters("ξ", "ξῖ", "xi"));
        smLetters.add(new Letters("ο", "ὂμικρόν", "omicron"));
        smLetters.add(new Letters("π", "πῖ", "pi"));
        smLetters.add(new Letters("ρ", "ῥῶ", "rho"));
        smLetters.add(new Letters("σ ς", "σίγμα", "sigma"));
        smLetters.add(new Letters("τ", "ταῦ", "tau"));
        smLetters.add(new Letters("υ", "ὖψιλόν", "upsilon"));
        smLetters.add(new Letters("φ", "φῖ", "phi"));
        smLetters.add(new Letters("χ", "χῖ", "chi"));
        smLetters.add(new Letters("ψ", "ψῖ", "psi"));
        smLetters.add(new Letters("ω", "ὦμέγα", "omega"));

        LettersAdapter itemsAdapter =
                new LettersAdapter(this, smLetters, R.color.category_smallLetters);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

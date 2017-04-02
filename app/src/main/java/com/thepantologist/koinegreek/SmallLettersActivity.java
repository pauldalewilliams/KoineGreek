package com.thepantologist.koinegreek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SmallLettersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_letters);

        ArrayList<Word> smletters = new ArrayList<>();

        ArrayList<String> letters = new ArrayList<>();
        letters.add(getString(R.string.smletter_alpha));
        letters.add(getString(R.string.smletter_beta));
        letters.add(getString(R.string.smletter_gamma));
        letters.add(getString(R.string.smletter_delta));
        letters.add(getString(R.string.smletter_epsilon));
        letters.add(getString(R.string.smletter_zeta));
        letters.add(getString(R.string.smletter_eta));
        letters.add(getString(R.string.smletter_theta));
        letters.add(getString(R.string.smletter_iota));
        letters.add(getString(R.string.smletter_kappa));
        letters.add(getString(R.string.smletter_lambda));
        letters.add(getString(R.string.smletter_mu));
        letters.add(getString(R.string.smletter_nu));
        letters.add(getString(R.string.smletter_xi));
        letters.add(getString(R.string.smletter_omicron));
        letters.add(getString(R.string.smletter_pi));
        letters.add(getString(R.string.smletter_rho));
        letters.add(getString(R.string.smletter_sigma));
        letters.add(getString(R.string.smletter_tau));
        letters.add(getString(R.string.smletter_upsilon));
        letters.add(getString(R.string.smletter_phi));
        letters.add(getString(R.string.smletter_chi));
        letters.add(getString(R.string.smletter_psi));
        letters.add(getString(R.string.smletter_omega));

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, letters);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

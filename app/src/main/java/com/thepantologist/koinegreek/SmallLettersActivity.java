package com.thepantologist.koinegreek;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.media.MediaPlayer;

import java.util.ArrayList;

public class SmallLettersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){

        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letters_list);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        final ArrayList<Letters> smLetters = new ArrayList<>();
        smLetters.add(new Letters("α", "ἄλφα", "alpha", R.raw.a));
        smLetters.add(new Letters("β", "βῆτα", "beta", R.raw.b));
        smLetters.add(new Letters("γ", "γάμμα", "gamma", R.raw.g));
        smLetters.add(new Letters("δ", "δέλτα", "delta", R.raw.d));
        smLetters.add(new Letters("ε", "ἒψιλόν", "epsilon", R.raw.e));
        smLetters.add(new Letters("ζ", "ζήτα", "zeta", R.raw.z));
        smLetters.add(new Letters("η", "ἦτα", "eta", R.raw.h));
        smLetters.add(new Letters("θ", "θῆτα", "theta", R.raw.th));
        smLetters.add(new Letters("ι", "ἰότα", "iota", R.raw.i));
        smLetters.add(new Letters("κ", "κάππα", "kappa", R.raw.k));
        smLetters.add(new Letters("λ", "λάμβδα", "lambda", R.raw.l));
        smLetters.add(new Letters("μ", "μῦ", "mu", R.raw.m));
        smLetters.add(new Letters("ν", "νῦ", "nu", R.raw.n));
        smLetters.add(new Letters("ξ", "ξῖ", "xi", R.raw.x));
        smLetters.add(new Letters("ο", "ὂμικρόν", "omicron", R.raw.o));
        smLetters.add(new Letters("π", "πῖ", "pi", R.raw.p));
        smLetters.add(new Letters("ρ", "ῥῶ", "rho", R.raw.r));
        smLetters.add(new Letters("σ ς", "σίγμα", "sigma", R.raw.s));
        smLetters.add(new Letters("τ", "ταῦ", "tau", R.raw.t));
        smLetters.add(new Letters("υ", "ὖψιλόν", "upsilon", R.raw.u));
        smLetters.add(new Letters("φ", "φῖ", "phi", R.raw.ph));
        smLetters.add(new Letters("χ", "χῖ", "chi", R.raw.ch));
        smLetters.add(new Letters("ψ", "ψῖ", "psi", R.raw.ps));
        smLetters.add(new Letters("ω", "ὦμέγα", "omega", R.raw.w));

        LettersAdapter itemsAdapter =
                new LettersAdapter(this, smLetters, R.color.category_smallLetters);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Letters letter = smLetters.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(SmallLettersActivity.this, letter.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null.
            mMediaPlayer = null;
        }
    }
}

package com.thepantologist.koinegreek;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CapitalLettersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){

        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letters_list);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Letters> capLetters = new ArrayList<>();
        capLetters.add(new Letters("Α", "ἌΛΦΑ", "ALPHA", R.raw.a));
        capLetters.add(new Letters("Β", "ΒΉΤΑ", "BETA", R.raw.b));
        capLetters.add(new Letters("Γ", "ΓΆΜΜΑ", "GAMMA", R.raw.g));
        capLetters.add(new Letters("Δ", "ΔΈΛΤΑ", "DELTA", R.raw.d));
        capLetters.add(new Letters("Ε", "ἚΨΙΛΌΝ", "EPSILON", R.raw.e));
        capLetters.add(new Letters("Ζ", "ΖΉΤΑ", "ZETA", R.raw.z));
        capLetters.add(new Letters("Η", "ἮΤΑ", "ETA", R.raw.h));
        capLetters.add(new Letters("Θ", "ΘΉΤΑ", "THETA", R.raw.th));
        capLetters.add(new Letters("Ι", "ἸΌΤΑ", "IOTA", R.raw.i));
        capLetters.add(new Letters("Κ", "ΚΆΠΠΑ", "KAPPA", R.raw.k));
        capLetters.add(new Letters("Λ", "ΛΆΜΒΔΑ", "LAMBDA", R.raw.l));
        capLetters.add(new Letters("Μ", "ΜΎ", "MU", R.raw.m));
        capLetters.add(new Letters("Ν", "ΝΎ", "NU", R.raw.n));
        capLetters.add(new Letters("Ξ", "ΞΊ", "XI", R.raw.x));
        capLetters.add(new Letters("Ο", "ὊΜΙΚΡΌΝ", "OMICRON", R.raw.o));
        capLetters.add(new Letters("Π", "ΠΊ", "PI", R.raw.p));
        capLetters.add(new Letters("Ρ", "ΡΏ", "RHO", R.raw.r));
        capLetters.add(new Letters("Σ", "ΣΊΓΜΑ", "SIGMA", R.raw.s));
        capLetters.add(new Letters("Τ", "ΤΑΎ", "TAU", R.raw.t));
        capLetters.add(new Letters("Υ", "ΎΨΙΛΌΝ", "UPSILON", R.raw.u));
        capLetters.add(new Letters("Φ", "ΦΙ", "PHI", R.raw.ph));
        capLetters.add(new Letters("Χ", "ΧΙ", "CHI", R.raw.ch));
        capLetters.add(new Letters("Ψ", "ΨΙ", "PSI", R.raw.ps));
        capLetters.add(new Letters("Ω", "ὮΜΈΓΑ", "OMEGA", R.raw.w));

        LettersAdapter itemsAdapter =
                new LettersAdapter(this, capLetters, R.color.category_capitalLetters);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Letters letter = capLetters.get(position);
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(CapitalLettersActivity.this, letter.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
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

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}

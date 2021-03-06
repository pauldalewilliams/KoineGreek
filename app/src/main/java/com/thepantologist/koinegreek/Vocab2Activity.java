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

import static com.thepantologist.koinegreek.R.id.vocab1;

public class Vocab2Activity extends AppCompatActivity {

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
        setContentView(R.layout.words_list);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Words> vocab2 = new ArrayList<>();
        vocab2.add(new Words("ἀδελφός", "adelphos", "brother", R.raw.adelphos));
        vocab2.add(new Words("ἀνήρ, ἀνδρός", "aner, andros", "man, male, husband", R.raw.anerandros));
        vocab2.add(new Words("ἄνθρωπος", "anthropos", "man, mankind, person, people, humankind, human being", R.raw.anthropos));
        vocab2.add(new Words("γῆ", "ge", "earth, land, region, humanity", R.raw.ge));
        vocab2.add(new Words("γυνή, γυναικός", "gyne, gynaikos", "woman, female, wife", R.raw.gyne));
        vocab2.add(new Words("ἡμέρα", "hemera", "day", R.raw.hemera));
        vocab2.add(new Words("κύριος", "kyrios", "Lord, lord, master, sir", R.raw.kyrios));
        vocab2.add(new Words("λόγος", "logos", "word, Word, statement, message", R.raw.logos));
        vocab2.add(new Words("μαθητής", "mathetes", "disciple", R.raw.mathetes));
        vocab2.add(new Words("ὄνομα", "onoma", "name, reputation", R.raw.onoma));
        vocab2.add(new Words("οὐρανός", "ouranos", "heavens, heaven, sky", R.raw.ouranos));
        vocab2.add(new Words("πατήρ, πατρός", "pater, patros", "father", R.raw.pater));
        vocab2.add(new Words("πίστις", "pistis", "faith, belief", R.raw.pistis));
        vocab2.add(new Words("πνεῦμα", "pneuma", "spirit, Spirit, wind, breath, inner life", R.raw.pneuma));

        WordsAdapter itemsAdapter =
                new WordsAdapter(this, vocab2, R.color.category_vocab2);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words word = vocab2.get(position);
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(Vocab2Activity.this, word.getAudioResourceId());
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

package com.thepantologist.koinegreek;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class WordsAdapter extends ArrayAdapter<Words> {

    private int mColorResourceId;

    public WordsAdapter(@NonNull Context context, @NonNull ArrayList<Words> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.word_list_item, parent, false);
        }

        Words currentWord = getItem(position);

        TextView greekTextView = (TextView) listItemView.findViewById(R.id.greek_text_view);
        greekTextView.setText(currentWord.getGreekOriginal());

        TextView transliterationTextView = (TextView) listItemView.findViewById(R.id.transliteration_text_view);
        transliterationTextView.setText(currentWord.getGreekTransliteration());

        TextView translationTextView = (TextView) listItemView.findViewById(R.id.translation_text_view);
        translationTextView.setText(currentWord.getDefaultTranslation());

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}

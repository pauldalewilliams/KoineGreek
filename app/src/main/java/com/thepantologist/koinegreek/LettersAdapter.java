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

public class LettersAdapter extends ArrayAdapter<Letters> {

    private int mColorResourceId;

    public LettersAdapter(@NonNull Context context, @NonNull ArrayList<Letters> letters, int colorResourceId) {
        super(context, 0, letters);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.letter_list_item, parent, false);
        }

        Letters currentLetters = getItem(position);

        TextView letterTextView = (TextView) listItemView.findViewById(R.id.letter_text_view);
        letterTextView.setText(currentLetters.getGreekLetter());

        TextView greekTextView = (TextView) listItemView.findViewById(R.id.greek_text_view);
        greekTextView.setText(currentLetters.getGreekOriginal());

        TextView transliterationTextView = (TextView) listItemView.findViewById(R.id.transliteration_text_view);
        transliterationTextView.setText(currentLetters.getGreekTransliteration());

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}

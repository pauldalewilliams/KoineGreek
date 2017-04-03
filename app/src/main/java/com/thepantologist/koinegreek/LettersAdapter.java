package com.thepantologist.koinegreek;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LettersAdapter extends ArrayAdapter<Letters> {
    public LettersAdapter(@NonNull Context context, @NonNull ArrayList<Letters> letters) {
        super(context, 0, letters);
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

        TextView greekTextView = (TextView) listItemView.findViewById(R.id.greek_text_view);
        greekTextView.setText(currentLetters.getGreekOriginal());

        TextView transliterationTextView = (TextView) listItemView.findViewById(R.id.transliteration_text_view);
        transliterationTextView.setText(currentLetters.getGreekTransliteration());

        return listItemView;
    }
}

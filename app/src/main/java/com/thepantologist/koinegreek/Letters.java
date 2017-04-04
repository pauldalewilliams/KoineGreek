package com.thepantologist.koinegreek;

/**
 * {@link Letters} represents a letter or word to learn.
 * It contains the Greek and default translation for the letters.
 */
class Letters {
    private String mGreekLetter;
    private String mGreekOriginal;
    private String mGreekTransliteration;


    public Letters(String greekLetter, String greekOriginal, String greekTransliteration) {
        mGreekLetter = greekLetter;
        mGreekOriginal = greekOriginal;
        mGreekTransliteration = greekTransliteration;
    }

    public String getGreekLetter() {
        return mGreekLetter;
    }

    public String getGreekOriginal() {

        return mGreekOriginal;
    }

    public String getGreekTransliteration() {
        return mGreekTransliteration;
    }
}

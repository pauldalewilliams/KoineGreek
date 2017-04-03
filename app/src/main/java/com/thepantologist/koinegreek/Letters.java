package com.thepantologist.koinegreek;

/**
 * {@link Letters} represents a letter or word to learn.
 * It contains the Greek and default translation for the word.
 */
class Letters {
    private String mGreekOriginal;
    private String mGreekTransliteration;

    public Letters(String greekOriginal, String greekTransliteration) {
        mGreekOriginal = greekOriginal;
        mGreekTransliteration = greekTransliteration;
    }

    public String getGreekTransliteration() {
        return mGreekTransliteration;
    }

    public String getGreekOriginal() {
        return mGreekOriginal;
    }
}

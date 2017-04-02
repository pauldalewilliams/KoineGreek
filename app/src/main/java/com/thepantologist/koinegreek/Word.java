package com.thepantologist.koinegreek;

/**
 * {@link Word} represents a letter or word to learn.
 * It contains the Greek and default translation for the word.
 */
class Word {
    private String mGreekOriginal;
    private String mGreekTransliteration;
    private String mDefaultTranslation;

    public Word(String greekOriginal, String greekTransliteration) {
        mGreekOriginal = greekOriginal;
        mGreekTransliteration = greekTransliteration;
    }

    public Word(String defaultTranslation, String greekOriginal, String greekTransliteration) {
        mDefaultTranslation = defaultTranslation;
        mGreekOriginal = greekOriginal;
        mGreekTransliteration = greekTransliteration;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getGreekTranslation() {
        return mGreekTransliteration;
    }

    public String getGreekOriginal() {
        return mGreekOriginal;
    }
}

package com.thepantologist.koinegreek;

/**
 * {@link Words} represents a word to learn.
 * It contains the Greek and default translation for the letters.
 */
class Words {
    private String mGreekOriginal;
    private String mGreekTransliteration;
    private String mDefaultTranslation;
    private int mAudioResourceId;


    public Words(String greekOriginal, String greekTransliteration, String defaultTranslation, int audioResourceId) {
        mGreekOriginal = greekOriginal;
        mGreekTransliteration = greekTransliteration;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }

    public String getGreekOriginal() { return mGreekOriginal; }

    public String getGreekTransliteration() {
        return mGreekTransliteration;
    }

    public String getDefaultTranslation() { return mDefaultTranslation; }

    public int getAudioResourceId() { return mAudioResourceId; }

}

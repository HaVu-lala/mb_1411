package com.example.mb_1411;

public class SongModel {
    private String mCode;
    private String title;
    private String lyric;
    private String mArtist;

    public SongModel(String mCode, String title, String lyric, String mArtist) {
        this.mCode = mCode;
        this.title = title;
        this.lyric = lyric;
        this.mArtist = mArtist;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getmArtist() {
        return mArtist;
    }

    public void setmArtist(String mArtist) {
        this.mArtist = mArtist;
    }
}

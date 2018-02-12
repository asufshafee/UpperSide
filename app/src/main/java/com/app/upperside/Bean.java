package com.app.upperside;

/**
 * Created by apple on 01/04/16.
 */
public class Bean {


    private int newsimage2;
    private String time;
    private String news;
    private String newssub;


    public Bean(int newsimage2,String time, String news, String newssub) {

        this.newsimage2 = newsimage2;
        this.time = time;
        this.news = news;
        this.newssub = newssub;


    }


    public int getNewsimage2() {
        return newsimage2;
    }

    public void setNewsimage2(int newsimage2) {
        this.newsimage2 = newsimage2;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getNewssub() {
        return newssub;
    }

    public void setNewssub(String newssub) {
        this.newssub = newssub;
    }

}
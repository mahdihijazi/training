package com.training.newsapp1;

/**
 * Created by mahdi on 5/1/15.
 */
public class Article {
    public long id;
    public String content;
    public String title;
    public int imageResId;

    public Article(long id, String title, String content, int imageResId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageResId = imageResId;

    }

}

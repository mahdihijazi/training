package com.training.newsapp2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mahdi on 5/1/15.
 */
public class Article implements Parcelable {
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


    protected Article(Parcel in) {
        id = in.readLong();
        content = in.readString();
        title = in.readString();
        imageResId = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(content);
        dest.writeString(title);
        dest.writeInt(imageResId);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}

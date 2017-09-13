package com.example.jorgecafernandez.books;

import android.databinding.BindingAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by jorge.c.a.fernandez on 9/11/2017.
 */

public class Book implements Parcelable {
    public String id;
    public String title;
    public String subTitle;
    public String authors;
    public String publisher;
    public String PublishedDate;
    public String description;
    public String thumbnail;

    public Book(String id, String title, String subTitle, String[] authors,
                String publisher, String publishedDate, String description, String thumbnail) {

        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.authors = TextUtils.join(", ", authors);
        this.publisher = publisher;
        this.PublishedDate = publishedDate;
        this.description = description;
        this.thumbnail = thumbnail;

    }
    /** Constructor */
    protected Book(Parcel in) {
        id = in.readString();
        title = in.readString();
        subTitle = in.readString();
        authors = in.readString();
        publisher = in.readString();
        PublishedDate = in.readString();
        description = in.readString();
        thumbnail = in.readString();
    }
    /** Creator Contain two method : createFromParcel, newArray*/
    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    /** describeContents Method*/
    @Override
    public int describeContents() {
        return 0;
    }

    /** writeToParcel Method*/
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(subTitle);
        dest.writeString(authors);
        dest.writeString(publisher);
        dest.writeString(PublishedDate);
        dest.writeString(description);
        dest.writeString(thumbnail);

    }

    /** Method loadImage from Book Class */
    @BindingAdapter({"android:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl){
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.book_open)
                .into(view);
    }
}

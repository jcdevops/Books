package com.example.jorgecafernandez.books;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jorgecafernandez.books.databinding.ActivityBookDetailBinding;

public class BookDetail extends AppCompatActivity {

    /** onCreate Method for BookDetail Class */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        /** Catching up the intent from BooksAdapter */
        Book book = getIntent().getParcelableExtra("Book");
        ActivityBookDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_book_detail);
        binding.setBook(book);

    }
}

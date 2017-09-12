package com.example.jorgecafernandez.books;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by jorge.c.a.fernandez on 9/12/2017.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder>{

    /** Constructor for BookAdapter class */
    ArrayList<Book> books;
    public BooksAdapter(ArrayList<Book> books){
        this.books = books;
    }

    /** Method BookViewHolder */
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.book_list_item, parent, false);
        return new BookViewHolder(itemView);
    }

    /** Method onBindViewHolder */
    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = books.get(position);
        holder.bind(book);
    }

    /** Method getItemCount */
    @Override
    public int getItemCount() {
        return books.size();
    }

    /** BookViewHolder Class */
    public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvTitle;
        TextView tvAuthors;
        TextView tvDate;
        TextView tvPublisher;

        /** Constructor for BookViewHolder Class */
        public BookViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthors = (TextView) itemView.findViewById(R.id.tvAuthors);
            tvDate = (TextView) itemView.findViewById(R.id.tvPublishedDate);
            tvPublisher = (TextView) itemView.findViewById(R.id.tvPublisher);
            itemView.setOnClickListener(this);
        }

        /** Method bind */
        public void bind (Book book){
            tvTitle.setText(book.title);
            tvAuthors.setText(book.authors);
            tvDate.setText(book.PublishedDate);
            tvPublisher.setText(book.publisher);
        }
        /** onClick Method implement by BookViewHolder Class */
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Book selectBook = books.get(position);
            Intent intent = new Intent(itemView.getContext(),BookDetail.class);
            intent.putExtra("Book", selectBook);
            itemView.getContext().startActivity(intent);
        }
    }
}

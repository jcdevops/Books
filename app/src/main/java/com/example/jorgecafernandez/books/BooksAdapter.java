package com.example.jorgecafernandez.books;

import android.content.Context;
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

    /** Constructor BookAdapter */
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
    public class BookViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvAuthors;
        TextView tvDate;
        TextView tvPublisher;

        /** Constructor */
        public BookViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthors = (TextView) itemView.findViewById(R.id.tvAuthors);
            tvDate = (TextView) itemView.findViewById(R.id.tvPublishedDate);
            tvPublisher = (TextView) itemView.findViewById(R.id.tvPublisher);
        }

        /** Method 'bind' */
        public void bind (Book book){
            tvTitle.setText(book.title);
            String authors="";
            int i=0;
                for(String author:book.authors){
                    author+=author;
                    i++;
                    if(i<book.authors.length){
                        authors+=", ";
                    }
                }
                tvAuthors.setText(authors);
                tvDate.setText(book.PublishedDate);
                tvPublisher.setText(book.publisher);
        }
    }
}

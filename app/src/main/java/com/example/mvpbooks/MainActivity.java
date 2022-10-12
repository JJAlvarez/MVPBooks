package com.example.mvpbooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvpbooks.adapter.BooksAdapter;
import com.example.mvpbooks.bean.Book;
import com.example.mvpbooks.presenter.BookPresenter;
import com.example.mvpbooks.presenter.IBookPresenter;
import com.example.mvpbooks.view.IBookView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IBookView {

    private IBookPresenter bookPresenter;
    private BooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.bookPresenter = new BookPresenter(this);
        this.bookPresenter.getBooks();

        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.books_list);
        this.adapter = new BooksAdapter(new ArrayList<>());
        rvBooks.setAdapter(adapter);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBookSuccess(List<Book> books) {
        adapter.reloadData(books);
    }

    @Override
    public void onBookError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG)
                .show();
    }
}
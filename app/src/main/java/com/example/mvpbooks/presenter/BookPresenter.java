package com.example.mvpbooks.presenter;

import com.example.mvpbooks.bean.Book;
import com.example.mvpbooks.model.BookModel;
import com.example.mvpbooks.model.IBookModel;
import com.example.mvpbooks.view.IBookView;

import java.util.List;

public class BookPresenter implements IBookPresenter {

    private IBookView view;
    private IBookModel model;

    public BookPresenter(IBookView hola) {
        this.view = hola;
        this.model = new BookModel(this);
    }

    @Override
    public void getBooks() {
        this.model.getBooks();
    }

    @Override
    public void onBooksSuccess(List<Book> books) {
        if (view == null)
            return;

        this.view.onBookSuccess(books);
    }

    @Override
    public void onBooksError(String msg) {
        if (view == null)
            return;

        this.view.onBookError(msg);
    }
}

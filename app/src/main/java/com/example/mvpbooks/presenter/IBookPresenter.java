package com.example.mvpbooks.presenter;

import com.example.mvpbooks.bean.Book;

import java.util.List;

public interface IBookPresenter {

    void getBooks();
    void onBooksSuccess(List<Book> books);
    void onBooksError(String msg);
}

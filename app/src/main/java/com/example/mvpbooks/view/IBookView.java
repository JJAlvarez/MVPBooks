package com.example.mvpbooks.view;

import com.example.mvpbooks.bean.Book;

import java.util.List;

public interface IBookView {

    void onBookSuccess(List<Book> books);
    void onBookError(String msg);
}

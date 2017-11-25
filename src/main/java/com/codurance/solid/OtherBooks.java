package com.codurance.solid;

import java.util.List;

import static com.codurance.solid.BookType.COOKING;
import static com.codurance.solid.BookType.IT;
import static com.codurance.solid.BookType.TRAVEL;

class OtherBooks extends Books {
    private final List<Book> books;

    OtherBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (Book book : books) {
            if (isOther(book)) {
                price += book.price();
            }
        }
        return price;
    }

    @Override
    public double discount() {
        return 0;
    }

    private boolean isOther(Book book) {
        return !TRAVEL.equals(book.type()) && !IT.equals(book.type()) && !COOKING.equals(book.type());
    }

}

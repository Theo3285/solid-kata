package com.codurance.solid;

import java.util.List;

import static com.codurance.solid.BookType.FANTASY;

public class FantasyBooks extends Books {

    private final List<Book> books;

    FantasyBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (Book book : books) {
            if (isFantasy(book)) {
                price += book.price();
            }
        }
        return price;
    }

    @Override
    public double discount() {
        if (this.count() > 4) {
            return 0.6; // 40% discount when buying more than 4 cooking books
        }
        return 0;
    }

    private double count() {
        double totalBooks = 0;
        for (Book book : books) {
            if (isFantasy(book)) {
                totalBooks++;
            }
        }
        return totalBooks;
    }

    private boolean isFantasy(Book book) {
        return FANTASY.equals(book.type());
    }

}

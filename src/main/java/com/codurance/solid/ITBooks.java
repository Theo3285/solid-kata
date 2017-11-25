package com.codurance.solid;

import java.util.List;

import static com.codurance.solid.BookType.IT;

public class ITBooks extends Books {
    private final List<Book> books;

    ITBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (Book book : books) {
            if (isIT(book)) {
                price += book.price();
            }
        }
        return price;
    }

    @Override
    public double discount() {
        if (this.count() > 2) {
            return 0.7; // 30% discount when buying more than 2 IT books
        } else if (this.count() > 0) {
            return 0.9; // 10% discount when buying up to 2 IT books
        }
        return 0;
    }

    private double count() {
        double totalBooks = 0;
        for (Book book : books) {
            if (isIT(book)) {
                totalBooks++;
            }
        }
        return totalBooks;
    }

    private boolean isIT(Book book) {
        return IT.equals(book.type());
    }

}

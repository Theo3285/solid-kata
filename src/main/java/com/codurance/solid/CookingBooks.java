package com.codurance.solid;

import java.util.List;

import static com.codurance.solid.BookType.COOKING;

public class CookingBooks extends Books {

    private final List<Book> books;

    CookingBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (Book book : books) {
            if (isCooking(book)) {
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
            if (isCooking(book)) {
                totalBooks++;
            }
        }
        return totalBooks;
    }

    private boolean isCooking(Book book) {
        return COOKING.equals(book.type());
    }

}

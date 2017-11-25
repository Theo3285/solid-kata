package com.codurance.solid;

import java.util.List;

import static com.codurance.solid.BookType.COOKING;
import static com.codurance.solid.BookType.IT;
import static com.codurance.solid.BookType.TRAVEL;

public abstract class Books {

    public static double price(List<Book> books) {
        Books itBooks = new ITBooks(books);
        Books travelBooks = new TravelBooks(books);
        Books otherBooks = new OtherBooks(books);
        Books cookingBooks = new CookingBooks(books);

        return (itBooks.getPrice() * itBooks.discount())
                + (travelBooks.getPrice() * travelBooks.discount())
                + (cookingBooks.getPrice() * cookingBooks.discount())
                + otherBooks.getPrice();
    }

    public abstract double getPrice();
    public abstract double discount();

}

package com.codurance.solid;

import java.util.List;

public abstract class Books {

    public static double price(List<Book> books) {
        Books itBooks = new ITBooks(books);
        Books travelBooks = new TravelBooks(books);
        Books otherBooks = new OtherBooks(books);
        Books fantasyBooks = new FantasyBooks(books);

        return (itBooks.getPrice() * itBooks.discount())
                + (travelBooks.getPrice() * travelBooks.discount())
                + (fantasyBooks.getPrice() * fantasyBooks.discount())
                + otherBooks.getPrice();
    }

    public abstract double getPrice();
    public abstract double discount();

}

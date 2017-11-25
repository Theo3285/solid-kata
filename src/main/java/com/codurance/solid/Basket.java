package com.codurance.solid;

import static java.lang.Math.round;
import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Basket {

	private List<Book> books = new ArrayList<Book>();

    public void add(Book book) {
		books.add(book);
	}

	public List<Book> books() {
		return unmodifiableList(books);
	}

	public double priceWithDiscount() {
        return Books.price(books);
	}

    public double fullPrice() {
		double price = 0;
		for (Book book : books) {
			price += book.price();
		}
		return price;
	}
}

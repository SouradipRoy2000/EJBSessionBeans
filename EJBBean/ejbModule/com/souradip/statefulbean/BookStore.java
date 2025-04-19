package com.souradip.statefulbean;

import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class BookStore
 */
@Stateless(mappedName = "BookStore")
@LocalBean
public class BookStore implements BookStoreRemote {

    List<String> bookList;
    public BookStore() {
        bookList=new ArrayList<>();
    }

	@Override
	public List<String> listBookItems() {
		// TODO Auto-generated method stub
		return this.bookList;
	}

	@Override
	public void addBook(String book) {
		bookList.add(book);
	}

	@Override
	public void clearBookCart() {
		bookList.clear();
	}

	@Override
	public void removeBookItem(String book) {
		bookList.remove(String.valueOf(book));
		System.out.println("The book with name: "+book+" has been removed from the cart successfully");
	}

}

package com.souradip.statefulbean;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface BookStoreRemote {
 public List<String> listBookItems();
 public void addBook(String book);
 public void clearBookCart();
 public void removeBookItem(String book);
}

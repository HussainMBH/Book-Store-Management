package com.example.bookstore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.Entity.MyBookList;
import com.example.bookstore.Repository.mybookRepository;

@Service
public class MyBookListService {
	
	@Autowired
	private mybookRepository mybook;
	
	public void saveMyBooks(MyBookList book) {
		mybook.save(book);
		
	}
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}
	
	public void deleteById(int id) {
		mybook.deleteById(id);
	}

}

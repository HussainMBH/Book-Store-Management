package com.example.bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookstore.Entity.Book;
import com.example.bookstore.Entity.MyBookList;
import com.example.bookstore.Service.BookService;
import com.example.bookstore.Service.MyBookListService;

import java.util.*;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	
	@GetMapping("/")
	public String home() {
		return"home";
	}
	@GetMapping("/book_registor")
		public String book_registor() {
			return"book_registor";
	}
	@GetMapping("/available_book")
		public ModelAndView getAllBook() {
			List<Book>list=service.getAllBook();
//			ModelAndView m=new ModelAndView();
//			m.setViewName("available_book");
//			m.addObject("book,list");
			return new ModelAndView("available_book","book",list);
			
		}
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return"redirect:/available_book";
	}
	@GetMapping("/mybooks")
	public String mybooks(Model model) {
		
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return"mybooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return"redirect:/mybooks";
	}
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model){
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return"editbook";
	}
	
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_book";
	}
	
	
	

}

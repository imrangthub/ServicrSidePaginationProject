package com.imran.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imran.model.Book;
import com.imran.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	

	@RequestMapping(value = "/book/{pageNo}", method = RequestMethod.GET)
	public String dashboard(ModelMap map, @PathVariable(value="pageNo") int currentPageNumber) {
		List<Book> bookList = new ArrayList<Book>();
		Map<String, Object> dataMap = bookService.paginateData();
		
		System.out.println("Current Page:"+currentPageNumber);
		
        bookList =bookService.bookList(currentPageNumber);
		map.addAttribute("bookList", bookList);
		map.addAttribute("dataMap", dataMap);
		return "bookHome";
	}

	
//	@RequestMapping(value = "/book", method = RequestMethod.GET)
//	public String loginView(Model model) {
//		List<Book> bookList = new ArrayList<Book>();
//		bookService.Test();
//
//        
//        for(Book obj: bookList){
//        	System.out.println("Book Name:"+obj.getName());
//        	System.out.println("Book Type:"+obj.getType());
//        	System.out.println("----------------------------------------");
//        }
//		
//		return "bookHome";
//	}

}


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
	

	@RequestMapping(value = "/book/pageNumber={pageNo}", method = RequestMethod.GET)
	public String dashboard(ModelMap map, @PathVariable(value="pageNo") int currentPageNumber) {
		List<Book> bookList = new ArrayList<Book>();
		int showingRowNumber = 3;
		Map<String, Object> dataMap = bookService.paginateData();
		dataMap.put("showingRowNumber", showingRowNumber);
		
		System.out.println("Current Page:"+currentPageNumber);
		
        bookList =bookService.bookList(currentPageNumber, showingRowNumber);
		map.addAttribute("bookList", bookList);
		map.addAttribute("dataMap", dataMap);
		return "bookHome";
	}

	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String loginView(ModelMap map) {
		int showingRowNumber = 3;
		List<Book> bookList = new ArrayList<Book>();
		Map<String, Object> dataMap = bookService.paginateData();		
        bookList =bookService.bookList(1, showingRowNumber);
		map.addAttribute("bookList", bookList);
		dataMap.put("showingRowNumber", showingRowNumber);
		map.addAttribute("dataMap", dataMap);
		return "bookHome";
	}

}


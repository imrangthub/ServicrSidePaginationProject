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
import org.springframework.web.bind.annotation.RequestParam;

import com.imran.model.Book;
import com.imran.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;


	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String loginView(ModelMap map,  @RequestParam(value="pageNumber", required=false) String pageNumber) {
		System.out.println("From No Argument Method.");
		int showingRowNumber = 3;
		int currentPageNo = 3;
		if(pageNumber!=null)
			currentPageNo = Integer.parseInt(pageNumber);
		System.out.println("From  Argument Method.");
		List<Book> bookList = new ArrayList<Book>();
		Map<String, Object> dataMap = bookService.paginateData(showingRowNumber);
		dataMap.put("showingRowNumber", showingRowNumber);
		
		System.out.println("Current Page:"+currentPageNo);
		
        bookList =bookService.bookList(currentPageNo, showingRowNumber);
		map.addAttribute("bookList", bookList);
		map.addAttribute("dataMap", dataMap);
		return "bookHome";
	}

}


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
import org.springframework.web.bind.annotation.ResponseBody;

import com.imran.model.Book;
import com.imran.service.BookDataTableClientSideService;
import com.imran.service.BookService;
import com.imran.service.BookTwoService;

@Controller
public class BookDataTableClientSideController {

	
	@Autowired
	BookDataTableClientSideService bookDataTableService;

	// for Client side
	@RequestMapping(value = "/bookDataTableClientSide", method = RequestMethod.GET)
	public String ClientPagination(ModelMap map) {
		List<Book> bookList = new ArrayList<Book>();
		 bookList = bookDataTableService.allDataList();
		map.addAttribute("bookList", bookList);
		
		 for(Book obj: bookList){
			 System.out.println("BNook Name"+obj.getName());
		 }		
		return "bookDataTableClientSide";
	}


}


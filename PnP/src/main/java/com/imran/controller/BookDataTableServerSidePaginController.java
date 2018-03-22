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
import com.imran.service.BookDataTableServerSideActionService;
import com.imran.service.BookDataTableServerSidePaginService;
import com.imran.service.BookService;
import com.imran.service.BookTwoService;

@Controller
@RequestMapping("/bookDataTableServerSidePagin")
public class BookDataTableServerSidePaginController {
	
	@Autowired
	BookTwoService BookTwoService;
	
	
	
	
	@Autowired
    BookDataTableServerSidePaginService bookDataTableServerSidePaginService;
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> test() {
		
		System.out.println("Fromj test metnod Speverside pageinaton");
		
		Map<String, Object> results = new HashMap<String, Object>();
		List<Book> bookList = new ArrayList<Book>();
		
		bookList = bookDataTableServerSidePaginService.list();
		int displayLength = 5;

		int recordsTotal = bookList.size();
	    int recordsFiltered = recordsTotal;
		results.put("draw", 1);
	    results.put("DisplayLength", displayLength);
	    results.put("recordsTotal", recordsTotal);
		results.put("recordsFiltered", recordsFiltered);
		results.put("data", bookList);
		results.put("isError", Boolean.FALSE);
		results.put("message", "test data");
		return results;
	

	}
	

	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> list(@RequestParam("type") String type) {
		Map<String, Object> results = new HashMap<String, Object>();
		List<Book> bookList = new ArrayList<Book>();
		
		bookList = bookDataTableServerSidePaginService.list();
		
		if(!type.equals("all")) {
			bookList = bookDataTableServerSidePaginService.listByType(type);
		}

		int TotalRecords = bookList.size();
	    int TotalDisplayRecords = 2;
	    
		results.put("TotalRecords", TotalRecords);
		results.put("TotalDisplayRecords", TotalDisplayRecords);
		results.put("data", bookList);
		results.put("isError", Boolean.FALSE);
		results.put("message", "test data");
		return results;
	

	}
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String serverSidePagination(ModelMap map) {
		return "bookDataTableServerSidePagin";
	}



}


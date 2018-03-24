package com.imran.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> test(HttpServletRequest requestParams) {
				
		Map<String, Object> results = new HashMap<String, Object>();
		List<Book> bookList = new ArrayList<Book>();
		
	    int iDisplayStart= Integer.parseInt(requestParams.getParameter("start"));
        int  iDisplayLength= Integer.parseInt(requestParams.getParameter("length"));
        String  search= requestParams.getParameter("search[value]");
        String  bookType= requestParams.getParameter("bookType");
		System.out.println("Params Data----------------------------------------------------------------------------");
		System.out.println("Show Start page no"+requestParams.getParameter("start"));
		System.out.println("Show Length"+requestParams.getParameter("length"));
		System.out.println("Show Search Letter"+requestParams.getParameter("search[value]"));
		System.out.println("Show type"+requestParams.getParameter("bookType"));
		System.out.println("Params Data----------------------------------------------------------------------------");

		bookList = bookDataTableServerSidePaginService.bookListWithQuery(bookType, search, iDisplayStart,iDisplayLength);
		int recordsTotal = bookDataTableServerSidePaginService.countValue();
	    results.put("recordsTotal", recordsTotal);
		results.put("recordsFiltered", recordsTotal);
		results.put("data", bookList);
		results.put("isError", Boolean.FALSE);
		results.put("message", "test data");
		return results;
	

	}

	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String serverSidePagination(ModelMap map) {
		return "bookDataTableServerSidePagin";
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public Map<String, Object> home(@PathVariable("id") String id) {
		Map<String, Object> results = new HashMap<String, Object>();
		if(bookDataTableServerSidePaginService.delate(id)) {
			results.put("isError", Boolean.FALSE);
			results.put("message", "Successfully delete Completed");
		}else{
			results.put("isError", Boolean.TRUE);
			results.put("message", "Delete operation failed");	
		}
		
		return results;
	}



}


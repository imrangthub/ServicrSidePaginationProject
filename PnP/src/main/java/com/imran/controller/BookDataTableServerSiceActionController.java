package com.imran.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.imran.model.Book;
import com.imran.service.BookDataTableServerSideActionService;
import com.imran.service.BookTwoService;

@Controller
@RequestMapping("/bookDataTableServerSideAction")
public class BookDataTableServerSiceActionController {
	
	@Autowired
	BookTwoService BookTwoService;
	
	@Autowired
	BookDataTableServerSideActionService bookDataTableServerSideActionService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> list(@RequestParam("type") String type) {
		Map<String, Object> results = new HashMap<String, Object>();
		List<Book> bookList = new ArrayList<Book>();
		
		bookList = bookDataTableServerSideActionService.list();
		
		if(!type.equals("all")) {
			bookList = bookDataTableServerSideActionService.listByType(type);
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
	public String home(ModelMap map) {
		return "bookDataTableServerSideAction";
	}
	

	
	



}


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
import com.imran.service.BookDataTableService;
import com.imran.service.BookService;

@Controller
public class BookDataTableController {
	
	@Autowired
	BookDataTableService bookDataTableService;

	@RequestMapping(value = "/bookDataTable", method = RequestMethod.GET)
	public String home() {
		bookDataTableService.testMethod();
		return "bookDataTable";
	}

}


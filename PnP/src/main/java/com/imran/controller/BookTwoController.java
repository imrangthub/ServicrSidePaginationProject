package com.imran.controller;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imran.model.Book;
import com.imran.service.BookService;
import com.imran.service.BookTwoService;

@Controller
public class BookTwoController {
	
	@Autowired
	BookTwoService BookTwoService;
	

	@RequestMapping(value = "/bookTwo", method = RequestMethod.GET)
	public String home() {
		return "bookHomeTwo";
	}
	
	@RequestMapping(value="/bookTwoList", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> addBook(@RequestParam(value="pageNumber", required=false) String pageNumber){
		Map<String, Object> map = new HashMap<String, Object>();
		
		int showingRowNumber = 3;
		int currentPageNo = 3;
		if(pageNumber!=null)
			currentPageNo = Integer.parseInt(pageNumber);
		System.out.println("From  Argument Method.");
		List<Book> bookList = new ArrayList<Book>();
		Map<String, Object> dataMap = BookTwoService.paginateData(showingRowNumber);
		dataMap.put("showingRowNumber", showingRowNumber);
		
		System.out.println("Current Page:"+currentPageNo);
		
        bookList =BookTwoService.bookList(currentPageNo, showingRowNumber);
		map.put("bookList", bookList);
		map.put("dataMap", dataMap);
	
		map.put("successMsg","Successfully Update Your Product"+pageNumber);
		return map;
	}
	
//	@ResponseBody
//	@RequestMapping(value="/bookTwoList",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Book listx(ModelMap map,@RequestParam(value="pageNumber", required=false) String pageNumber){
//		Book object = new Book();
//		return object;
//	}
	
	
	@ResponseBody
	@GetMapping(value="/bookTwoListxx",produces={MediaType.APPLICATION_JSON_VALUE})
	public ModelMap list(ModelMap map,@RequestParam(value="pageNumber", required=false) String pageNumber){
		
		int showingRowNumber = 3;
		int currentPageNo = 3;
		if(pageNumber!=null)
			currentPageNo = Integer.parseInt(pageNumber);
		System.out.println("From  Argument Method.");
		List<Book> bookList = new ArrayList<Book>();
		Map<String, Object> dataMap = BookTwoService.paginateData(showingRowNumber);
		dataMap.put("showingRowNumber", showingRowNumber);
		
		System.out.println("Current Page:"+currentPageNo);
		
        bookList =BookTwoService.bookList(currentPageNo, showingRowNumber);
		map.addAttribute("bookList", bookList);
		map.addAttribute("dataMap", dataMap);
		
		return map;
		

	}
	
	


//	@RequestMapping(value = "/bookTwoxx", method = RequestMethod.GET)
//	public String loginView(ModelMap map,  @RequestParam(value="pageNumber", required=false) String pageNumber) {
//		System.out.println("From No Argument Method.");
//		int showingRowNumber = 3;
//		int currentPageNo = 3;
//		if(pageNumber!=null)
//			currentPageNo = Integer.parseInt(pageNumber);
//		System.out.println("From  Argument Method.");
//		List<Book> bookList = new ArrayList<Book>();
//		Map<String, Object> dataMap = bookService.paginateData(showingRowNumber);
//		dataMap.put("showingRowNumber", showingRowNumber);
//		
//		System.out.println("Current Page:"+currentPageNo);
//		
//        bookList =bookService.bookList(currentPageNo, showingRowNumber);
//		map.addAttribute("bookList", bookList);
//		map.addAttribute("dataMap", dataMap);
//		return "bookHomeTwo";
//	}

}


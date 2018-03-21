package com.imran.service;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import org.springframework.stereotype.Service;

import com.imran.model.Book;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BookTwoService {
	
	@Autowired
	DataSource dataSource;
	private Statement stmt;
	
	public Map<String, Object> paginateData(int showingRowNumber ){
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		String getAllDataQuery = "SELECT count(*) FROM `book` ORDER BY ID"; //  LIMIT " + 1 + ","+ 2
		try {
			this.stmt = dataSource.getConnection().createStatement();
			ResultSet tempResult = stmt.executeQuery(getAllDataQuery);
			tempResult.next();
		    int rowcount = tempResult.getInt(1);
		    int totalRow=0;
		    System.out.println("Row Count befor Cal ==========:"+rowcount);
		    totalRow = (rowcount/showingRowNumber);
		    if(rowcount%showingRowNumber !=0)
		       totalRow+=1;

		    System.out.println("Row Count after Cal ==========:"+rowcount);
		    dataMap.put("totalRow", totalRow);
		    System.out.println("Total Rwow"+totalRow);

			stmt.close();
			dataSource.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dataMap.put("msg", "This is Msg");
		return dataMap;		
	}
	
	public void Test(){
		System.out.println("Success from test Bookj Service");
	}
	
	public List<Book> bookList(int reqPage, int showingRowNumber){

		   int startPage = 0;	
		       startPage = ((reqPage-1)*showingRowNumber);

		   System.out.println("Current page from Service"+reqPage);
		
		List<Book> bookList = new ArrayList<Book>();
		
		String getAllDataQuery = "SELECT * FROM `book` ORDER BY ID limit "+startPage+","+showingRowNumber+""; 
		   System.out.println(getAllDataQuery);
		try {
			this.stmt = dataSource.getConnection().createStatement();
			ResultSet tempResult = stmt.executeQuery(getAllDataQuery);
			while(tempResult.next()){
				Book bookObj = new Book();
				bookObj.setId(Long.parseLong(tempResult.getString("id")));
				bookObj.setName(tempResult.getString("name"));
				bookObj.setType(tempResult.getString("type"));
				bookList.add(bookObj);
			}
			stmt.close();
			dataSource.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;		
	}

}

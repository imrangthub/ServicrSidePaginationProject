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
public class BookDataTableServerSidePaginService {
	
	@Autowired
	DataSource dataSource;
	private Statement stmt;
	
	public void testMethod(){
		System.out.println("From DataTable Service");
	}
	
	public List<Book> list(){
		List<Book> bookList = new ArrayList<Book>();	
		String getAllDataQuery = "SELECT * FROM `book` ORDER BY ID"; 
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
	
	public List<Book> bookListWithQuery(String bookType, String search, int startPage, int numberOfRow){		
		List<Book> bookList = new ArrayList<Book>();
		String getAllDataQuery; 
		
		   getAllDataQuery = "SELECT * FROM book ORDER BY ID limit "+startPage+","+numberOfRow+""; 
          if(search != null) {
        	   getAllDataQuery = "SELECT * FROM book WHERE name LIKE '%"+search+"%' ORDER BY ID limit "+startPage+","+numberOfRow+""; 
		    }
          if(!bookType.equals("all")) {
       	        getAllDataQuery = "SELECT * FROM book WHERE type = '"+bookType+"' ORDER BY ID limit "+startPage+","+numberOfRow+""; 
		    } 
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
	
	public int countValue(){
		 int rowcount = 0;		
		String getAllDataQuery = "SELECT count(*) FROM `book` ORDER BY ID"; //  LIMIT " + 1 + ","+ 2
		try {
			this.stmt = dataSource.getConnection().createStatement();
			ResultSet tempResult = stmt.executeQuery(getAllDataQuery);
			tempResult.next();
		     rowcount = tempResult.getInt(1);
		    System.out.println("Row Count after Cal ==========:"+rowcount);
			stmt.close();
			dataSource.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowcount;		
	}
	
	public List<Book> listByType(String type){
		List<Book> bookList = new ArrayList<Book>();	
		String getAllDataQuery = "SELECT * FROM book where type ='"+type+"' ORDER BY ID"; 
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
	
	public boolean delate(String id){
		 boolean result = false;		
		String deleteQuery = "DELETE FROM book WHERE id="+id;
		try {
			this.stmt = dataSource.getConnection().createStatement();
			result = stmt.execute(deleteQuery);
			stmt.close();
			dataSource.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;		
	}
	
         

}

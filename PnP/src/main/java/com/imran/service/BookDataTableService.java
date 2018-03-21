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
public class BookDataTableService {
	
	@Autowired
	DataSource dataSource;
	private Statement stmt;
	
	public void testMethod(){
		System.out.println("From DataTable Service");
	}
	
         

}

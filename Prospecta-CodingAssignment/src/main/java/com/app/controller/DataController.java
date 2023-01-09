package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.model.Data;
import com.app.model.Entry;
import com.app.model.ResponseDTO;

@RestController
public class DataController {
	
	@Autowired
	private RestTemplate restTemplate ;

	
	@GetMapping("entries")
	public ResponseEntity<?> getAllEntriesHandler(){
		
		String url = "https://api.publicapis.org/entries" ;
		
		Data data = restTemplate.getForObject(url , Data.class); 
		
		List<Entry> listOfEntries = data.getEntries() ; 
		
		
		return ResponseEntity.ok(listOfEntries) ; 
	}
	
	// Create an API that lists the title, description based on the category passed as an input parameter.
	
	@GetMapping("entries/{category}")
	public ResponseEntity<?> getEntryHandler(@PathVariable("category") String category ){
		
		String url = "https://api.publicapis.org/entries" ;
		
		Data data = restTemplate.getForObject(url , Data.class); 
		
		List<Entry> listOfEntries = data.getEntries() ; 
		
		List<ResponseDTO> dtos =  listOfEntries.stream().map(e-> new ResponseDTO( e.getApi() , e.getDescription() ) ).collect(Collectors.toList());
		
		return ResponseEntity.ok(dtos) ; 
	}
	
	// Create an API that would save a new entry with all the relevant properties which retrieves values from the endpoint GET /entries.
	@PostMapping("entries")
	public ResponseEntity<?> saveEntryHandler( @RequestBody Entry e ){
		
		String url = "https://api.publicapis.org/entries" ;
		
		Data data = restTemplate.getForObject(url , Data.class); 
		data.setCount(data.getCount()+1);
		List<Entry> entries = data.getEntries();
		entries.add(e);
		
		return ResponseEntity.ok( data );
		
	}
	
	// Question: what are the key things you would consider when creating/consuming an API to ensure that it is secure and reliable?
	/*
	1. There are diffrent type of key fac
	
	
		There are number of KeyFactors are there whenever we create API 

		1 . Validation 
		
			if we are creating restApi which including posting data in our database then we must check all the data types and validation
			must be satisfied as per our requirement in database 
		
		2 . Authorization 
			
			this factor comes under which user should have which kind of data access and authorities access into out application 
		
		3 . Authentication 
		
			this is kind of entry point for our user so that application will understand the authorities and action which user is assigned 
		
		4. Encryption 
		
			in our application all the sensitive data must be in the form of encrypted for improving security of our application 
			
	
	 */
	
	
}

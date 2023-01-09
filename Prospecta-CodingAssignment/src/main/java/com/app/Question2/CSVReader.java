package com.app.Question2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Faiz\\Desktop\\STS\\WorkSpace\\ConsumeAPI\\"
				+ "Prospecta-CodingAssignment\\src\\main\\java\\com\\app\\Question2\\data.csv"));
		
		var line  =  bufferedReader.readLine() ;
		
		String[] data =  line.split(",");
		Map<String, String> map = new LinkedHashMap<>();


	    for (int i = 0; i < data.length; i++) {
	         String[] table = data[i].split(":");
	         map.put(table[0].trim(), table[1].trim());
	    }

	     
	    for (Map.Entry<String, String> e : map.entrySet()) {
	         if (e.getValue().startsWith("=")) {
	            e.setValue(e.getValue().substring(1));
	         }
	    }

	    Map<String, Integer> map2 = new LinkedHashMap<>();

	    for (Map.Entry<String, String> e : map.entrySet()) {
	         String value = e.getValue();
	         if (value.contains("+")) {
	            String[] operands = value.split("\\+");
	            int sum = 0;

	            
	    for (int i = 0; i < operands.length; i++) {
	           if (operands[i].matches(".*[A-Z].*")) {
	                
	                  sum += Integer.parseInt(map.get(operands[i]));
	               
	               } else {
	                  sum += Integer.parseInt(operands[i]);
	               }
	            }
	            
	            map.put(e.getKey(), sum + "");
	            map2.put(e.getKey(), sum);
	         }else{
	            map2.put(e.getKey(), Integer.parseInt(value));
	         }
	      }

	
	      for (Map.Entry<String, Integer> e : map2.entrySet()) {
	         System.out.println(e.getKey() + " = " + e.getValue());
	      }

	   }
		
		
}



/*
// 1. How will you tackle the challenge above?
 * 
 * for solving the problem i will first get the data from csv file to my Ide by using BufferedReader class 
 * then i will start writing logic for it 

//2. What type of errors you would you check for?
 * 
 * whenever i convert data from string to integer i will check for Number format exception and also i will check for exception like whether csv file holds data or not

//3. How might a user break your code?
 * 
 * there will be various way for user to break the code he provid an entry which will not present in data might become way to showing wrong information after someone
 * will run this program on that file 
 * 
 * 
 */


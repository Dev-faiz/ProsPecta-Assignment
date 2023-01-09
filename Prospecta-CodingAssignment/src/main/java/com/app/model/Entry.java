package com.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Entry {
	
	@JsonProperty("API")
	private String api ; 
	
	@JsonProperty("Description")
	private String description ; 
	
	@JsonProperty("Auth")
	private String auth ; 
	
	@JsonProperty("Https")
	private boolean hTTPS ;
	
	@JsonProperty("Cors")
	private String cors ; 
	
	@JsonProperty("Category")
	private String category ; 
	

}

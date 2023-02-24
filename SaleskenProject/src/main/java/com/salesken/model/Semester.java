package com.salesken.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semester {

	private int id;
	
	private Integer english;
	
	private Integer maths;
	
	private Integer science;
}

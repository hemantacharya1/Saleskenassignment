package com.salesken.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semester {

	private int id;
	
	private int english;
	
	private int maths;
	
	private int science;
}

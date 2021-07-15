package com.nit.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileUser {

	
	private Integer regNO;
	private String name;
	private Long mobileNo;
	private String circle;
	private boolean postpaid;

	
	private Integer updationCount;// field for version count= how many times record updated

}

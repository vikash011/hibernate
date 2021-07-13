package com.nit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileUser {

	@Id
	private Integer regNO;
	private String name;
	private Long mobileNo;
	private String circle;
	private boolean postpaid;

	@Version
	private Integer updationCount;// field for version count= how many times record updated

}

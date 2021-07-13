package com.nit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Artist {

	@Id
	private Integer aId;
	private String name;
	private Double income;
	private String address;

}

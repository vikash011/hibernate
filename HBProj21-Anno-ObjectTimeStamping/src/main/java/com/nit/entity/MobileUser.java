package com.nit.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Mobile_User_TimeStamp")
public class MobileUser {

	@Id
	private Integer regNO;
	private String name;
	private Long mobileNo;
	private String circle;
	private boolean postpaid;

	@Version
	private Integer updationCount;// field for version count=> how many times record updated

	@CreationTimestamp
	private Timestamp dateOfJoining;// field for time stamping for creation=> when record Created
	@UpdateTimestamp
	private Timestamp lastUpdated;// filed for time stamping for update =>when record LastlyUpdated

}

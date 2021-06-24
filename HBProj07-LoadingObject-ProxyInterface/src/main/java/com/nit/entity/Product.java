package com.nit.entity;

import java.util.Arrays;

public class Product implements IProduct {

	private Integer pid;
	private String pname;
	private Double price;
	private String status;
	private Integer count;

	public Product() {
		System.out.println(this.getClass() + "  " + this.getClass().getSuperclass() + "   "
				+ Arrays.toString(this.getClass().getInterfaces()));
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", status=" + status + ", count="
				+ count + "]";
	}

	@Override
	public Integer pid() {

		return pid;
	}

	@Override
	public String pname() {

		return pname;
	}

	@Override
	public Double price() {

		return price;
	}

	@Override
	public String status() {

		return status;
	}

	@Override
	public Integer count() {

		return count;
	}

}

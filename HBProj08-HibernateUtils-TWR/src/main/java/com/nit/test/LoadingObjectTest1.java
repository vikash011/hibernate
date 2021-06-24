package com.nit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nit.entity.Product;

public class LoadingObjectTest1 {

	public static void main(String[] args) {

//		creating Configuration Object
		Configuration cfg = new Configuration();
		cfg.configure("/com/nit/cfgs/hibernate.cfg.xml");

//		creating SessionFactory Object
		SessionFactory factory = cfg.buildSessionFactory();

//		creating Session Object
		Session ses = factory.openSession();

		try {

//			Loading Record
			Product prod = ses.get(Product.class, 1003111);
			if (prod == null) {
				System.out.println("No Record Found");
			} else {

				System.out.println(prod.getPid() + " " + prod.getPname() + " " + prod.getStatus() + " "
						+ prod.getCount() + " " + prod.getPrice());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

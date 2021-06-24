package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nit.entity.Product;

public class SaveTest2 {

	public static void main(String[] args) {

//		  creating Configuration object
		Configuration cfg = new Configuration();

		// locating Hibernate cfg file
		cfg.configure("/com/nit/cfgs/hibernate.cfg.xml");

//		creating SessionFactory object
		SessionFactory factory = cfg.buildSessionFactory();

//		creating Session Object
		Session ses = factory.openSession();

//		creating Product class Object
		Product p1 = new Product();
		p1.setPid(1003);
		p1.setPname("Chairs");
		p1.setCount(10);
		p1.setPrice(1442.8);
		p1.setStatus("available");

		try {

//		inserting record into table
			ses.save(p1);
			ses.flush();
			System.out.println("Record inserted Sucessfully ");

		} catch (HibernateException he) {
			he.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

//			closing HB object
			ses.close();
			factory.close();

		}

	}

}

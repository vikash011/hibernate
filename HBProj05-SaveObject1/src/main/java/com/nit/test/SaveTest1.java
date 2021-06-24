package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nit.entity.Product;

public class SaveTest1 {

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
		p1.setPid(1002);
		p1.setPname("Chairs");
		p1.setCount(10);
		p1.setPrice(1442.8);
		p1.setStatus("available");

		Transaction tx = null;
		boolean flag = false;

		try {

//		starting Tx mgmt
			tx = ses.beginTransaction();// it internally call con.setAutoCommit(false);

//		inserting record into table
			ses.save(p1);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;

		} finally {

			if (flag) {
				tx.commit();// internally calls con.commit()
				System.out.println("Record Inserted Succesfully");
			} else {
				tx.rollback();// internally calls con.rollback();
				System.out.println("Record insertion Unsucessful");
			}

//			closing HB object
			ses.close();
			factory.close();

		}

	}

}

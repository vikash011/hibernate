package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nit.entity.Product;

public class SaveTest2 {

	public static void main(String[] args) {

		// creating Configuration object
		Configuration cfg = new Configuration();
		cfg.configure("com/nit/cfgs/hibernate.cfg.xml");

		// creating Session factory class Object
		SessionFactory factory = cfg.buildSessionFactory();

		// creating Session object
		Session ses = factory.openSession();

//		  creating Transaction object
		Transaction tx = ses.beginTransaction();

		boolean flag = false;

		// creating Product class object
		Product p1 = new Product();
		p1.setPid(1007);
		p1.setPname("table");
		p1.setPrice(29929.0);
		p1.setCount(12);

		try {
			int idVal = (int) ses.save(p1);
			flag = true;
			System.out.println("Geenrated Id value::" + idVal);

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			flag = false;
		} finally {

			if (flag) {
				tx.commit();
				System.out.println("Record is Inserted(Record is committed)");
			} else {
				tx.rollback();
				System.out.println("Record is not Inserted(Record is Rollback)");
			}
			ses.close();
			factory.close();

		}

	}

}

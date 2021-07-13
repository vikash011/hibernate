package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utils.HibernateUtils;

public class SaveOrUpdate1 {

	public static void main(String[] args) {

		// create SessionFactory object
		SessionFactory factory = HibernateUtils.getSessionFactory();

		// create Session object
		Session ses = HibernateUtils.getSession(factory);

		// create Transaction Object
		Transaction tx = null;

		try {
			Product p1 = ses.get(Product.class, 1002);
			System.out.println(p1);

			// create entity object

			tx = ses.beginTransaction();

			
			p1.setPname("Handwash");
			p1.setPrice(1111.8);
			p1.setStatus("available");

			// merging record into existing record
			ses.saveOrUpdate(p1);
			System.out.println(p1);
			// commit Transaction
			tx.commit();

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

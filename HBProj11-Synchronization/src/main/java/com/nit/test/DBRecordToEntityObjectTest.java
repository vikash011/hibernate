package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utils.HibernateUtils;

public class DBRecordToEntityObjectTest {

	public static void main(String[] args) {

		// creating SessionFactory object
		SessionFactory factory = HibernateUtils.getSessionFactory();
		// creating Session object
		Session ses = HibernateUtils.getSession(factory);

		// Creating Transaction Object
		// Transaction tx = null;

		try {

//		Record Before update
			Product p1 = ses.get(Product.class, 1003);
			System.out.println(p1);

			Thread.sleep(30000);
			ses.refresh(p1);

//			Record After update
			Product p2 = ses.get(Product.class, 1003);
			System.out.println(p2);

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

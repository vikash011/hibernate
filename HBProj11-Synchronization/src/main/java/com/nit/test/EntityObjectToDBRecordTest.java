package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utils.HibernateUtils;

public class EntityObjectToDBRecordTest {

	public static void main(String[] args) {

		// creating SessionFactory object
		SessionFactory factory = HibernateUtils.getSessionFactory();
		// creating Session object
		Session ses = HibernateUtils.getSession(factory);

		// Creating Transaction Object
		//Transaction tx = null;

		try {
			Product p1 = ses.get(Product.class, 1003);
			System.out.println(p1);

			if (p1 == null) {
				System.out.println("NO Record Found");
			} else {
				p1.setPrice(6767.8);
				ses.update(p1);
				System.out.println("Object is Modified");
				System.out.println(p1);
			}

		} catch (HibernateException he) {

		}

	}

}

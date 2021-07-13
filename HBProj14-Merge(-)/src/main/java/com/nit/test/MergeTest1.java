package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utils.HibernateUtils;

public class MergeTest1 {

	public static void main(String[] args) {

//		create SessionFactory object
		SessionFactory factory = HibernateUtils.getSessionFactory();

//		create Session object
		Session ses = HibernateUtils.getSession(factory);

//		create Transaction Object
		Transaction tx = null;

		try {

//			loading record from table
			Product p1 = ses.get(Product.class, 100211);
			System.out.println(p1);

//			create entity object
			if (p1 != null) {
				tx = ses.beginTransaction();
				Product p2 = new Product();
				p2.setPid(1002);
				p2.setPname("chair");
				p2.setPrice(6767.8);
				p2.setStatus("available");

//				merging record  into existing record
				ses.merge(p2);
//				commit Transaction
				tx.commit();

				Product p3 = ses.get(Product.class, 1002);
				System.out.println(p3);
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

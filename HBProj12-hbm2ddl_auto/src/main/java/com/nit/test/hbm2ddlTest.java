package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utils.HibernateUtils;

public class hbm2ddlTest {

	public static void main(String[] args) {

//		creating Configuration object
		SessionFactory factory = HibernateUtils.getSessionFactory();

//		creating Session Object
		Session ses = HibernateUtils.getSession(factory);

//		creating Transaction Object
		Transaction tx = null;

		try {
			tx = ses.beginTransaction();

//			create Product Object
			Product p1 = new Product();
			p1.setPid(1002);
			p1.setPname("table");
			p1.setPrice(76767.8);
			p1.setCount(45);
			p1.setStatus("available");

//			inserting Object
			ses.save(p1);

//			committing Transaction
			tx.commit();

		} catch (HibernateException he) {
			if (tx != null && tx.getRollbackOnly()) {
				tx.rollback();
			}
			System.out.println("Object Not deleted ");
		} catch (Exception e) {
			if (tx != null && tx.getRollbackOnly()) {
				tx.rollback();
			}
			System.out.println("Object Not deleted ");
		} finally {
			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();
		}

	}

}

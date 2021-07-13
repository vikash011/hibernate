package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utils.HibernateUtils;

public class DeleteObject02 {

	public static void main(String[] args) {

		// creating Configuration object
		SessionFactory factory = HibernateUtils.getSessionFactory();

		// creating Session Object
		Session ses = HibernateUtils.getSession(factory);

		// creating Transaction Object
		Transaction tx = null;

		try {
			tx = ses.beginTransaction();

			// create Product Object
			Product p1 = ses.get(Product.class, 1002);
			if (p1 == null) {
				System.out.println(" No Record Found");
			} else {

				// delete Operation
				ses.delete(p1);

				// commit Transaction
				tx.commit();
				System.out.println("Object Deleted");

			}

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

package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utils.HibernateUtils;

public class UpdateObjectTest02 {

	public static void main(String[] args) {

//		creating SessionFactory Object
		SessionFactory factory = HibernateUtils.getSessionFactory();

//		creating Session object"
		Session ses = HibernateUtils.getSession(factory);

		Transaction tx = null;
		try {

//			starting Transaction
			tx = ses.beginTransaction();

//			Load Object ses.get()
			Product p1 = ses.get(Product.class, 1002);

			if (p1 == null) {
				System.out.println("No Record Found");

			} else {
				p1.setCount(101);
				p1.setStatus(" Not Available");

//			update Operation  //Approach 2  Partial Update
				ses.update(p1);
//			commit Transactions
				tx.commit();
				System.out.println("Object Updated");
			}

		} catch (HibernateException he) {
			if (tx != null && tx.getRollbackOnly()) {
				tx.rollback();
			}
			System.out.println("Object Not Updated");
			he.printStackTrace();

		} catch (Exception e) {
			if (tx != null && tx.getRollbackOnly()) {
				tx.rollback();
			}
			System.out.println("Object Not Updated");
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();
		}

	}

}

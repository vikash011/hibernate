package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utils.HibernateUtils;

public class UpdateObjectTest01 {

	public static void main(String[] args) {

//		creating SessionFactory Object
		SessionFactory factory = HibernateUtils.getSessionFactory();

//		creating Session object"
		Session ses = HibernateUtils.getSession(factory);

		Transaction tx = null;
		try {

//			starting Transaction
			tx = ses.beginTransaction();

//			create entity Object
			Product p1 = new Product();
			p1.setPid(1002);
			p1.setPname("FaceCream");
			p1.setPrice(454545.6);
			p1.setCount(41);
			p1.setStatus("Not Available");

//			update Operation  //Approach 1 which updates Completes Record
			ses.update(p1);
//			commit Transactions
			tx.commit();
			System.out.println("Object Updated");

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

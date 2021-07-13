package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.MobileUser;
import com.nit.util.HibernateUtil;

public class ObjectVersionInsertTest {

	@SuppressWarnings("null")
	public static void main(String[] args) {

//		creating SessionFactory Object
		SessionFactory factory = HibernateUtil.getSessionFactory();

//		creating Session object
		Session ses = HibernateUtil.getSession(factory);

//		creating Transaction Object
		Transaction tx = null;

		try {
//			assigning Transaction Object
			tx = ses.beginTransaction();

//			creating MobileUser object
			MobileUser user = new MobileUser();
			user.setRegNO(123);
			user.setName("Raja");
			user.setPostpaid(true);
			user.setMobileNo(878787l);
			user.setCircle("MP");

//			saving Object
			ses.save(user);
//			commit transaction
			tx.commit();
			System.out.println("Object Saved Sucessfully with: " + user.getUpdationCount());

		} catch (HibernateException he) {

			if (tx != null || tx.getRollbackOnly() || tx.getStatus() != null) {
				tx.rollback();
				System.out.println("Object Not Saved");
			}

			he.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Object Not Saved");
		}

	}

}

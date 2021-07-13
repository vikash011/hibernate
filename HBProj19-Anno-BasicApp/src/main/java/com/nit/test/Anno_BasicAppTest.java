package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Artist;
import com.nit.util.HibernateUtil;

public class Anno_BasicAppTest {

	public static void main(String[] args) {

//		creating SessionFactory object
		SessionFactory factory = HibernateUtil.getSessionFactory();

//		creating Session object
		Session ses = HibernateUtil.getSession(factory);

//	creating Transaction object
		Transaction tx = null;

		try {
			tx = ses.beginTransaction();

//			creating Entity class Object
			Artist arts = new Artist();
			arts.setAId(1003);
			arts.setName("Raja");
			arts.setIncome(778978.7);
			arts.setAddress("Delhi");

//			inserting Record
			Object idVal = ses.save(arts);
			System.out.println(idVal);

//			commit Transaction
			tx.commit();

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();

		}

	}

}

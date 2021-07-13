package com.nit.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utils.HibernateUtils_MySql;
import com.nit.utils.HibernateUtils_Oracle;

public class RecordDataTransferTest {

	public static void main(String[] args) {

//		creating Configuration object
		SessionFactory oracle_factory = HibernateUtils_Oracle.getSessionFactory();
		SessionFactory mysql_factory = HibernateUtils_MySql.getSessionFactory();

//		creating Session Object
		Session oracle_ses = HibernateUtils_Oracle.getSession(oracle_factory);
		Session mysql_ses = HibernateUtils_MySql.getSession(mysql_factory);

//		creating Transaction Object
		Transaction tx = null;

		try {

//			Loading Record from Oracle Table 
			Product p1 = oracle_ses.get(Product.class, 1002);
			System.out.println(p1);

			tx = mysql_ses.beginTransaction();

//			Inserting Record Into MySQL table
			 Serializable save = mysql_ses.save(p1);
			System.out.println(save);

//			commit Transaction
			tx.commit();
			System.out.println("Record Transfer succesfully");

		} catch (HibernateException he) {
			if (tx != null && tx.getRollbackOnly()) {
				tx.rollback();
			}
			System.out.println("Record Not Transfer ");
		} catch (Exception e) {
			if (tx != null && tx.getRollbackOnly()) {
				tx.rollback();
			}
			System.out.println("Record Not Transfer ");
		} finally {
			HibernateUtils_Oracle.closeSession(oracle_ses);
			HibernateUtils_Oracle.closeSessionFactory();

			HibernateUtils_MySql.closeSession(mysql_ses);
			HibernateUtils_MySql.closeSessionFactory();
		}

	}

}

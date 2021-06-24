package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.nit.entity.Product;
import com.nit.utils.HibernateUtils;

public class LoadingObjectTest3 {

	public static void main(String[] args) {

//     creating SessionFactory object using HibernateUtils
		SessionFactory factory = HibernateUtils.getSessionFactory();

//		creating Session Object
		Session ses = HibernateUtils.getSession(factory);

		try {

//			Loading Record
			Product prod = ses.get(Product.class, 1003);
			if (prod == null) {
				System.out.println("No Record Found");
			} else {

				System.out.println(prod.getPid() + " " + prod.getPname() + " " + prod.getStatus() + " "
						+ prod.getCount() + " " + prod.getPrice());
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();
		}

	}

}

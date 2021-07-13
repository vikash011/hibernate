package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nit.entity.Product;
import com.nit.utils.HibernateUtils;

public class LegacyBootstrapppingUsingProgramaticApproachTest1 {

	public static void main(String[] args) {

//		creating SessionFactory Object
		SessionFactory factory = HibernateUtils.getSessionFactory();
//		creating Session object
		Session ses = HibernateUtils.getSession(factory);

		try {

//			Loading Record
			Product prod = ses.get(Product.class, 100222);
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
		}

	}

}

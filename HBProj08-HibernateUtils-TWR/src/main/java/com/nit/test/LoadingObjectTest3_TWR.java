package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nit.entity.Product;
import com.nit.utils.HibernateUtils;

public class LoadingObjectTest3_TWR {

	public static void main(String[] args) {

		try (SessionFactory factory = HibernateUtils.getSessionFactory();) {
			try (Session ses = HibernateUtils.getSession(factory)) {
//			Loading Record
				Product prod = ses.get(Product.class, 1003);
				if (prod == null) {
					System.out.println("No Record Found");
				} else {
					System.out.println(prod.getPid() + " " + prod.getPname() + " " + prod.getStatus() + " "
							+ prod.getCount() + " " + prod.getPrice());
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

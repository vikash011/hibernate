package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nit.entity.Product;

public class LoadingObjectTest2 {

	public static void main(String[] args) {

//		creating Configuration object
		Configuration cfg = new Configuration();
		cfg.configure("/com/nit/cfgs/hibernate.cfg.xml");

//		 Creating SessionFactory  object
		SessionFactory factory = cfg.buildSessionFactory();

//		creating Session object
		Session ses = factory.openSession();

		try {
//			loading Object/Record  using ses.load()
			Product proxy = ses.load(Product.class, 1003);
			System.out.println(proxy + "  " + proxy.getClass() + "  " + proxy.getClass().getSuperclass());

		} catch (ObjectNotFoundException onf) {
			System.out.println("No Record Found for this Id");
			onf.printStackTrace();
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ses.close();
			factory.close();
		}

	}

}

package com.nit.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory;

	static {

//		creating Configuration object
		Configuration cfg = new Configuration();
		cfg.configure("/com/nit/cfgs/hibernate.cfg.xml");

//	creating SessionFactory Object

		factory = cfg.buildSessionFactory();

	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}

	public static Session getSession(SessionFactory factory) {
		Session ses = null;
		if (factory != null) {
			ses = factory.openSession();
		}
		return ses;
	}

	public static void closeSessionFactory() {
		if (factory != null) {
			factory.close();
		}
	}

	public static void closeSession(Session ses) {
		if (ses != null) {
			ses.close();
		}
	}
}

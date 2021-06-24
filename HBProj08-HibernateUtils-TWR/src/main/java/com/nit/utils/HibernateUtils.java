package com.nit.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory;
	private static Session ses;

	static {
//		creating Configuration Object
		Configuration cfg = new Configuration();
		cfg.configure("/com/nit/cfgs/hibernate.cfg.xml");

//	creating SessionFactory Object
		factory = cfg.buildSessionFactory();

	}

	public static SessionFactory getSessionFactory() {
		if (factory != null) {
			return factory;
		} else {
			return null;
		}
	}

	public static Session getSession(SessionFactory factory) {
		if (factory != null) {
			ses = factory.openSession();
		}
		return ses;
	}

	public static void closeSession(Session ses) {
		if (ses != null) {
			ses.close();
		}
	}

	public static void closeSessionFactory() {
		if (factory != null) {
			factory.close();
		}
	}
}

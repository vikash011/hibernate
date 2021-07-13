package com.nit.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory;

	static {

		try {

			// creating StandardServiceRegistryBuilder Object
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();

			// creating StandardServiceRegistry object
			StandardServiceRegistry registry = builder.configure("/com/nit/cfgs/hibernate.cfg.xml").build();

			// creating Configuration object
			Configuration cfg = new Configuration();

			// creating SessionFactory Object
			factory = cfg.buildSessionFactory(registry);

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// static

	public static SessionFactory getSessionFactory() {

		if (factory != null) {
			return factory;
		} else {
			return null;
		}
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

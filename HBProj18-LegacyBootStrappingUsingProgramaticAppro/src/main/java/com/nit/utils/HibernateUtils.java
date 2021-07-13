package com.nit.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory;

	static {

		try {

			// Creating Configuration Object and Activating Hibernate
			Configuration cfg = new Configuration();

//		adding Properties
			cfg.setProperty("hibernate.connection.driver-class-name", "oracle.jdbc.driver.OracleDriver");
			cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1522:ORCL");
			cfg.setProperty("hibernate.connection.username", "hr");
			cfg.setProperty("hibernate.connection.password", "hr");
			cfg.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.Oracle10gDialect");
			cfg.setProperty("hibernate.connection.show_sql", "true");

			// adding Entity class mapping file
			cfg.addFile("src/main/java/com/nit/entity/Product.hbm.xml");

			// Create SessionFactory Object
			factory = cfg.buildSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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

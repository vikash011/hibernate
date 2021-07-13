package com.nit.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory;

	static {

		try {
			// Creating Properties File Object and Loading values

			Properties props = new Properties();
			InputStreamReader reader = new FileReader("src/main/java/com/nit/commons/info.properties");
			props.load(reader);

			// Creating Configuration Object
			Configuration cfg = new Configuration();

//			adding Properties File
			cfg.setProperties(props);
//			adding Entity class 
			cfg.addFile("src/main/java/com/nit/entity/Product.hbm.xml");

			// Create SessionFactory Object
			factory = cfg.buildSessionFactory();

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
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

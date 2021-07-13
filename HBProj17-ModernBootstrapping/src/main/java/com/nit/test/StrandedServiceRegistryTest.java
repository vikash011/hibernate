package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.nit.entity.Product;

public class StrandedServiceRegistryTest {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();

		// creating StandardServiceRegistrybuilder object
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();

		// creating StandardServiceRegistry
		StandardServiceRegistry registry = builder.configure("/com/nit/cfgs/hibernate.cfg.xml").build();

		// creating Session Factory Object
		SessionFactory factory = cfg.buildSessionFactory(registry);

		// Creating Session Object
		Session ses = factory.openSession();

		try {

			Product p1 = ses.get(Product.class, 100211);

			if (p1 == null) {
				System.out.println("No Record Found having ID");
			} else {
				System.out.println(p1);
			}

		} catch (HibernateException he) {
			he.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (ses != null) {
				ses.close();
			}

			if (factory != null) {
				factory.close();
			}
		}

	}

}

package com.nit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.nit.entity.Student;

public class HBTProj02_Anno_Test {

	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("com/nit/config/hiberante.cfg.xml")
				.build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		// inserting record

		Student s1 = new Student();
		s1.setId(1001);
		s1.setName("Ram");
		s1.setMarks(78.8);
		s1.setAddres("hyderabad");

		session.save(s1);

		// fetching record
		Student obj = session.find(Student.class, 1001);
		System.out.println(obj);
		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();

	}

}

package com.nit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.nit.entity.Employee;

public class HBProj01_Test {

	public static void main(String[] args) {


        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("com/nit/config/hibernate.cfg.xml").build();  
           Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
         
       SessionFactory factory = meta.getSessionFactoryBuilder().build();  
       Session session = factory.openSession();  
       Transaction t = session.beginTransaction();  
         
        Employee e1=new Employee();    
           e1.setEmpId(1002);    
           e1.setFirstName("Ramesh");    
           e1.setLastName("kumar");    
        
      session.save(e1);  
      t.commit();  
      System.out.println("successfully saved");    
       factory.close();  
       session.close();     
	}

}

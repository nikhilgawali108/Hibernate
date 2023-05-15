package com.hibernateonetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateOneToOneDemo {

	public static void main(String[] args) {
		 System.out.println( "Project has Started!!!" );
		 //creating the configuration
	        Configuration cfg=new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        
	        // building the session factory on the configuration
	        SessionFactory factory=cfg.buildSessionFactory();
	        
	        //creating department objects
	        Department d1=new Department();
	        d1.setDid(301);
	        d1.setDname("production");
	        
	        Department d2=new Department();
	        d2.setDid(302);
	        d2.setDname("pruchase");
	        
	        Department d3=new Department();
	        d3.setDid(303);
	        d3.setDname("sales");
	        
	        //creating Employee objects
	        Employee e1=new Employee();
	        e1.setEid(201);
	        e1.setEname("raghav");
	        e1.setDept(d2);
	        
	        Employee e2=new Employee();
	        e2.setEid(202);
	        e2.setEname("ashok");
	        e2.setDept(d3);
	        
	        
	        Employee e3=new Employee();
	        e3.setEid(203);
	        e3.setEname("raman");
	        e3.setDept(d1);
	        
	        // bidirectional
	        d1.setEmp(e3);
	        d2.setEmp(e1);
	        d3.setEmp(e2);
	        
	        Session s=factory.openSession();
	        Transaction tx=s.beginTransaction();
	         s.save(e1);
	         s.save(e2);
	         s.save(e3);
	         s.save(d1);
	         s.save(d2);
	         s.save(d3);
	         
	         tx.commit();
	         
	         // fetching the value from the database
	         
	         Employee e5= (Employee)s.get(Employee.class,202);
	         System.out.println(e5.getEid());
	         System.out.println(e5.getEname());
	         System.out.println(e5.getDept().getDname());
	        		 
	         s.close();
	         factory.close();

	}

}

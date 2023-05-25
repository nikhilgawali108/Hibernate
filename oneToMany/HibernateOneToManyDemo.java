package com.hibernateonetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateOneToManyDemo {

	public static void main(String[] args) {
		System.out.println("Project Started");
		 //creating the configuration
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        // building the session factory on the configuration
        SessionFactory factory=cfg.buildSessionFactory();
        
        
        //creating the project object
        Project p1=new Project();
        p1.setPid(101);
        p1.setPname("Hotel Mgmt System");
        
        
        //creating the employee object and associating it with the project
        Employee e1=new Employee();
        e1.setEid(401);
        e1.setEname("Deepak");
        e1.setProj(p1);
        
        Employee e2=new Employee();
        e2.setEid(402);
        e2.setEname("Hema");
        e2.setProj(p1);
        
        Employee e3=new Employee();
        e3.setEid(403);
        e3.setEname("Rashmi");   
        e3.setProj(p1);
        
        //creating a list of employees to associate with the project
        List<Employee> l1=new ArrayList<Employee>();
        l1.add(e1);
        l1.add(e2);
        l1.add(e3);
        
        //Associating the employees to the project
        p1.setEmp(l1);
        
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        
        s.save(p1);  //save the objects
        s.save(e1);
        s.save(e2);
        s.save(e3);
        
        tx.commit();//committing the transaction
        s.close();
        factory.close();
        
		}

}

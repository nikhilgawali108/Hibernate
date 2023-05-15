package com.hybernate.hyber_demo_proj;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project has Started!!!" );
        
        //creating the configuration
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        // building the session factory on the configuration
        SessionFactory factory=cfg.buildSessionFactory();
        
        //creating the object
        Student s1=new Student();
        s1.setSid(103);
        s1.setSname("Roshani");
        s1.setSage(18);
        
        //starting the session in the session factory
        Session session=factory.openSession();
        
        // starting the transaction
        Transaction tx=session.beginTransaction();
        
        // pushing the object in the session
        session.save(s1);
        
        //saving the transaction
        tx.commit();
        
        //closing the session and the factory
        session.close();
        factory.close();
        
    }
}

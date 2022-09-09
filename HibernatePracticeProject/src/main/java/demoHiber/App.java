package demoHiber;

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
        System.out.println( "Project Started...!" );
        
        //#1
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        //#2
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

//	CREATING SUDENT OBJECT
        Student st = new Student();
//  GIVING THE VALUES TO SAVE IN DATABASE      
        st.setId(102);
        st.setName("saurav");
        st.setCity("Mathura");
        System.out.println(st);
        
//  GETTING THE SESSION      
        Session session = factory.openSession();
//  START THE TRANSACTION AND SAVE IN tx VARIABLE      
        Transaction tx = session.beginTransaction();
//  SAVE THE OBJECT      
        session.save(st);
//  THEN COMMITED THE SESSION      
//        session.getTransaction().commit();
        tx.commit();
        
        session.close();
        
    }
}

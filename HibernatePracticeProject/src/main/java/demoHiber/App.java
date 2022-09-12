package demoHiber;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

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
    public static void main( String[] args ) throws IOException {
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
        st.setId(103);
        st.setName("Sachin Bhardwaj");
        st.setCity("Chandigarh");
        System.out.println(st);
        
        
        
//   CREATING OBJECT OF ADDRESS CLASS
        AddressEntity ad = new AddressEntity();
        ad.setStreet("Block 1 street");
        ad.setCity("Chandigarh");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.4);
        
        
//    READING IMAGE
/*      FileInputStream fis = new FileInputStream("src/main/java/pic.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data); */
        
        
        
        
        
//  GETTING THE SESSION      
        Session session = factory.openSession();
//  START THE TRANSACTION AND SAVE IN tx VARIABLE      
        Transaction tx = session.beginTransaction();
//  SAVE THE OBJECT      
        session.save(st);
        session.save(ad);
//  THEN COMMITED THE SESSION      
//        session.getTransaction().commit();
        tx.commit();
        
        session.close();
        System.out.println("Done...!");
        
    }
}

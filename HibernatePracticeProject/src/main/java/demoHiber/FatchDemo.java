package demoHiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FatchDemo {
	public static void main(String[] args) {
//	EXAMPLE OF GET AND LOAD
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Session session = factory.openSession();
//   USE LOAD METHOD
        Student student = session.load(Student.class, 102);
        System.out.println(student);
        AddressEntity ad1 = (AddressEntity)session.load(AddressEntity.class, 2);
        System.out.println(ad1.getAddressId()+" | "+ad1.getCity());
        
        
//   USE GET METHOD
        student = session.get(Student.class, 101);
        System.out.println(student);
        AddressEntity ad = (AddressEntity)session.get(AddressEntity.class, 2);
        System.out.println(ad.getCity() +" | "+ad.getStreet());
        
        
        session.close();
        factory.close();
	}
}

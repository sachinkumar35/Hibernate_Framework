package demoHiber;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbededApp {
	public static void main(String[] args) {
		
	
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory = cfg.buildSessionFactory();
	 
//	 ---------------------	    
	    StudentForEmbedableCertificate student1 = new StudentForEmbedableCertificate();
	    student1.setId(1234);
	    student1.setName("Sachin Kumar");
	    student1.setCity("Mathura");
	       
	    Certificate certificate = new Certificate();
	    certificate.setCourse("Android");
	    certificate.setDuration("2 Months");
	    
	    student1.setCerti(certificate);
//	 --------------------- 
	    StudentForEmbedableCertificate student2 = new StudentForEmbedableCertificate();
	    student2.setId(1235);
	    student2.setName("Mohit Bhardwaj");
	    student2.setCity("Chandigarh");
	    
	    Certificate certificate1 = new Certificate();
	    certificate1.setCourse("DevOps");
	    certificate1.setDuration("1 Months");
	    
	    student2.setCerti(certificate1);
	    
	    
	    
	    Session s = factory.openSession();
	    Transaction tx = s.beginTransaction();
	    
	    // object save
//	    s.save(student1);
	    s.save(student2);
	    
	    tx.commit();
	    s.close();
	    factory.close();
	    
		
	}
}

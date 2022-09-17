package firstCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demoHiber.Student;

public class FirstLevelDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
//	BY DEFAULT ENABLED
		Student student= session.get(Student.class, 103);
		System.out.println(student);
		
		System.out.println("Working something..");
		//again hitting this same quary to save object of query in cache
		Student student1= session.get(Student.class, 103);
		System.out.println(student1);
		//to check this student is in cache
		System.out.println(session.contains(student1));
		
		
		session.close();
		factory.close();
	}
}

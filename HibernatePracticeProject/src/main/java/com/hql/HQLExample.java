package com.hql;



import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demoHiber.Student;


public class HQLExample {
	public static void main(String[] args) {
		 	
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory = cfg.buildSessionFactory();
	    
	    Session s = factory.openSession();
	    
	    
	    //HQL
	    //Syntax:
	    
//	 HQL QUERIES    
//	    String query = "from Student"
//	    String query = "from Student where city='up'";
//	    String query = "from Student where city=:x";
	    String query = "from Student as s where city=:x and s.name=:n";
	    
	    
	    Query q = s.createQuery(query);
	    
	    q.setParameter("x", "chandigarh");
	    q.setParameter("n", "Sachin Bhardwaj");
	    
	    //Single result - (Unique)
	    
//	    List<Student> list1 = (List<Student>) q.uniqueResult();
//	    System.out.println(list);
	    
	    
	    //multiple result - (list)
	    List<Student> list = q.list();
	    
	    for(Student student: list)
	    	System.out.println(student.getName()+" : "+ student.getCity());
	    
//DELETE QUERY_____________________________________________________________________________________________________
	    
//	    Transaction tx = s.beginTransaction();
//	    
//	    System.out.println("_________________________________________________________________");
//	    
//	    Query q2= s.createQuery("delete from Student s where s.city=:c");
//	    q2.setParameter("c", "chandigarh");
//	    
//	    int r = q2.executeUpdate();
//	    System.out.println("Deleted....!");
//	    System.out.println(r);
	    
//UPDATE QUERY_____________________________________________________________________________________________________
	    	    
	    Transaction tx = s.beginTransaction();
	    Query q2 = s.createQuery("update Student set city=:c where name=:n");
	    q2.setParameter("c", "Gokul");
	    q2.setParameter("n", "Shyam");
	    int r = q2.executeUpdate();
	    System.out.println(r+"objects updated");
	    
	    tx.commit();
	    
//JOIN QUERY_____________________________________________________________________________________________________
	    
	    Query q3 = s.createQuery("Select q.question, q.questionId,a.answer from Question as q INNER JOIN q.answers as a");
	    List<Object []> list3 = q3.getResultList();
	    
	    for(Object[] arr: list3)
	    	System.out.println(Arrays.toString(arr));
	    
	    
	    s.close();
	    factory.close();
	}
}











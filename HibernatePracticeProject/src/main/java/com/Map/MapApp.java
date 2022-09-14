package com.Map;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class MapApp {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
       
// QUESTION 1        
        
//	CREATING QUESTION
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is java?");
    
//  CREATING ANSWER
        Answer ans = new Answer();
        ans.setAnswerId(343);
        ans.setAnswer("Java is a programming language");
        
      //here we are putting answer
        q1.setAnswer(ans);
      // question setting
        ans.setQuestion(q1);
        
// QUESTION 2
        //creating question
        Question q2 = new Question();
        q2.setQuestionId(242);
        q2.setQuestion("What is collection framewor?");
        //creating answer
        Answer ans1 = new Answer();
        ans1.setAnswerId(344);
        ans1.setAnswer("API to work with objects in java");
      //here we are putting answer
        q2.setAnswer(ans1);
     // question setting
        ans1.setQuestion(q2);  
        
        
        
        
//  To save object in database we have to create session
        Session s = factory.openSession();
        
        Transaction tx = s.beginTransaction();
        
        //save
        s.save(q1);
        s.save(q2);
        s.save(ans);
        s.save(ans1);
        
        tx.commit();
        
        //fetching data
        Question newQ =(Question)s.get(Question.class, 1212);
        System.out.println(newQ.getQuestion());
        System.out.println(newQ.getAnswer().getAnswer());
        
        
        s.close();
        
        factory.close();

	}

}

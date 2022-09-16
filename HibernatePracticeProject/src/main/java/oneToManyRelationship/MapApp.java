package oneToManyRelationship;

import java.util.ArrayList;
import java.util.List;

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
        //ANS1
        Answer ans = new Answer();
        ans.setAnswerId(343);
        ans.setAnswer("Java is a programming language");
        ans.setQuestion(q1);
        
        //ANS2
        Answer ans1 = new Answer();
        ans1.setAnswerId(323);
        ans1.setAnswer("Java use oops concept");
        ans1.setQuestion(q1);
        
      //ANS3
        Answer ans2 = new Answer();
        ans2.setAnswerId(303);
        ans2.setAnswer("Java has diffrent types of framework");
        ans2.setQuestion(q1);
        
        
        List<Answer> list = new ArrayList<Answer>();
        list.add(ans);
        list.add(ans1);
        list.add(ans2);
        
        q1.setAnswers(list);
        
        
//  To save object in database we have to create session
        Session s = factory.openSession();
        
        Transaction tx = s.beginTransaction();
        
        //save
        s.save(q1);
        s.save(ans);
        s.save(ans1);
        s.save(ans2);
        
        tx.commit();
        
        //fetching data
        Question newQ =(Question)s.get(Question.class, 1212);
        System.out.println(newQ.getQuestion());
        for(Answer a : newQ.getAnswers())
        	System.out.println(a.getAnswer());
        
        
        s.close();
        
        factory.close();

	}

}

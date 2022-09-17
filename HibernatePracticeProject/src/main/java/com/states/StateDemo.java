package com.states;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		
		//Practical of Hibernate Object States;
		//1. Transient
		//2. Persistent
		//3. Detached 
		//4. Removed
		
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		
		
		
		f.close();

	}

}

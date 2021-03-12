package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		
		System.out.println("Creating 3 student objects");
		Student tempStudent1 = new Student("Sunny","Paul","sunnypaul@gmail.com");
		Student tempStudent2 = new Student("KRanthi","k","skk@gmail.com");
		Student tempStudent3 = new Student("Rocky","Malhotra","rocky@gmail.com");
		
		session.beginTransaction();
		
		System.out.println("Saving the student..");
		session.save(tempStudent1);
		session.save(tempStudent2);
		session.save(tempStudent3);
		
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
		
		}
		finally {
		factory.close();
		}

	}

}

package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			session = factory.getCurrentSession();
		
			session.beginTransaction();
		
			System.out.println("Getting student based on id" +studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student \n");
			
			myStudent.setFirstName("James");
			
			session.getTransaction().commit();
			
			System.out.println("Done updating student number one!!");
			
			//NEW CODE
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
		
			System.out.println("Updating emails of all students" +studentId);
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate(); 
			
			System.out.println("Updating mails  \n");
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
	}

}

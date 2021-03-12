package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating new student object");
			Student tempStudent = new Student("Rober","Borussa","rbmontreal@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student..");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			System.out.println("Committing after Saving");
			session.getTransaction().commit();
			
			
			
	// Getting the object using ID (Primary key)
			
			//Create a new session because the session is finished after committing it
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("\n Getting the newly created student with ID" +tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Printing the new student by retrieveing with Student ID" +myStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
			
		}
		finally {
			factory.close();
		}
	}

}

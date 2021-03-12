package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			//querying
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			System.out.println("\nDisplaying all students list");
			//refactored this for loop- > check the method at foot
			displayStudents(theStudents);
			
			
			System.out.println("\n \n Printing students whose last name is k");
			//displaying students with last name k
			theStudents = session.createQuery("from Student s where s.lastName='k' ").getResultList();
			displayStudents(theStudents);
			
			
			System.out.println("\n \n Printing students whose first name is Rocky or last name is k");
			//displaying students with last name k or first name is rocky
			theStudents = session.createQuery("from Student s where" 
			+  " s.firstName='Rocky' OR s.lastName='k' ").getResultList();
			displayStudents(theStudents);
			
			System.out.println("\n \n Printing students whose email like @gmail");
			//displaying students with mail ending with luv2code.com
			theStudents = session.createQuery("from Student s where s.email LIKE '%@gmail.com' ").getResultList();
			displayStudents(theStudents);
			
			
			//committing
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
			
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println("Printing the student" +tempStudent);	
		}
	}

}

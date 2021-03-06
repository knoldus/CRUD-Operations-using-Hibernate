package com.knoldus.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.knoldus.hibernate.demo.entity.Student;

public class DeleteStudentDemo1 {

	
			public static void main(String[] args) {
				
			
				//create session factory
				
				SessionFactory factory = new Configuration()
						                 .configure("hibernate.cfg.xml")
				                          .addAnnotatedClass(Student.class)
				                          .buildSessionFactory();
				
				//create session
				
				Session session = factory.getCurrentSession();
				
				try {
					
					
					int studentId =1;
					
					
					
					//now get a new session and start transaction	
					 session = factory.getCurrentSession(); 
					    session.beginTransaction();
					    
					    
					
				    // retrive student based on the id: primary key
					    
					    System.out.println("\nGetting student with id: "+ studentId);
					    
					    Student myStudent = session.get(Student.class, studentId);
					    
					    //delete the student
					    System.out.println("Deleting student: "+ myStudent);
					    session.delete(myStudent);
					   
					
					// commit the transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					
					
					
				} 
				finally {
					
					factory.close();

				}
				
				

			}

	
}

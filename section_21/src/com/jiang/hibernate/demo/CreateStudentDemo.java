/*
 * This is an example to show the procedure of creating objects 
 * and store those objects into MySQL DB with Hibernate.
 * 
 * @Author
 * Yuming Jiang
 */

package com.jiang.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jiang.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student tmp_student = new Student("Yuming", "Jiang", "cjcjiang@gmail.com");
			session.beginTransaction();
			session.save(tmp_student);
			session.getTransaction().commit();
			
			// Show the ID that is automatically generated by Hibernate
			System.out.println(tmp_student.getId());
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}

package funix.huutt.jdbc.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import funix.huutt.jdbc.demo.entity.Instructor;
import funix.huutt.jdbc.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								  .configure("hibernate.cfg.xml")
								  .addAnnotatedClass(Instructor.class)
								  .addAnnotatedClass(InstructorDetail.class)
								  .buildSessionFactory();;
				
		try {	
			

			// create session
			Session session = factory.getCurrentSession();
			
			// create the objects
			Instructor tempInstructor = 
					new Instructor("Hữu", "Từ", "huuttfx57728@funix.edu.vn");
			
			System.out.println(tempInstructor);
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.huuttfx.hitgub.com",
							"Hữu love code"
							);
			
			System.out.println(tempInstructorDetail);
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			
			//
			// Node: this will ALSO save the detail object because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

}

package net.ug.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DaoBook {
	protected SessionFactory sessionFactory;
	
	protected void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()  //lee los settings del archivo hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry)
					.buildMetadata().buildSessionFactory();			
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		
	}
	
	protected void crear(Book book) {
		Session s =  sessionFactory.openSession();
		s.beginTransaction();
		s.save(book);
		s.getTransaction().commit();
		s.close();
	}
	
	protected Book read(long bookID) {
		Session s =  sessionFactory.openSession();
		Book book = s.get(Book.class, bookID);
		s.close();
		return book;
	}
	
	protected void update(Book book) {
		Session s =  sessionFactory.openSession();
		s.beginTransaction();
		s.update(book);
		s.getTransaction().commit();
		s.close();
	}
	
	
	protected void delete(int bookID) {
		Session s =  sessionFactory.openSession();
		s.beginTransaction();
		Book book = new Book();
		book.setId(bookID);
		s.delete(book);
		s.getTransaction().commit();
		s.close();
	}

}

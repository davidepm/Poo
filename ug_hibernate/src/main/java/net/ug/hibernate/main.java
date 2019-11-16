package net.ug.hibernate;

public class main {
	
	
	public static void main(String[] args) {
		crear();
		read();
		update();
		delete();
	}
	
	public static void crear() {
		DaoBook daoBook = new DaoBook();
		Book book = new Book(1,"Hibernate","Maria Perez",80);		
		daoBook.setup();
		daoBook.crear(book);
		book = new Book(1,"Android","Maria Perez",80);
		daoBook.crear(book);		
	}
	
	public static void read() {
		DaoBook daoBook = new DaoBook();
		daoBook.setup();
		Book book = daoBook.read(1);
		book.imprimir();
	}

	public static void update() {

		DaoBook daoBook = new DaoBook();
		daoBook.setup();
		Book book = daoBook.read(1);
		book.setTitle("Historia del Ecuador");
		daoBook.update(book);
	}
	
	public static void delete() {
		DaoBook daoBook = new DaoBook();
		daoBook.setup();
		daoBook.delete(1);
		daoBook.delete(2);
	}
}

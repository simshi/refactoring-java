package com.simshi.rentalStore;

public class Main {
	public static void main(String[] args){
		System.out.println("Hello World!"); 

		Movie m1 = new Movie("star trek 1", Movie.REGULAR);
		Movie m2 = new Movie("star trek 11", Movie.NEW_RELEASE);
		Movie m3 = new Movie("xyy", Movie.CHILDRENS);
		Movie m4 = new Movie("Transferman 3", Movie.NEW_RELEASE);
		
		Customer c = new Customer("bb");
		c.addRental(new Rental(m1, 3));
		c.addRental(new Rental(m2, 4));
		c.addRental(new Rental(m3, 5));
		c.addRental(new Rental(m4, 6));
		System.out.print(c.statement());
		System.out.print(c.htmlStatement());
	}

}

package com.simshi.rentalStore;

abstract class Price {
	abstract int getPriceCode();
	abstract double getCharge(int daysRented);
}

class ChildrensPrice extends Price {
	int getPriceCode() {
		return Movie.CHILDRENS;
	}

	double getCharge(int daysRented) {
		double result = 1.5;
		if (daysRented > 3)
			result += (daysRented - 3) * 1.5;
		return result;
	}
}

class NewReleasePrice extends Price {
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	double getCharge(int daysRented) {
		return daysRented * 3;
	}
}

class RegularPrice extends Price {
	int getPriceCode() {
		return Movie.REGULAR;
	}

	double getCharge(int daysRented) {
		double result = 2;
		if (daysRented > 2)
			result += (daysRented - 2) * 1.5;
		return result;
	}
}

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private Price _price;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR:
			_price = new RegularPrice();
			break;
		case CHILDRENS:
			_price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public String getTitle() {
		return _title;
	};

	double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}

	int getFrequentRenterPoints(int daysRented) {
		if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
			return 2;
		else
			return 1;
	}
}

package com.simshi.rentalStore;

abstract class Price {
	abstract double getCharge(int daysRented);

	int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}

class ChildrensPrice extends Price {
	double getCharge(int daysRented) {
		double result = 1.5;
		if (daysRented > 3)
			result += (daysRented - 3) * 1.5;
		return result;
	}
}

class NewReleasePrice extends Price {
	double getCharge(int daysRented) {
		return daysRented * 3;
	}
}

class RegularPrice extends Price {
	double getCharge(int daysRented) {
		double result = 2;
		if (daysRented > 2)
			result += (daysRented - 2) * 1.5;
		return result;
	}

	int getFrequentRenterPoints(int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}
}

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private static final Price _regularPrice = new RegularPrice();
	private static final Price _childrensPrice = new ChildrensPrice();
	private static final Price _newReleasePrice = new NewReleasePrice();
	private String _title;
	private Price _price;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	private void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR:
			_price = _regularPrice;
			break;
		case CHILDRENS:
			_price = _childrensPrice;
			break;
		case NEW_RELEASE:
			_price = _newReleasePrice;
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public String getTitle() {
		return _title;
	};

	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return _price.getFrequentRenterPoints(daysRented);
	}
}

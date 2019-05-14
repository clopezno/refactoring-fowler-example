package ubu.gii.dass.refactoring;

public class NewRelease extends MovieType {

	@Override
	public int getTypeCode() {
		return MovieType.NEW_RELEASE;
	}

	@Override
	public int getFrecuentRenterPoints(Rental rental) {
		// initialize as 1
		int frecuentRenterPoints = 1;

		// if days rented is greater than 1, we add another one
		if (rental.getDaysRented() > 1)
			frecuentRenterPoints++;

		return frecuentRenterPoints;
	}

	@Override
	public double getCharge(Rental rental) {
		return rental.getDaysRented() * 3;
	}
}

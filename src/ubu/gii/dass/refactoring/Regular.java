package ubu.gii.dass.refactoring;

public class Regular extends MovieType {

	@Override
	public int getTypeCode() {
		return MovieType.REGULAR;
	}

	@Override
	public double getCharge(Rental rental) {
		double result = 2;
		if (rental.getDaysRented() > 2)
			result += (rental.getDaysRented() - 2) * 1.5;

		return result;
	}

}

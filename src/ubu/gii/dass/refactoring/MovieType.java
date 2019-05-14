package ubu.gii.dass.refactoring;

public abstract class MovieType {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	public MovieType() {
		super();
	}

	public abstract int getTypeCode();

	public abstract double getCharge(Rental rental);

	public int getFrecuentRenterPoints(Rental rental) {
		return 1;
	}
}
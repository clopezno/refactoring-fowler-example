package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};
	
	public String htmlStatement() {
        String result = "<h1>Rental Record for " + getName() + "</h1>\n";
        result += "<table border='1'>\n";
        result += "<tr><th>Movie Title</th><th>Amount</th></tr>\n";

        for (Rental rental : _rentals) {
            result += "<tr><td>" + rental.getMovie().getTitle() + "</td><td>" + String.valueOf(calculateAmount(rental)) + "</td></tr>\n";
        }

        result += "</table>\n";
        result += "<p>Amount owed is <strong>" + String.valueOf(totalAmount()) + "</strong></p>\n";
        result += "<p>You earned <strong>" + String.valueOf(totalFrecuentRenterPoints()) + "</strong> frequent renter points</p>";
        return result;
    }
	
	public String statement() {	
		
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {			
			Rental rental = rentals.next();			
			
			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t"
					+ String.valueOf(calculateAmount(rental)) + "\n";
			
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount()) + "\n";
		result += "You earned " + String.valueOf(totalFrecuentRenterPoints())
				+ " frequent renter points";
		return result;
	}

	private int totalFrecuentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental rental : _rentals) {
			frequentRenterPoints = calculateFrequentRenterPoints(frequentRenterPoints, rental);
		}
		return frequentRenterPoints;
	}

	private double totalAmount() {
		double totalAmount = 0;
		for (Rental rental : _rentals) {
			// determine amounts for each line
			totalAmount += calculateAmount(rental);			 
		}
		return totalAmount;
	}

	private int calculateFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
		// add frequent renter points
		frequentRenterPoints++;
		// add bonus for a two day new release rental
		if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
				&& rental.getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

	private double calculateAmount(Rental rental) {
		double thisAmount = 0;
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount = regularAmount(rental, thisAmount);
			break;
		case Movie.NEW_RELEASE:
			thisAmount = newreleaseAmount(rental, thisAmount);
			break;
		case Movie.CHILDRENS:
			thisAmount = childrensAmount(rental, thisAmount);
			break;
		}
		return thisAmount;
	}

	private double childrensAmount(Rental rental, double thisAmount) {
		thisAmount += 1.5;
		if (rental.getDaysRented() > 3)
			thisAmount += (rental.getDaysRented() - 3) * 1.5;
		return thisAmount;
	}

	private double newreleaseAmount(Rental rental, double thisAmount) {
		thisAmount += rental.getDaysRented() * 3;
		return thisAmount;
	}

	private double regularAmount(Rental rental, double thisAmount) {
		thisAmount += 2;
		if (rental.getDaysRented() > 2)
			thisAmount += (rental.getDaysRented() - 2) * 1.5;
		return thisAmount;
	}
}


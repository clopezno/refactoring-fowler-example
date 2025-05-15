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
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

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

	public String statement() {
	    double totalAmount = 0;
	    int frequentRenterPoints = 0;
	    Iterator<Rental> rentals = _rentals.iterator();
	    String result = "Rental Record for " + getName() + "\n";
	    StringBuilder htmlContent = new StringBuilder();

	    htmlContent.append("<html><head><title>Rental Report</title></head><body>");
	    htmlContent.append("<h1>Rental Record for " + getName() + "</h1><ul>");

	    while (rentals.hasNext()) {
	        double thisAmount = 0;
	        Rental each = rentals.next();
	        // determine amounts for each line
	        thisAmount = each.getCharge();

	        // add frequent renter points
	        frequentRenterPoints = updatePoints(frequentRenterPoints, each);

	        // show figures for this rental
	        result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
	        totalAmount += thisAmount;

	        // add to HTML content
	        htmlContent.append("<li>" + each.getMovie().getTitle() + " - " + thisAmount + "</li>");
	    }

	    // add footer lines
	    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
	    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

	    // add to HTML content
	    htmlContent.append("</ul><p>Amount owed is " + totalAmount + "</p>");
	    htmlContent.append("<p>You earned " + frequentRenterPoints + " frequent renter points</p>");
	    htmlContent.append("</body></html>");

	    // Write the HTML content to a file
	    try (FileWriter writer = new FileWriter("informe.html")) {
	        writer.write(htmlContent.toString());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return result;
	}
	

	private int updatePoints(int frequentRenterPoints, Rental each) {
		return each.getMovie().getUpdatePoints(frequentRenterPoints);
	}
}

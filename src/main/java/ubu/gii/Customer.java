package ubu.gii;

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
    private List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String htmlStatement() {
        return generateStatement(new HtmlStatementFormatter());
    }

    public String statement() {
        return generateStatement(new TextStatementFormatter());
    }

    private String generateStatement(StatementFormatter formatter) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = _rentals.iterator();
        StringBuilder result = new StringBuilder(formatter.header(getName()));

        while (rentals.hasNext()) {
            Rental each = rentals.next();
            double thisAmount = each.getCharge();
            frequentRenterPoints += each.getFrequentRenterPoints();
            result.append(formatter.lineItem(each.getMovie().getTitle(), thisAmount));
            totalAmount += thisAmount;
        }

        result.append(formatter.footer(totalAmount, frequentRenterPoints));
        return result.toString();
    }
}

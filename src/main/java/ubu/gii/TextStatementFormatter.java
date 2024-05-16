package ubu.gii;

public class TextStatementFormatter implements StatementFormatter {
    public String header(String customerName) {
        return "Rental Record for " + customerName + "\n";
    }

    public String lineItem(String movieTitle, double amount) {
        return "\t" + movieTitle + "\t" + String.valueOf(amount) + "\n";
    }

    public String footer(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + String.valueOf(totalAmount) + "\n"
             + "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
    }
}
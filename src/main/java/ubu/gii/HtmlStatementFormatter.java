package ubu.gii;

public class HtmlStatementFormatter implements StatementFormatter {
    public String header(String customerName) {
        return "<H1>Rental Record for " + customerName + "</H1>\n";
    }

    public String lineItem(String movieTitle, double amount) {
        return "<H2>" + movieTitle + " " + String.valueOf(amount) + "</H2>\n";
    }

    public String footer(double totalAmount, int frequentRenterPoints) {
        return "<P>Amount owed is " + String.valueOf(totalAmount) + "</P>\n"
             + "<P>You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points</P>\n";
    }
}

package ubu.gii;

interface StatementFormatter {
        String header(String customerName);
        String lineItem(String movieTitle, double amount);
        String footer(double totalAmount, int frequentRenterPoints);
    }
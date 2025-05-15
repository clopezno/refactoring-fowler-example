package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private Price _price;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public Price getPriceCode() {
		return _price;
	}

	public void setPriceCode(int priceCode) {
		switch (priceCode) {
			case REGULAR:
				_price = new RegularPrice();
				break;
			case NEW_RELEASE:
				_price = new NewReleasePrice();
				break;
			case CHILDRENS:
				_price = new ChildrensPrice();
				break;
		
		}
	}

	public Double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}
	
    public int getUpdatePoints(int daysRented) {
    	return _price.getUpdatePoints(daysRented);
    }

	public String getTitle() {
		return _title;
	}
}

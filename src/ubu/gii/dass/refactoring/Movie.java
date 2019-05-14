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

public class Movie extends MovieType {
	private String _title;
	private int _priceCode;
	private MovieType _movieType;

	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
		switch (arg) {
		case MovieType.CHILDRENS:
			_movieType = new Children();
			break;
		case MovieType.NEW_RELEASE:
			_movieType = new NewRelease();
			break;
		case MovieType.REGULAR:
			_movieType = new Regular();
			break;
		default:
			_movieType = null;
		}
	}

	public String getTitle() {
		return _title;
	}

	@Override
	public int getTypeCode() {
		return this._movieType.getTypeCode();
	}
}

package ubu.gii.dass.refactoring;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.1
 * 
 * 
 */
public class VideoClubTest {
	protected Movie m0, m11, m12, m2;
	protected Customer c1;

	@Before
	public void setUp() {
		m11 = new Movie("Sky Captain", 1);
		m12 = new Movie("Alejandro Magno", 1);
		m0 = new Movie("Accion Mutante", 0);
		m2 = new Movie("Hermano Oso", 2);

		c1 = new Customer("Manuel");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAlquiler() {

		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m0, 1);
		Rental r3 = new Rental(m2, 10);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);

		String salida = c1.statement();

		String salidaEsperada = new String(
				"Rental Record for Manuel\n" + "\tSky Captain\t15.0\n" + "\tAccion Mutante\t2.0\n"
						+ "\tHermano Oso\t12.0\n" + "Amount owed is 29.0\n" + "You earned 4 frequent renter points");

		assertTrue("Calcula mal el alquiler", salidaEsperada.equals(salida));
	}

	@Test
	public void testAlquilerHTML() {

		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m0, 1);
		Rental r3 = new Rental(m2, 10);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);

		String salida = c1.htmlStatement();

		String salidaEsperada = new String("<h1>Rental Record for Manuel</h1>" + "<h2>Sky Captain 15.0</h2>"
				+ "<h2>Accion Mutante 2.0</h2>" + "<h2>Hermano Oso 12.0</h2>" + "<p>Amount owed is 29.0</p>"
				+ "<p>You earned 4 frequent renter points</p>");

		assertTrue("Calcula mal el alquiler", salidaEsperada.equals(salida));
	}
}

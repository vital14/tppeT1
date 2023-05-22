package tests;

import main.Author;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AuthorTest {
	private Author authorComplete;
	private Author authorWithoutIdentifier;
	private Author authorWithOneIdentifier;

	@Before
	public void setup() {
		authorComplete = new Author("Brasileira", "Brasil", "Brasília", "DF",
						"3232323", "323243223");
		authorWithoutIdentifier = new Author("Brasileira", "Brasil", "Brasília", "DF",
				null, null);
		authorWithOneIdentifier = new Author("Brasileira", "Brasil", "Brasília", "DF",
				null, "3232323");
	};


	// TESTE OR EXCLUSIVO
	// METODO ADICIONADO NO COMMIT ANTERIOR
	@Test
	public void testOrExclusivoCompleto() {
		assertTrue(authorComplete.checkExclusiveOrFields());
	}

}

package tests;

 import main.Author;
 import org.junit.Before;
 import org.junit.Test;

 import static org.junit.Assert.assertEquals;

 public class AuthorMultiTest {
 	private Author authorIncomplete;
 	private Author authorWithoutIdentifier;
 	private Author authorWithOneIdentifier;

 	@Before
 	public void setup() {
 		authorIncomplete = new Author(null, null, null, null, "3232323", "323243223");
 		authorWithoutIdentifier = new Author("Brasileira", "Brasil", "Brasília", "DF",
 				null, null);
 		authorWithOneIdentifier = new Author("Brasileira", "Brasil", "Brasília", "DF",
 				null, "3232323");
 	};


 	// TESTE MULTI CAMPOS
 	@Test
 	public void testMultiFieldsEmpty() {
 		assertEquals(authorIncomplete.checkCompletenessMultiField(), 0f, 0f);
 	}
 	
 	@Test
 	public void testMultiFieldsComplete() {
 		assertEquals(authorWithOneIdentifier.checkCompletenessMultiField(), 1f, 0f);
 	}
 }
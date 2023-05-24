package tests;

import main.Author;
import main.InvalidCharacterException;
import org.junit.Test;

public class ExceptionTest {

    @Test(expected = InvalidCharacterException.class)
    public void testInvalidCharacterException() throws InvalidCharacterException {
        String nationality = "Brasileira";
        String birthCountry = "Brasil";
        String birthCity = "Brasilia";
        String birthState = "DF";
        String invalidIdentifierLattes = "123abc";
        String invalidIdentifierOrcId = "xyz456";

        Author author = new Author(nationality, birthCountry, birthCity, birthState, invalidIdentifierLattes,
                invalidIdentifierOrcId);
    }

    @Test(expected = InvalidCharacterException.class)
    public void testInvalidNumberException() throws InvalidCharacterException {
        String invalidNationality = "Brasileira1";
        String birthCountry = "Brasil";
        String birthCity = "Brasilia";
        String birthState = "DF";
        String IdentifierLattes = "89273823";
        String IdentifierOrcId = "23232";

        Author author = new Author(invalidNationality, birthCountry, birthCity, birthState, IdentifierLattes,
                IdentifierOrcId);
    }
}

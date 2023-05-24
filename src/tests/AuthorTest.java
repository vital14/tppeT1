package tests;

import main.Author;
import main.InvalidCharacterException;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AuthorTest {

	private Author author;
	private boolean resultExpected;
	private boolean resultExpectedOrInclusive;
	private float resultMultiFields;

	public AuthorTest(HashMap<String, Object> data) throws InvalidCharacterException {
		this.author = new Author((String) data.get("nationality"), (String) data.get("birthCountry"),
				(String) data.get("birthCity"), (String) data.get("birthState"), (String) data.get("identifierLattes"),
				(String) data.get("identifierOrcId"));
		this.resultExpected = (boolean) data.get("result");
		this.resultExpectedOrInclusive = (boolean) data.get("resultOrInclusive");
		this.resultMultiFields = (float) data.get("completeness");
	}

	@Parameters
	public static List<HashMap<String, Object>> getParameters() {
		List<HashMap<String, Object>> parameters = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> authorComplete = new HashMap<String, Object>();

		authorComplete.put("nationality", "Brasileira");
		authorComplete.put("birthCountry", "Brasil");
		authorComplete.put("birthCity", "Brasília");
		authorComplete.put("birthState", "DF");
		authorComplete.put("identifierLattes", "89273823");
		authorComplete.put("identifierOrcId", "23232");
		authorComplete.put("result", false);
		authorComplete.put("resultOrInclusive", true);
		authorComplete.put("completeness", 0.5f);

		parameters.add(authorComplete);

		HashMap<String, Object> authorWithOnlyOneIdentifier = new HashMap<String, Object>();

		authorWithOnlyOneIdentifier.put("identifierLattes", "89273823");
		authorWithOnlyOneIdentifier.put("result", true);
		authorWithOnlyOneIdentifier.put("resultOrInclusive", false);
		authorWithOnlyOneIdentifier.put("completeness", 0.5f);

		parameters.add(authorWithOnlyOneIdentifier);

		HashMap<String, Object> authorWithoutNationalityAndOneIdentifier = new HashMap<String, Object>();

		authorWithoutNationalityAndOneIdentifier.put("birthCountry", "Brasil");
		authorWithoutNationalityAndOneIdentifier.put("birthCity", "Brasília");
		authorWithoutNationalityAndOneIdentifier.put("birthState", "DF");
		authorWithoutNationalityAndOneIdentifier.put("identifierLattes", "89273823");
		authorWithoutNationalityAndOneIdentifier.put("result", true);
		authorWithoutNationalityAndOneIdentifier.put("resultOrInclusive", true);
		authorWithoutNationalityAndOneIdentifier.put("completeness", 1f);

		parameters.add(authorWithoutNationalityAndOneIdentifier);

		HashMap<String, Object> emptyAuthor = new HashMap<String, Object>();

		emptyAuthor.put("result", false);
		emptyAuthor.put("resultOrInclusive", false);
		emptyAuthor.put("completeness", 0f);

		parameters.add(emptyAuthor);

		return parameters;
	}

	@Test
	public void testOrExclusivo() {
		assertEquals(author.checkExclusiveOrFields(), resultExpected);
	}

	@Test
	public void testOrInclusivo() {
		assertEquals(author.checkInclusiveOrFields(), resultExpectedOrInclusive);
	}

	@Test
	public void testMultiFields() {
		assertEquals(author.checkCompletenessMultiField(), resultMultiFields, 0f);
	}
}

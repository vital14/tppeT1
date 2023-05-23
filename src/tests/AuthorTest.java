package tests;

import main.Author;

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
	
	public AuthorTest(HashMap<String, Object> data) {
		this.author = new Author((String)data.get("nationality"), (String)data.get("birthCountry"), (String)data.get("birthCity"), (String)data.get("birthState"), (String)data.get("identifierLattes"), (String)data.get("identifierOrcId"));
		this.resultExpected = (boolean)data.get("result");
		this.resultExpectedOrInclusive = (boolean)data.get("resultOrInclusive");
	}
	
	@Parameters
    public static List<HashMap<String, Object>> getParameters() {
		List<HashMap<String, Object>> parameters = new ArrayList<HashMap<String, Object>>() ;
		
		HashMap<String, Object> authorComplete = new HashMap<String, Object>();
		
		authorComplete.put("nationality", "Brasileira");
		authorComplete.put("birthCountry", "Brasil");
		authorComplete.put("birthCity", "Brasília");
		authorComplete.put("birthState", "DF");
		authorComplete.put("identifierLattes", "89273823");
		authorComplete.put("identifierOrcId", "23232");
		authorComplete.put("result", false);
		authorComplete.put("resultOrInclusive", true);

		
		parameters.add(authorComplete);
		
		HashMap<String, Object> authorWithoutIdentifierAndNationality = new HashMap<String, Object>();
		
		authorWithoutIdentifierAndNationality.put("birthCountry", "Brasil");
		authorWithoutIdentifierAndNationality.put("birthCity", "Brasília");
		authorWithoutIdentifierAndNationality.put("birthState", "DF");
		authorWithoutIdentifierAndNationality.put("result", false);
		authorWithoutIdentifierAndNationality.put("resultOrInclusive", true);
		
		parameters.add(authorWithoutIdentifierAndNationality);

		HashMap<String, Object> authorWithOnlyOneIdentifier = new HashMap<String, Object>();
		
		authorWithOnlyOneIdentifier.put("identifierLattes", "89273823");
		authorWithOnlyOneIdentifier.put("result", true);
		authorWithOnlyOneIdentifier.put("resultOrInclusive", false);
		
		parameters.add(authorWithOnlyOneIdentifier);
		
		HashMap<String, Object> authorWithoutNationality = new HashMap<String, Object>();
		
		authorWithoutNationality.put("birthCountry", "Brasil");
		authorWithoutNationality.put("birthCity", "Brasília");
		authorWithoutNationality.put("birthState", "DF");
		authorWithoutNationality.put("identifierLattes", "89273823");
		authorWithoutNationality.put("identifierOrcId", "23232");
		authorWithoutNationality.put("result", false);
		authorWithoutNationality.put("resultOrInclusive", true);
		
		parameters.add(authorWithoutNationality);
		
		
		
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
}

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
	
	public AuthorTest(HashMap<String, Object> data) {
		this.author = new Author((String)data.get("nationality"), (String)data.get("birthCountry"), (String)data.get("birthCity"), (String)data.get("birthState"), (String)data.get("identifierLattes"), (String)data.get("identifierOrcId"));
		this.resultExpected = (boolean)data.get("result");
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
		
		parameters.add(authorComplete);
		
		HashMap<String, Object> authorWithoutIdentifier = new HashMap<String, Object>();
		
		authorWithoutIdentifier.put("nationality", "Brasileira");
		authorWithoutIdentifier.put("birthCountry", "Brasil");
		authorWithoutIdentifier.put("birthCity", "Brasília");
		authorWithoutIdentifier.put("birthState", "DF");
		authorWithoutIdentifier.put("result", false);
		
		parameters.add(authorWithoutIdentifier);

		HashMap<String, Object> authorWithOneIdentifier = new HashMap<String, Object>();
		
		authorWithOneIdentifier.put("nationality", "Brasileira");
		authorWithOneIdentifier.put("birthCountry", "Brasil");
		authorWithOneIdentifier.put("birthCity", "Brasília");
		authorWithOneIdentifier.put("birthState", "DF");
		authorWithOneIdentifier.put("identifierLattes", "89273823");
		authorWithOneIdentifier.put("result", true);
		
		parameters.add(authorWithOneIdentifier);
		
		HashMap<String, Object> authorWithoutNationality = new HashMap<String, Object>();
		
		authorWithoutNationality.put("birthCountry", "Brasil");
		authorWithoutNationality.put("birthCity", "Brasília");
		authorWithoutNationality.put("birthState", "DF");
		authorWithoutNationality.put("identifierLattes", "89273823");
		authorWithoutNationality.put("identifierOrcId", "23232");
		authorWithoutNationality.put("result", true);
		
		parameters.add(authorWithoutNationality);
		
		HashMap<String, Object> authorWithoutBirthCountry = new HashMap<String, Object>();
		
		authorWithoutBirthCountry.put("nationality", "Brasileira");
		authorWithoutBirthCountry.put("birthCity", "Brasília");
		authorWithoutBirthCountry.put("birthState", "DF");
		authorWithoutBirthCountry.put("identifierLattes", "89273823");
		authorWithoutBirthCountry.put("identifierOrcId", "23232");
		authorWithoutBirthCountry.put("result", true);
		
		parameters.add(authorWithoutBirthCountry);
		
		HashMap<String, Object> authorWithoutBirthCity = new HashMap<String, Object>();
		
		authorWithoutBirthCity.put("nationality", "Brasileira");
		authorWithoutBirthCity.put("birthCountry", "Brasil");
		authorWithoutBirthCity.put("birthState", "DF");
		authorWithoutBirthCity.put("identifierLattes", "89273823");
		authorWithoutBirthCity.put("identifierOrcId", "23232");
		authorWithoutBirthCity.put("result", true);
		
		parameters.add(authorWithoutBirthCity);
		
		HashMap<String, Object> authorWithoutBirthState = new HashMap<String, Object>();
		
		authorWithoutBirthState.put("nationality", "Brasileira");
		authorWithoutBirthState.put("birthCountry", "Brasil");
		authorWithoutBirthState.put("birthCity", "Brasília");
		authorWithoutBirthState.put("identifierLattes", "89273823");
		authorWithoutBirthState.put("identifierOrcId", "23232");
		authorWithoutBirthState.put("result", true);
		
		parameters.add(authorWithoutBirthState);
		
		HashMap<String, Object> authorWithoutOrInclusive = new HashMap<String, Object>();
		

		authorWithoutOrInclusive.put("identifierLattes", "89273823");
		authorWithoutOrInvlusive.put("identifierOrcId", "23232");
		authorWithoutOrInclusive.put("result", false);
		
		parameters.add(authorWithoutOrInclusive);
		
		
		
    	return parameters;
    }
	
	@Test
	public void testOrExclusivo() {
		assertEquals(author.checkExclusiveOrFields(), resultExpected);

	}
	
	@Test
	public void testOrInclusivo() {
		assertEquals(author.checkInclusiveOrFields(), resultExpected);

	}
}

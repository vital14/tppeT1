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
		authorComplete.put("result", true);
		
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
		
		
		
    	return parameters;
    }
	
	@Test
	public void testOrExclusivo() {
		assertEquals(author.checkExclusiveOrFields(), resultExpected);
		
	}
}

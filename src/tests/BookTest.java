package tests;

import main.Author;
import main.Book;
import main.InvalidCharacterException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.*;

import static org.junit.Assert.assertEquals;



@RunWith(Parameterized.class)
public class BookTest {
	
	private Book book;
	private float completeness;

	
	public BookTest(JSONObject data) {
		this.book = (Book)data.get("book");
		this.completeness = (float)data.get("completeness");
	}
	
	@Parameters
    public static List<JSONObject> getParameters() {
		List<Book> books = new ArrayList<Book>();
		List<Float> completenessValues = Arrays.asList(0.796875f, 0.7916667f, 0.8f, 0.78125f, 0.78571427f, 0.8125f, 0.7916667f, 0.75961536f, 0.75735295f, 0.7625f);
		
		File jsonFile = new File("data.json");
		Object o = null;
		try {
			o = new JSONParser().parse(new FileReader(jsonFile));
			
			JSONArray jsonArray = (JSONArray) o;
			
			for (Object book : jsonArray) {
				JSONObject newBook = (JSONObject) book;
				JSONArray authors = (JSONArray) newBook.get("authors");
				List<Author> bookAuthors = new ArrayList<Author>();
				
				for (Object author : authors) {
					JSONObject newAuthor = (JSONObject) author;
					try {
						bookAuthors.add(new Author((String) newAuthor.get("nationality"), (String)newAuthor.get("birthCountry"), (String)newAuthor.get("birthCity"), (String)newAuthor.get("birthState"), 
								(String)newAuthor.get("identifier.lattes"), (String)newAuthor.get("identifier.orcid")));
					} catch (InvalidCharacterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				books.add(new Book((String)newBook.get("title"), (String)newBook.get("publicationDate"), (String)newBook.get("language"), bookAuthors));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<JSONObject> params = new ArrayList<JSONObject>();
		int index = 0;
		for (Book b : books) {
			JSONObject g = new JSONObject();
			g.put("book", b);
			g.put("completeness", completenessValues.get(index));
			params.add(g);
			index++;
		}
		
		
        return params;
    }
	
	@Test
	public void testTitle() {
		assertEquals(book.valorCompletude(), completeness, 0f);
	}
}

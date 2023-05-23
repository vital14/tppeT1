package main;

import java.util.List;


public class Book {
    private String title;
    private String publicationDate;
    private String language;
    private List<Author> authors;

    public Book(String title, String publicationDate, String language, List<Author> author) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.language = language;
        this.authors = author;
    }

    public float valorCompletude() {
        float result = 0f;

        if (title != null) result += 0.25f;
        if (publicationDate != null) result += 0.25f;
        if (language != null) result += 0.25f;
        
        float partialAuthorCompleteness = 0f;
        if (authors != null) {
        	for (Author a : authors) {
        		partialAuthorCompleteness += a.checkCompletenessMultiField();
        	}
        	result += (partialAuthorCompleteness / authors.size()) * 0.25f;
        }

        return result;
    }
    
    public boolean compareTitle() {
    	if (title.equals("Protein synthesis inhibitory activity in culture filtrates from new strains of Streptomyces isolated from Brazilian tropical soils")) return true;
    	return false;
    }
    
    public String getTitle() {
    	return title;
    }
    
    public int getAuthors() {
    	return authors.size();
    }
}

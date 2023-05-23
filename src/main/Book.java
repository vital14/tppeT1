package main;

public class Book {
    private String title;
    private String publicationDate;
    private String language;
    private Author[] authors;

    public Book(String title, String publicationDate, String language, Author[] author) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.language = language;
        this.authors = author;
    }

    float valorCompletude() {
        float result = 0f;

        if (title != null) result += 0.25f;
        if (publicationDate != null) result += 0.25f;
        if (language != null) result += 0.25f;
        if (authors != null) {
            result += (authors[0].checkCompletenessMultiField()) * 0.25f;
        }

        return result;
    }
}

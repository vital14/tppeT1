package main;

import java.util.HashMap;

public class Author {
    // OR Inclusivo
    private String nationality;
    private String birthCountry;
    private String birthCity;
    private String birthState;

    // Or Exclusivo
    private String identifierLattes;
    private String identifierOrcId;

    public Author(String nationality, String birthCountry, String birthCity, String birthState, String identifierLattes, String identifierOrcId) {
        this.nationality = nationality;
        this.birthCountry = birthCountry;
        this.birthCity = birthCity;
        this.birthState = birthState;
        this.identifierLattes = identifierLattes;
        this.identifierOrcId = identifierOrcId;
    }

    public float returnCompleteValueMultiFields() {
        float result = 0f;
        if(checkExclusiveOrFields()) result += 0.5;
        result += 0.5;
        return result;
    }
    
    public boolean checkExclusiveOrFields() {
        if (this.identifierLattes != null && this.identifierOrcId != null) return false;
        if (this.identifierLattes == null && this.identifierOrcId == null) return false;
        return true;
    }
    public boolean checkInclusiveOrFields() {
        if (this.nationality != null || this.birthCountry != null || this.birthCity != null || this.birthState != null) return true;
        return false;
    }
}

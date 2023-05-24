package main;

public class Author {
    // OR Inclusivo
    private String nationality;
    private String birthCountry;
    private String birthCity;
    private String birthState;

    // Or Exclusivo
    private String identifierLattes;
    private String identifierOrcId;

    public Author(String nationality, String birthCountry, String birthCity, String birthState, String identifierLattes,
            String identifierOrcId) throws InvalidCharacterException {
        setNationality(nationality);
        setBirthCountry(birthCountry);
        setBirthCity(birthCity);
        setBirthState(birthState);
        setIdentifierLattes(identifierLattes);
        setIdentifierOrcId(identifierOrcId);
    }

    public void setNationality(String nationality) throws InvalidCharacterException {
        if (!isValidString(nationality)) {
            throw new InvalidCharacterException("A string nationality contém caracteres inválidos.");
        }
        this.nationality = nationality;
    }

    public void setBirthCountry(String birthCountry) throws InvalidCharacterException {
        if (!isValidString(birthCountry)) {
            throw new InvalidCharacterException("A string birthCountry contém caracteres inválidos.");
        }
        this.birthCountry = birthCountry;
    }

    public void setBirthCity(String birthCity) throws InvalidCharacterException {
        if (!isValidString(birthCity)) {
            throw new InvalidCharacterException("A string birthCity contém caracteres inválidos.");
        }
        this.birthCity = birthCity;
    }

    public void setBirthState(String birthState) throws InvalidCharacterException {
        if (!isValidString(birthState)) {
            throw new InvalidCharacterException("A string birthState contém caracteres inválidos.");
        }
        this.birthState = birthState;
    }

    private boolean isValidString(String str) {
        return str.matches("[a-zA-Z]+");
    }

    public void setIdentifierLattes(String identifierLattes) throws InvalidCharacterException {
        if (!isValidNumber(identifierLattes)) {
            throw new InvalidCharacterException("O valor do identifierLattes contém caracteres não numéricos.");
        }
        this.identifierLattes = identifierLattes;
    }

    public void setIdentifierOrcId(String identifierOrcId) throws InvalidCharacterException {
        if (!isValidNumber(identifierOrcId)) {
            throw new InvalidCharacterException("O valor do identifierOrcId contém caracteres não numéricos.");
        }
        this.identifierOrcId = identifierOrcId;
    }

    private boolean isValidNumber(String str) {
        return str.matches("\\d+");
    }

    public boolean checkExclusiveOrFields() {
        if (this.identifierLattes != null && this.identifierOrcId != null)
            return false;
        if (this.identifierLattes == null && this.identifierOrcId == null)
            return false;
        return true;
    }

    public boolean checkInclusiveOrFields() {
        if (this.nationality != null || this.birthCountry != null || this.birthCity != null || this.birthState != null)
            return true;
        return false;
    }

    public float checkCompletenessMultiField() {
        float result = 0f;
        if (checkExclusiveOrFields())
            result += 0.5f;
        if (checkInclusiveOrFields())
            result += 0.5f;

        return result;
    }
}

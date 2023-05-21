package main;
public class PessoaFisica {
    private String primeiroNome;
    private String nomeMeio;
    private String ultimoNome;
    private String CPF;
    private String matricula;
    private String sexo;
    private String email;

    public float calcularCompletudeExclusiva() {
        int contador = 0;

        if ((primeiroNome != null && !primeiroNome.isEmpty()) ^ (nomeMeio != null && !nomeMeio.isEmpty()) ^
                (ultimoNome != null && !ultimoNome.isEmpty()) ^ (CPF != null && !CPF.isEmpty()) ^
                (matricula != null && !matricula.isEmpty()) ^ (sexo != null && !sexo.isEmpty()) ^
                (email != null && !email.isEmpty())) {
            contador++;
        }

        return (float) contador / 7 * 100;
    }

    public float calcularCompletudeInclusiva() {
        int contador = 0;

        if (primeiroNome != null && !primeiroNome.isEmpty()) {
            contador++;
        }
        if (nomeMeio != null && !nomeMeio.isEmpty()) {
            contador++;
        }
        if (ultimoNome != null && !ultimoNome.isEmpty()) {
            contador++;
        }
        if (CPF != null && !CPF.isEmpty()) {
            contador++;
        }
        if (matricula != null && !matricula.isEmpty()) {
            contador++;
        }
        if (sexo != null && !sexo.isEmpty()) {
            contador++;
        }
        if (email != null && !email.isEmpty()) {
            contador++;
        }

        return (float) contador / 7 * 100;
    }
}
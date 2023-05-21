package tests;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.PessoaFisica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PessoaFisicaTest {
	   private String primeiroNome;
	   private String nomeMeio;
	   private String ultimoNome;
	   private String CPF;
	   private String matricula;
	   private String sexo;
	   private String email;
	   
	   private PessoaFisica pessoa;
	   
	   @Before
		public void setup() {
			pessoa = new PessoaFisica();
		}
	
	@Parameters
	public static List<Object[]> getParameters(){

		
		Object[][] pessoa = new Object[][] {
			{"João","","","123456789","","joao@example.com","42.857143",""},
			{"","Maria","Silva","","","Feminino","42.857143",""},
			{"","","Santos","987654321","","joana@example.com","28.571428",""},
			{"","","","","123456789","","","14.285714",""},
			{"","","","","","","","","","0.0"}
		};
		
		return Arrays.asList(pessoa);
	}
	public PessoaFisicaTest(String primeiroNome, String nomeMeio, String ultimoNome, String CPF, String matricula, String sexo, String email) {
		this.primeiroNome = primeiroNome;
		this.nomeMeio = nomeMeio;
		this.ultimoNome = ultimoNome;
		this.CPF = CPF;
		this.matricula = matricula;
		this.sexo = sexo;
		this.email = email;
	}
	
	
	

	@Test
	void test() {
		fail("Not yet implemented");
	}

}

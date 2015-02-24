package br.com.k19.testes;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.k19.modelo.Pessoa;

public class ValidaPessoa {

	
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		
		Validator validator = validatorFactory.getValidator();
		
		
		Set<ConstraintViolation<Pessoa>> errors = validator.validate(pessoa);
		
		for (ConstraintViolation<Pessoa> error : errors) {
			System.out.println(error);
		}
	}
}

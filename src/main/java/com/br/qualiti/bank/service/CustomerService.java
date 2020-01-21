package com.br.qualiti.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.qualiti.bank.model.Customer;
import com.br.qualiti.bank.repository.CustomerRepository;

/*
 * Uma classe Service que evoca o repositório e contém a lógica de negócio do projeto para deixar o código da 
 * classe controller enxuto e mais limpo, é necessário declarar o repositório como atributo.
 */

@Service
public class CustomerService {

	private CustomerRepository customerRepository;

	CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public List findAll() {
		return customerRepository.findAll();
	}
	
	/*
	 * Um ponto importante é notar a diferença entre os métodos findAll e findById da interface JpaRepository.
	 * O método findAll retorna uma lista de entidades. 
	 * Caso não exista nenhum registro na tabela, é retornada uma lista vazia ([]). 
	 * Já o método findById retorna um Optional<T>. 
	 * A classe Optional existe desde o Java 8 e representa um container que pode ou não conter um valor não nulo (diferente de null). 
	 * Essa classe é bem interessante para evitar exceções do tipo NullPointerException,  
	 * Com o retorno do método do método findAll da interface JpaRepository podemos fazer o uso do método map caso o valor retornado seja diferente de nulo. 
	 * O método map transforma (mapeia) o registro retornado em um tipo ResponseEntity.
	 */

	public Optional<Customer> findById(long id) {
		return customerRepository.findById(id);
	}
	
}

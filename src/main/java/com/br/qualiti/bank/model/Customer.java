package com.br.qualiti.bank.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
* A anotação @Entity pertence ao JPA e isso significa que a classe será automaticamente mapeada à tabela com o mesmo 
* nome (classe Customer e tabela Customer).
* Todos os atributos dessa classe também serão mapeados com as respectivas colunas.
* Podemos omitir a anotação @Column para cada atributo da classe desde que o nome do atributo seja o mesmo nome da 
* coluna. Caso a coluna tenha o nome diferente do atributo precisamos especificar.
*/
@Entity
public class Customer {

	@Id
//	isso faz a coluna 'id' ser a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
//	aqui definimos alguns parâmetros que serão usados pelo banco de dados
	@Column(length = 20, nullable = false, unique = true)
	private String CPF;

//	aqui definimos que a tabela 'customer' vai ter uma associação de 1 para N com a lista 'accounts'
//	cascade type all significa que todas as contas serão deletadas quando o cliente for deletado
//	FetchType.LAZY: It fetches the child entities lazily, that is, at the time of fetching parent entity it 
//	just fetches proxy (created by cglib or any other utility) of the child entities and when you access
//	any property of child entity then it is actually fetched by hibernate.
//	FetchType.EAGER: it fetches the child entities along with parent.
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private List<Account> accounts;

//	construtor vazio, getters e setters devem ser definidos
//	isso é um requisito do sping, o professor não explicou o porque
	public Customer() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}

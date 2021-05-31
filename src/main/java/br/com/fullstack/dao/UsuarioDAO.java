package br.com.fullstack.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fullstack.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	// DAO is a Pattern - CRUD
	// metodos, gravar, consultar, excluir, alterar

	
	public List<Usuario> findByNomeLike(String nome);

	public Usuario findByEmailAndSenha(String email, String senha);

	
	
}

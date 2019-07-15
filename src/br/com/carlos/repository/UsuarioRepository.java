package br.com.carlos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.carlos.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	public Usuario findByAndEmailAndSenha(String emai, String senha);
}

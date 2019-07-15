package br.com.carlos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.carlos.entity.Usuario;
import br.com.carlos.repository.UsuarioRepository;

@Controller
@RequestMapping(value="/")
@CrossOrigin(value="/")
public class ControllerUsuario {
	@Autowired
	private UsuarioRepository service;
	
	@PostMapping(value="usuario")
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
		try {
			//Usuario UsuarioRetorno = new Usuario();
			
			//UsuarioRetorno = service.save(usuario);
			
			return ResponseEntity.ok(service.save(usuario));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping(value="usuario/")
	public ResponseEntity<Usuario> Excluir(@RequestBody Usuario usuario){
		try {
			service.delete(usuario);
			return (ResponseEntity) ResponseEntity.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@GetMapping(value="usuario")
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> usuarios = (List<Usuario>) service.findAll();
		return ResponseEntity.ok(usuarios);
	}
	
	
	
	@PostMapping(value="logar")
	public ResponseEntity<Usuario> Logar( @RequestBody Usuario usuario ){
		try {
			return ResponseEntity.ok( service.findByAndEmailAndSenha( usuario.getEmail(), usuario.getSenha()) );
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
		
	}
	
	
}

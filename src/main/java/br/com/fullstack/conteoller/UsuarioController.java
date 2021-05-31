package br.com.fullstack.conteoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstack.dao.UsuarioDAO;
import br.com.fullstack.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {

	@Autowired // transfere para o spring boot a responsabilidade do objeto
	private UsuarioDAO dao;
	
	@GetMapping("/loginget/{e}/{s}")
	public ResponseEntity<Usuario> logar(@PathVariable String e, @PathVariable String s){
		Usuario resposta = dao.findByEmailAndSenha(e, s);
		if (resposta == null) {
			return ResponseEntity.status(404).build();
		}
		resposta.setSenha("");
		return ResponseEntity.ok(resposta);
	}
	

	@PostMapping("/login")
	public ResponseEntity<Usuario> logar(@RequestBody Usuario usuario) {
		Usuario resposta = dao.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		if (resposta == null) {
			return ResponseEntity.status(404).build();
		}
		resposta.setSenha("");
		return ResponseEntity.ok(resposta);
	}
	

	@PostMapping("/novousuario")
	public ResponseEntity<Usuario> add(@RequestBody Usuario usuario) {
		try {
			dao.save(usuario);
			return ResponseEntity.ok(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();

		}

	}

	@GetMapping("/usuario/{var}")
	public ResponseEntity<Usuario> getUser(@PathVariable int var) {
		Usuario responsta = dao.findById(var).orElse(null);
		if (responsta == null) {
			return ResponseEntity.status(404).build();

		}
		return ResponseEntity.ok(responsta);
	}

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getAll() {
		List<Usuario> lista = (List<Usuario>) dao.findAll();
		if (lista.size() == 0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);

	}

}

package cassiadearruda.BlogPessoalAPI.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cassiadearruda.BlogPessoalAPI.entity.UserLogin;
import cassiadearruda.BlogPessoalAPI.entity.UsuarioEntity;
import cassiadearruda.BlogPessoalAPI.service.UsuarioService;

//-------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
//-------------------------------------------------------------------------------------------------------------------------------------//
@RestController
@RequestMapping("/usuario")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class UsuarioController {

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
	@Autowired
	private UsuarioService usuarioService;

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> authentication(@RequestBody Optional<UserLogin> user) {
		return usuarioService.logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioEntity> post(@RequestBody UsuarioEntity usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuario(usuario));
	}
}

package cassiadearruda.BlogPessoalAPI.service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import cassiadearruda.BlogPessoalAPI.entity.UserLogin;
import cassiadearruda.BlogPessoalAPI.entity.UsuarioEntity;
import cassiadearruda.BlogPessoalAPI.repository.UsuarioRepository;

//-------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
//-------------------------------------------------------------------------------------------------------------------------------------//
@Service
public class UsuarioService {

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
	@Autowired
	private UsuarioRepository repository;

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
	public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		return repository.save(usuario);
	}

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
	public Optional<UserLogin> logar(Optional<UserLogin> user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioEntity> usuario = repository.findByUsuarioContainingIgnoreCase(user.get().getUsuario());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				user.get().setSenha(usuario.get().getSenha());

				return user;
			}
		}
		return null;
	}
}

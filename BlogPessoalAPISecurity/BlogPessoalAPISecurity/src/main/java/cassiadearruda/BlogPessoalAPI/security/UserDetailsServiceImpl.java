package cassiadearruda.BlogPessoalAPI.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cassiadearruda.BlogPessoalAPI.entity.UsuarioEntity;
import cassiadearruda.BlogPessoalAPI.repository.UsuarioRepository;
//-------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
//-------------------------------------------------------------------------------------------------------------------------------------//
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//	
	@Autowired
	private UsuarioRepository userRepository;

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<UsuarioEntity> user = userRepository.findByUsuarioContainingIgnoreCase(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return user.map(UserDetailsImpl::new).get();
	}

}

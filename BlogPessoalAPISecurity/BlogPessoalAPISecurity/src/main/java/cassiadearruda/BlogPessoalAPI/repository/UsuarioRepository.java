package cassiadearruda.BlogPessoalAPI.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import cassiadearruda.BlogPessoalAPI.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	public Optional<UsuarioEntity> findByUsuarioContainingIgnoreCase(String usuario);
}

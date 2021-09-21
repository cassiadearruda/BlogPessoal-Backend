package cassiadearruda.BlogPessoalAPI.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cassiadearruda.BlogPessoalAPI.entity.TemaEntity;

@Repository
public interface TemaRepository extends JpaRepository<TemaEntity, Long> {

	public List<TemaEntity> findAllByDescricaoContainingIgnoreCase(String descricao);
}

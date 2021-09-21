package cassiadearruda.BlogPessoalAPI.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cassiadearruda.BlogPessoalAPI.entity.PostagemEntity;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemEntity, Long> {

	public List<PostagemEntity> findAllByTituloContainingIgnoreCase(String titulo);
}

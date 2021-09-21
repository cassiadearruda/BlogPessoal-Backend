package cassiadearruda.BlogPessoalAPI.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cassiadearruda.BlogPessoalAPI.entity.TemaEntity;
import cassiadearruda.BlogPessoalAPI.repository.TemaRepository;

@RestController
@RequestMapping ("/tema")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class TemaController {
	
	@Autowired
	private TemaRepository repository;

	@GetMapping
	public ResponseEntity<List<TemaEntity>> getAll () {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/id/{id}")
	public ResponseEntity<TemaEntity> getById (@PathVariable long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/descricao/{descricao}")
	public ResponseEntity<List<TemaEntity>> getAllByDescricao (@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity <TemaEntity> post (@RequestBody TemaEntity tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity <TemaEntity> put (@RequestBody TemaEntity tema) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
	
	@DeleteMapping ("/id/{id}")
	public void deleteById (@PathVariable long id) {
		repository.deleteById(id);
	} 
}

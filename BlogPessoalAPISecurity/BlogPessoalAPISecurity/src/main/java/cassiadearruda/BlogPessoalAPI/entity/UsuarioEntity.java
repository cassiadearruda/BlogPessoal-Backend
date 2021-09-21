package cassiadearruda.BlogPessoalAPI.entity;

//-------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
//-------------------------------------------------------------------------------------------------------------------------------------//
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
@Entity
@Table(name = "tb_usuario_entity")
public class UsuarioEntity {

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//	
	@NotNull
	@Size(min = 3, max = 100)
	private String nome;

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//	
	@NotNull
	@Size(min = 3, max = 100)
	private String usuario;
	
//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
	@NotNull
	@Size(min = 8, max = 100)
	private String senha;

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<PostagemEntity> postagem;
	
//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
//--------------------------------------------TODOS OS MÉTODOS ABAIXO = SECURITY-------------------------------------------------------//
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<PostagemEntity> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagemEntity> postagem) {
		this.postagem = postagem;
	}
}

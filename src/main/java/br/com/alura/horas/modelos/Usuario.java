package br.com.alura.horas.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -2526746630468989455L;

	@Id
	@SequenceGenerator(
			name = "usuario_id_usuario_usr_seq", 
			sequenceName = "usuario_id_usuario_usr_seq", 
			initialValue = 1, 
			allocationSize = 1)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE, 
			generator="usuario_id_usuario_usr_seq")
	@Column(name = "id_usuario_usr")
	private Long id;
	
	@NotEmpty(message="Nome precisa ser informado")
	@Column(name = "nm_nomeusu_usr")
	private String nome;
	
	@NotEmpty(message="Login não poder ser vazio")
	@Column(name = "nm_loginusr_usr")
	private String login;
	
	@NotEmpty(message="Por favor informar senha")
	@Column(name = "nm_senhausr_usr")
	private String senha;
	
	@NotEmpty(message="Precisa cadastrar um e-mail")
	@Email
	@Column(name="nm_emailusr_usr")
	private String email;
	
	@OneToMany(mappedBy = "usuario")
	private List<HoraLancada> horaLancadas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<HoraLancada> getHoraLancadas() {
		return horaLancadas;
	}

	public void setHoraLancadas(List<HoraLancada> horaLancadas) {
		this.horaLancadas = horaLancadas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", email=" + email
				+ ", horaLancadas=" + horaLancadas + "]";
	}
	
}

package br.com.alura.horas.modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="hora_lancamento")
public class HoraLancada {
	
	@Id
	@SequenceGenerator(
			name = "hora_lancamento_id_horalanc_hlc_seq", 
			sequenceName = "hora_lancamento_id_horalanc_hlc_seq", 
			initialValue = 1, 
			allocationSize = 1)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE, 
			generator="hora_lancamento_id_horalanc_hlc_seq")
	@Column(name = "id_horalanc_hlc")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_datahlc_hlc")
	private Calendar data;
	
	@Column(name = "nm_horainic_hlc")
	private String horaInicial;
	
	@Column(name = "nm_horafinl_hlc")
	private String horaFinal;
	
	@ManyToOne
	@JoinColumn( name = "id_usuario_usr", nullable = false, referencedColumnName="id_usuario_usr" )
	private Usuario usuario;
	
	public Double getDuracao() {
		
		try {
			
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			Date fim = format.parse(horaFinal);
			Date inicio = format.parse(horaInicial);
			long millis = fim.getTime() - inicio.getTime();	
			return ((double)millis)/(60 * 60 * 1000);
			
		} catch (ParseException pe) {
			return 0.0;
		}
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}

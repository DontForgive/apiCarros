package br.com.arrudadeveloper.dtos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "carros")
public class CarrosDTOS {
	
	private Long id;

	private String placa;
	private String modelo;
	private String cor;
	private int ano_fabricacao;
	private int ano_modelo;
	private Date data_criacao;
	private Date data_atualizacao;
	
	public CarrosDTOS() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "Placa não pode ser Vazia.")
	@Length(min = 6, max = 8, message = "A placa deve conter entre 6 e 8 caracteres.")
	@Column(name ="placa", nullable = false)
	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}


	@NotEmpty(message = "Modelo não pode ser Vazio.")
	@Length(min = 5, max = 200, message = "Modelo deve conter entre 5 e 200 caracteres.")
	@Column(name ="modelo", nullable = false)
	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	@NotEmpty(message = "Cor não pode ser Vazio.")
	@Length(min = 5, max = 200, message = "Cor deve conter entre 5 e 200 caracteres.")
	@Column(name ="cor", nullable = false)
	public String getCor() {
		return cor;
	}



	public void setCor(String cor) {
		this.cor = cor;
	}


	@Column(name ="ano_fabricacao", nullable = false)
	public int getAno_fabricacao() {
		return ano_fabricacao;
	}



	public void setAno_fabricacao(int ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}

	@Column(name ="ano_modelo", nullable = false)
	public int getAno_modelo() {
		return ano_modelo;
	}


	public void setAno_modelo(int ano_modelo) {
		this.ano_modelo = ano_modelo;
	}
	
	@Column(name ="data_criacao", nullable = false)
	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
	
	@Column(name ="data_atualizacao", nullable = false)
	public Date getData_atualizacao() {
		return data_atualizacao;
	}

	public void setData_atualizacao(Date data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	}
	
	@PreUpdate
	public void preUpdate() {
		data_atualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date data_atual = new Date();
		data_atualizacao = data_atual;
		data_criacao = data_atual;
	}

	@Override
	public String toString() {
		return "CarrosDTOS [id=" + id + ", placa=" + placa + ", modelo=" + modelo + ", cor=" + cor + ", ano_fabricacao="
				+ ano_fabricacao + ", ano_modelo=" + ano_modelo + ", data_criacao=" + data_criacao
				+ ", data_atualizacao=" + data_atualizacao + "]";
	}
	
	
	
	
}

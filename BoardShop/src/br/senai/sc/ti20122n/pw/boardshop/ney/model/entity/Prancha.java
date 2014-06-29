package br.senai.sc.ti20122n.pw.boardshop.ney.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Prancha {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Linha linha;
	private String medidas;
	private double valor;
	private String descricaoMin;
	private String descricaoMax;
	private Date dataDisponibilidade;
	@Lob
	private String conteudo;
	private String imagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	public String getMedidas() {
		return medidas;
	}

	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricaoMin() {
		return descricaoMin;
	}

	public void setDescricaoMin(String descricaoMin) {
		this.descricaoMin = descricaoMin;
	}

	public String getDescricaoMax() {
		return descricaoMax;
	}

	public void setDescricaoMax(String descricaoMax) {
		this.descricaoMax = descricaoMax;
	}

	public Date getDataDisponibilidade() {
		return dataDisponibilidade;
	}

	public void setDataDisponibilidade(Date dataDisponibilidade) {
		this.dataDisponibilidade = dataDisponibilidade;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}

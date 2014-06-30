package br.senai.sc.ti20122n.pw.boardshop.ney.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Linha {
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(mappedBy="linha")
	private List<Prancha> pranchas;
	private String modelo;
	private String tipoQuilha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Prancha> getPranchas() {
		return pranchas;
	}

	public void setPranchas(List<Prancha> pranchas) {
		this.pranchas = pranchas;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoQuilha() {
		return tipoQuilha;
	}

	public void setTipoQuilha(String tipoQuilha) {
		this.tipoQuilha = tipoQuilha;
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
		Linha other = (Linha) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

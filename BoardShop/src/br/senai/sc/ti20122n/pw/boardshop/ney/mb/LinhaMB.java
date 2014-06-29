package br.senai.sc.ti20122n.pw.boardshop.ney.mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.ti20122n.pw.boardshop.ney.model.entity.Linha;
import br.senai.sc.ti20122n.pw.boardshop.ney.util.FacesContextUtil;

@ManagedBean
public class LinhaMB {
	private List<Linha> linhas;
	private Linha linha;
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		linha = new Linha();
		entityManager = FacesContextUtil.getEntityManager();
	}

	public List<Linha> getLinhas() {
		if (linhas == null) {
			Query query = entityManager.createQuery(
					"select linha from Linha linha", Linha.class);
			linhas = query.getResultList();
		}
		return linhas;
	}

	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}

	public Linha getLinha() {
		return linha;
	}

	public void setlinha(Linha linha) {
		this.linha = linha;
	}

	public Linha buscarLinhaPorId(Long id) {
		return entityManager.find(Linha.class, id);
	}

	public String salvar() throws IOException {
		entityManager.merge(linha);
		return "linhalista";
	}

	public String editar(Long id) {
		setlinha(entityManager.find(Linha.class, id));
		return "linhaform";
	}

	public String excluir(Long id) {
		Linha linha = entityManager.find(Linha.class, id);
		entityManager.remove(linha);
		linhas = null;
		return "linhalista";
	}
}

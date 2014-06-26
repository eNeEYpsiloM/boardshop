package br.senai.sc.ti20122n.pw.boardshop.ney.mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.ti20122n.pw.boardshop.ney.model.entity.Filial;
import br.senai.sc.ti20122n.pw.boardshop.ney.model.entity.Prancha;
import br.senai.sc.ti20122n.pw.boardshop.ney.util.FacesContextUtil;
import br.senai.sc.ti20122n.pw.boardshop.ney.util.ImagemUtil;

@ManagedBean
public class FilialMB {
private List<Filial> filiais;
private Filial filial;
private EntityManager entityManager;

@PostConstruct
public void init() {
	entityManager = FacesContextUtil.getEntityManager();
}

public List<Filial> getFiliais() {
	if (filiais == null) {
		Query query = entityManager.createQuery(
				"select f from Filial f",Filial.class);
		filiais = query.getResultList();
	}
	return filiais;
}

public void setFiliais(List<Filial> filiais) {
	this.filiais = filiais;
}

public Filial getFilial() {
	return filial;
}

public void setFilial(Filial filial) {
	this.filial = filial;
}

public Filial buscarFilialPorId(Long id) {
	return entityManager.find(Filial.class, id);
}

public String salvar() throws IOException {
	entityManager.merge(getFilial());
	return "filiallista";
}

public String editar(Long id) {
	setFilial(entityManager.find(Filial.class, id));
	return "filialform";
}

public String excluir(Long id) {		
	Filial filial = entityManager.find(Filial.class, id);
	entityManager.remove(filial);
	filiais = null;
	return "filiallista";
}
}

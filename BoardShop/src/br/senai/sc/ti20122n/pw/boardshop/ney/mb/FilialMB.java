package br.senai.sc.ti20122n.pw.boardshop.ney.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.ti20122n.pw.boardshop.ney.model.entity.Filial;
import br.senai.sc.ti20122n.pw.boardshop.ney.util.FacesContextUtil;

@ManagedBean
public class FilialMB {
private List<Filial> filiais;
private EntityManager entityManager;

@PostConstruct
public void init() {
	entityManager = FacesContextUtil.getEntityManager();
}

public List<Filial> getFiliais() {
	if (filiais == null) {
		Query query = entityManager.createQuery(
				"select filial from Filial filial",Filial.class);
		filiais = query.getResultList();
	}
	return filiais;
}

public void setFiliais(List<Filial> filiais) {
	this.filiais = filiais;
}

public Filial buscarFilialPorId(Long id) {
	return entityManager.find(Filial.class, id);
}
}

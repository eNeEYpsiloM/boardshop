package br.senai.sc.ti20122n.pw.boardshop.ney.mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.Part;

import br.senai.sc.ti20122n.pw.boardshop.ney.model.entity.Prancha;
import br.senai.sc.ti20122n.pw.boardshop.ney.util.FacesContextUtil;
import br.senai.sc.ti20122n.pw.boardshop.ney.util.ImagemUtil;

@ManagedBean
public class PranchaMB {
	private List<Prancha> pranchas;
	private Prancha prancha;
	private EntityManager entityManager;
	private Part imagem;
	private String imagemAntiga;

	@PostConstruct
	private void init() {
		prancha = new Prancha();
		entityManager = FacesContextUtil.getEntityManager();
	}

	public String getCaminhoRelativo(String nomeImagem) {
		return ImagemUtil.getCaminhoRelativo(nomeImagem);
	}

	public List<Prancha> getPranchas() {
		if (pranchas == null) {
			Query query = entityManager.createQuery("SELECT p FROM Prancha p ",
					Prancha.class);
			pranchas = query.getResultList();
		}
		return pranchas;
	}

	public void setPranchas(List<Prancha> pranchas) {
		this.pranchas = pranchas;
	}

	public Prancha getPrancha() {
		return prancha;
	}

	public void setPrancha(Prancha prancha) {
		this.prancha = prancha;
	}

	public Part getImagem() {
		return imagem;
	}

	public void setImagem(Part imagem) {
		this.imagem = imagem;
	}

	public String getImagemAntiga() {
		return imagemAntiga;
	}

	public void setImagemAntiga(String imagemAntiga) {
		this.imagemAntiga = imagemAntiga;
	}

	public String salvar() throws IOException {
		imagemAntiga = prancha.getImagem();
		prancha.setImagem(ImagemUtil.copiar(imagem, imagemAntiga));
		entityManager.merge(prancha);
		return "boardlista";
	}

	public String editar(Long id) {
		prancha = entityManager.find(Prancha.class, id);
		return "boardform";
	}

	public String excluir(Long id) {
		Prancha prancha = entityManager.find(Prancha.class, id);
		entityManager.remove(prancha);
		ImagemUtil.deletar(prancha.getImagem());
		pranchas = null;
		return "boardlista";
	}
}

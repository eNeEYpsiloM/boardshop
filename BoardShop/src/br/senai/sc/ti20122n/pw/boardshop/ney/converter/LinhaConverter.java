package br.senai.sc.ti20122n.pw.boardshop.ney.converter;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.ti20122n.pw.boardshop.ney.mb.LinhaMB;
import br.senai.sc.ti20122n.pw.boardshop.ney.model.entity.Linha;

@FacesConverter(forClass = Linha.class)
public class LinhaConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		ELContext elContext = facesContext.getELContext();
		ELResolver elResolver = elContext.getELResolver();

		LinhaMB linhaMB = (LinhaMB) elResolver.getValue(elContext, null,
				"linhaMB");

		Long id = Long.parseLong(value);
		return linhaMB.buscarLinhaPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object object) {
		Linha linha = (Linha) object;
		return String.valueOf(linha.getId());
	}
}
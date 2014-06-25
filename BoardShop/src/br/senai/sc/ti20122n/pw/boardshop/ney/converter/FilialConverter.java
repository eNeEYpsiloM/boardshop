package br.senai.sc.ti20122n.pw.boardshop.ney.converter;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.ti20122n.pw.boardshop.ney.mb.FilialMB;
import br.senai.sc.ti20122n.pw.boardshop.ney.model.entity.Filial;

@FacesConverter(forClass = Filial.class)
public class FilialConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		ELContext elContext = facesContext.getELContext();
		ELResolver elResolver = elContext.getELResolver();

		FilialMB filialMB = (FilialMB) elResolver.getValue(elContext, null, "filialMB");

		Long id = Long.parseLong(value);
		return filialMB.buscarFilialPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object object) {
		Filial filial = (Filial) object;
		return String.valueOf(filial.getId());
	}
}

package br.senai.sc.ti20122n.pw.boardshop.ney.validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import br.senai.sc.ti20122n.pw.boardshop.ney.util.ImagemUtil;

@FacesValidator("br.senai.sc.ti20122n.pw.boardshop.ney.validator.ImagemValidator")
public class ImagemValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		List<FacesMessage> msgs = new ArrayList<FacesMessage>();
		Part file = (Part) value;
		if (file.getSize() > ImagemUtil.TAMANHO_MAXIMO) {
			msgs.add(new FacesMessage("Arquivo muito grande, permitido até 1MB."));
		}
		if (!ImagemUtil.TIPOS.containsKey(file.getContentType())) {
			msgs.add(new FacesMessage("Formato não permitido. Formatos aceitos: jpg, png e gif."));
		}
		if (!msgs.isEmpty()) {
			throw new ValidatorException(msgs);
		}
	}
}
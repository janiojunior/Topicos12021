package br.unitins.topicos12021.application;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {
	
	public static void addMessage(String msg) {
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(msg));
	}

}

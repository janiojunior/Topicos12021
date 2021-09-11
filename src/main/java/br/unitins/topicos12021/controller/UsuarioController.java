package br.unitins.topicos12021.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos12021.application.Util;
import br.unitins.topicos12021.model.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
	
	private static final long serialVersionUID = -6458187335274531216L;
	private Integer cont = 0;
	private Usuario usuario;
	private List<Usuario> listaUsuario;

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void validarNome() {
		if (getUsuario().getNome() == null || getUsuario().getNome().trim().equals("")) {
			Util.addMessage("O nome deve ser informado.");
		}
	}
	
	public boolean validarCampos() {
		boolean retorno = true;
		
		if (getUsuario().getNome() == null || getUsuario().getNome().trim().equals("")) {
			Util.addMessage("O nome deve ser informado.");
			retorno = false;
		}
		if (getUsuario().getSenha() == null || getUsuario().getSenha().trim().equals("")) {
			Util.addMessage("A senha deve ser informada.");
			retorno = false;
		}
		return retorno;
	}
	
	public void incluir() {
		if (validarCampos()) {
			getUsuario().setId(++cont);
			getListaUsuario().add(getUsuario());
			limpar();
			
			Util.addMessage("Inclusao realizada com sucesso.");
		}
	}
	
	public void editar(Usuario usu) {
		setUsuario(usu.getClone());
	}
	
	public void alterar() {
		if (validarCampos()) {
			int index = getListaUsuario().indexOf(getUsuario());
			getListaUsuario().set(index, getUsuario());
			limpar();
		}
		
		// outra forma de fazer
//		for (int indice = 0; indice < getListaUsuario().size(); indice++) {
//			if (getListaUsuario().get(indice).getId().equals(getUsuario().getId())) {
//				
//				limpar();
//				return;
//			}
//		}
	}
	
	public void excluir() {
		excluir(getUsuario());
		limpar();
	}
	
	public void excluir(Usuario usu) {
		getListaUsuario().remove(usu);
	}
	
	public void limpar() {
		usuario = null;
	}

	public List<Usuario> getListaUsuario() {
		if(listaUsuario == null) {
			listaUsuario = new ArrayList<Usuario>();
			listaUsuario.add(new Usuario(++cont,"Joao", "123", "joao@gmail.com", "321"));
			listaUsuario.add(new Usuario(++cont,"Maria", "222", "maria@gmail.com", "333"));
			listaUsuario.add(new Usuario(++cont,"Jose", "333", "jose@gmail.com", "444"));
		}
		return listaUsuario;
	}
	
}

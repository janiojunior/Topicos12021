package br.unitins.topicos12021.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos12021.model.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
	
	private static final long serialVersionUID = -6458187335274531216L;
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
	
	public void incluir() {
		getListaUsuario().add(getUsuario());
		limpar();
		
		System.out.println("Entrei no incluir");
	}
	
	public void limpar() {
		usuario = null;
	}

	public List<Usuario> getListaUsuario() {
		if(listaUsuario == null) {
			listaUsuario = new ArrayList<Usuario>();
			listaUsuario.add(new Usuario("Joao", "123", "joao@gmail.com", "321"));
			listaUsuario.add(new Usuario("Maria", "222", "maria@gmail.com", "333"));
			listaUsuario.add(new Usuario("Jose", "333", "jose@gmail.com", "444"));
		}
		return listaUsuario;
	}
	
}

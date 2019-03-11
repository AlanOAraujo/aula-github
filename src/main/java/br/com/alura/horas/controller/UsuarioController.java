package br.com.alura.horas.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.horas.dao.UsuarioDAO;
import br.com.alura.horas.modelos.Usuario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuarioController {
	
	private UsuarioDAO usuarioDAO;
	private Result result;
	private Validator validator;
	
	@Inject
	public UsuarioController(UsuarioDAO usuarioDAO, Result result, Validator validator) {

		this.usuarioDAO = usuarioDAO;
		this.result = result;
		this.validator = validator;
	}
	
	public UsuarioController() {
	}
	
	public void form() {}

	@IncludeParameters
	public void adiciona(@Valid Usuario usuario) {
		validator.onErrorRedirectTo(this).form();
		usuarioDAO.adiciona(usuario);
		result.redirectTo(this).lista();
	}
	
	public void lista() {
		
		List<Usuario> usuarios = usuarioDAO.lista();
		result.include("usuarios", usuarios);
	}
	
}

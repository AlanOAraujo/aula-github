package br.com.alura.horas.controller;

import javax.inject.Inject;

import br.com.alura.horas.dao.UsuarioDAO;
import br.com.alura.horas.modelos.Usuario;
import br.com.alura.horas.security.Open;
import br.com.alura.horas.security.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {

	
	private UsuarioDAO usuarioDAO;
	private Validator validator;
	private UsuarioLogado usuarioLogado;
	private Result result;
	
	@Inject
	public LoginController(UsuarioDAO usuarioDAO, Validator validator, UsuarioLogado usuarioLogado, Result result) {
		
		this.usuarioDAO = usuarioDAO;
		this.validator = validator;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	
	}
	
	public LoginController() {
	}
	
	@Open
	public void form() {
	}
	
	@Open
	public void autentica(String login, String senha){
    	Usuario usuario = usuarioDAO.busca(login,senha);
    	if(usuario != null){
    		usuarioLogado.fazLogin(usuario);
    		result.redirectTo(UsuarioController.class).lista();
    	} else {
    		validator.add(new SimpleMessage("Login_invalido","Login ou senha incorretos"));
    		validator.onErrorRedirectTo(this).form();
    	}
    }
	
	@Open
    public void desloga(){
    	this.usuarioLogado.desloga();
    	result.redirectTo(this).form();
    }
	
}

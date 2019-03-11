package br.com.alura.horas.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.horas.dao.HoraLancadaDAO;
import br.com.alura.horas.modelos.HoraLancada;
import br.com.alura.horas.modelos.RelatorioDeHora;
import br.com.alura.horas.security.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class HoraLancadaController {
	
	private HoraLancadaDAO horaLancadaDAO;
	
	private UsuarioLogado usuarioLogado;
	
	private Validator validator;
	
	private Result result;
		
	@Inject
	public HoraLancadaController(HoraLancadaDAO horaLancadaDAO, UsuarioLogado usuarioLogado,
			Validator validator, Result result) {
		
		this.horaLancadaDAO = horaLancadaDAO;
		this.usuarioLogado = usuarioLogado;
		this.validator = validator;
		this.result = result;
	}

	public HoraLancadaController() {
 	}
	
	public void form(){}
	
	public void adiciona(@Valid HoraLancada horaLancada) {
		validator.onErrorRedirectTo(this).form();
		horaLancada.setUsuario(usuarioLogado.getUsuario());
		horaLancadaDAO.adiciona(horaLancada);
		result.redirectTo(this).lista();
		
	}
	
	public void lista() {
		result.include("horas", horaLancadaDAO.lista());
	}
	
	public void relatorioDeHoras() {
		List<HoraLancada> horas = horaLancadaDAO.horasDoUsuario(usuarioLogado.getUsuario());
		RelatorioDeHora relatorioDeHora = new RelatorioDeHora(horas);
		result.include("relatorio", relatorioDeHora);
	}
	
}

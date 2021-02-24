package br.edu.ifms.dbf2.ProjetoN1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.dbf2.ProjetoN1.model.Multa;
import br.edu.ifms.dbf2.ProjetoN1.service.InfracaoService;
import br.edu.ifms.dbf2.ProjetoN1.service.MultaService;

@Controller
public class MultaController {
	
	@Autowired
	private MultaService multaService;
	
	@Autowired
	private InfracaoService infracaoService;
	
	@GetMapping("/multas")	
	public ModelAndView listar() {
		
		ModelAndView modelAndView =	new	ModelAndView("ListaMultas");
		modelAndView.addObject("multas", multaService.buscarTodos());
		modelAndView.addObject(new	Multa());
		modelAndView.addObject("infracoes",	infracaoService.buscarTodos());

		return modelAndView;	
	
	}
	
	@PostMapping("/multas")
	public String salvar(Multa multa) {
		
		multaService.salvar(multa);
		
		return "redirect:/multas";
	
	}

}

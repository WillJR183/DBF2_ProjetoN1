package br.edu.ifms.dbf2.ProjetoN1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.dbf2.ProjetoN1.model.Carro;
import br.edu.ifms.dbf2.ProjetoN1.service.CarroService;

@Controller
public class CarroController {
	
	@Autowired
	private CarroService carroService;
		
	@GetMapping("/carros")
	public ModelAndView listar() {
		
		// ModelAndView - especifica qual view será renderizada
		ModelAndView modelAndView = new ModelAndView("ListarCarros");
		
		// adicionando o bjeto que será manipulado na view
		// também chamando método para listar dados da lista do backend
		modelAndView.addObject("carros", buscarCarros());
		
		// outro método para listar, porém listando dados do banco de dados H2
		modelAndView.addObject("carrosBD", carros.findAll());
		
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Carro carro) {
		
		carroService.salvar(carro);
		return "redirect:/carros";
	}
	
	@GetMapping("/carro/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		
		ModelAndView modelAndView = new ModelAndView("EditarCarro");
		modelAndView.addObject(carroService.procurar(id));
		return modelAndView;
	}
	
	@GetMapping("/carro/deletar/{id}")
	public String deletar(@PathVariable("id") Long id) {
		
		carroService.deletar(id);
		return "redirect:/carros";
	}
	
	public List<Carro> buscarCarros(){
		
		List<Carro> carros = new ArrayList<Carro>();
		Carro c1 = new Carro();
		Carro c2 = new Carro();
		Carro c3 = new Carro();
		
		c1.setId((long) 1);
		c1.setPlaca("HSR-2345");
		c2.setId((long) 2);
		c2.setPlaca("OOR-7463");
		c3.setId((long) 3);
		c3.setPlaca("KNA-1098");
		
		carros.add(c1);
		carros.add(c2);
		carros.add(c3);
		
		return carros;
	}
	
}

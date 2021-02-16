package br.edu.ifms.dbf2.ProjetoN1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifms.dbf2.ProjetoN1.model.Carro;
import br.edu.ifms.dbf2.ProjetoN1.repository.Carros;
// lógica de negócios em uma camada diferente, e separada do arquivo de classe @Controller
public class CarroService {
	
	@Autowired
	private Carros carros;
	
	public List<Carro> buscarTodos() {
		return carros.findAll();
	}
	
	public void salvar(Carro carro) {
		carros.save(carro);
	}
	
	public Carro procurar(Long id) {
		return carros.getOne(id);
	}
	
	public void deletar(Long id) {
		carros.deleteById(id);
	}
	
}

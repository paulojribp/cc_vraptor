package org.cejug.ccvraptor.action;

import java.util.List;

import org.cejug.ccvraptor.entity.Fabricante;
import org.cejug.ccvraptor.service.FabricanteService;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
@Path("/fabricante")
public class FabricanteController {

	private Result result;
	private FabricanteService fabricanteService;
	
	public FabricanteController(Result result, FabricanteService fabricanteService) {
		this.result = result;
		this.fabricanteService = fabricanteService;
	}
	
	public void cadastrar(Fabricante fabricante) {
		try {
			fabricanteService.create(fabricante);
			result.use(Results.json()).from("success").serialize();
		} catch (Exception e) {
			result.use(Results.json()).from(e).serialize();
		}
	}
	
	public void atualizar(Fabricante fabricante) {
		try {
			fabricanteService.update(fabricante);
			result.use(Results.json()).from("success").serialize();
		} catch (Exception e) {
			result.use(Results.json()).from(e).serialize();
		}
	}
	
	public void remover(Long id) {
		try {
			fabricanteService.remove(id);
			result.use(Results.json()).from("success").serialize();
		} catch (Exception e) {
			result.use(Results.json()).from(e).serialize();
		}
	}
	
	public void listar() {
		try {
			List<Fabricante> fabricantes = fabricanteService.findAll();
			result.use(Results.json()).from(fabricantes).serialize();
		} catch (Exception e) {
			result.use(Results.json()).from(e).serialize();
		}
	}
	
}

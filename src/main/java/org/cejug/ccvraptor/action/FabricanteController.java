package org.cejug.ccvraptor.action;

import java.util.List;

import org.cejug.ccvraptor.entity.Fabricante;
import org.cejug.ccvraptor.service.FabricanteService;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
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
	
	@Get("/")
	public void index() {
		// void method to redirect /WEB-INF/jsp/fabricante/index.jsp
	}
	
	@Post("/create")
	public void create(Fabricante fabricante) {
		try {
			fabricanteService.create(fabricante);
			result.use(Results.json()).from("success").serialize();
		} catch (Exception e) {
			result.use(Results.json()).from(e).serialize();
		}
	}
	
	@Post("/update")
	public void update(Fabricante fabricante) {
		try {
			fabricanteService.update(fabricante);
			result.use(Results.json()).from("success").serialize();
		} catch (Exception e) {
			result.use(Results.json()).from(e).serialize();
		}
	}
	
	@Post("/remove")
	public void remove(String codigo) {
		try {
			fabricanteService.remove(codigo);
			result.use(Results.json()).from("success").serialize();
		} catch (Exception e) {
			result.use(Results.json()).from(e).serialize();
		}
	}
	
	@Get("/list")
	public void list() {
		try {
			List<Fabricante> fabricantes = fabricanteService.findAll();
			result.use(Results.json()).from(fabricantes).serialize();
		} catch (Exception e) {
			result.use(Results.json()).from(e).serialize();
		}
	}
	
}

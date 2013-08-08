package org.cejug.ccvraptor.service;

import java.util.List;

import org.cejug.ccvraptor.dao.FabricanteDao;
import org.cejug.ccvraptor.entity.Fabricante;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class FabricanteServiceImpl implements FabricanteService {

	private FabricanteDao fabricanteDao;
	
	public FabricanteServiceImpl(FabricanteDao fabricanteDao) {
		this.fabricanteDao = fabricanteDao;
	}

	@Override
	public void create(Fabricante fabricante) {
		fabricanteDao.create(fabricante);
	}

	@Override
	public void update(Fabricante fabricante) {
		Fabricante f2 = find(fabricante.getCodigo());
		f2.setNome(fabricante.getNome());
		f2.setRazaoSocial(fabricante.getRazaoSocial());
		fabricanteDao.update(f2);
	}

	@Override
	public void remove(String codigo) {
		fabricanteDao.remove(codigo);
	}

	@Override
	public List<Fabricante> findAll() {
		return fabricanteDao.findAll();
	}

	@Override
	public Fabricante find(String codigo) {
		return fabricanteDao.find(codigo);
	}

}

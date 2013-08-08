package org.cejug.ccvraptor.service;

import java.util.List;

import org.cejug.ccvraptor.entity.Fabricante;

public interface FabricanteService {

	void create(Fabricante fabricante);

	void update(Fabricante fabricante);

	void remove(String codigo);

	List<Fabricante> findAll();
	
	Fabricante find(String codigo);
	
}

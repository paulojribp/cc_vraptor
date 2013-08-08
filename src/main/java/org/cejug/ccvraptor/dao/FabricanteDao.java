package org.cejug.ccvraptor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cejug.ccvraptor.entity.Fabricante;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class FabricanteDao {

	protected EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fabricante> findAll() {
		return entityManager.createQuery("from Fabricante").getResultList();
	}
	
	public Fabricante find(String codigo) {
		return (Fabricante) entityManager.createQuery("from Fabricante where codigo = ?")
				.setParameter(1, codigo).getSingleResult();
	}

	public void create(Fabricante fabricante) {
		entityManager.persist(fabricante);
	}

	public void remove(String codigo) {
		Fabricante f = find(codigo);
		entityManager.remove(f);
	}

	public void update(Fabricante fabricante) {
		entityManager.merge(fabricante);
	}
	
	
	
}

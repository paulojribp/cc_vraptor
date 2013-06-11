package org.cejug.ccvraptor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cejug.ccvraptor.entity.Fabricante;

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
	
}

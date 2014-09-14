package fr.epf.computerdatabase.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.epf.computerdatabase.domain.Company;
import fr.epf.computerdatabase.domain.Computer;

public enum CompanyDAO {

	INSTANCE;

	private EntityManagerFactory emf;

	private CompanyDAO() {
		emf = Persistence.createEntityManagerFactory("computerdatabase-PU");
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static CompanyDAO getInstance() {
		return INSTANCE;
	}

	public void create(Company company) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(company);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Company> getAll() {
		EntityManager em = null;
		try {
			em = getEntityManager();
			return em.createQuery("SELECT c FROM Company c").getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public Company get(Long id) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			return em.find(Company.class, id);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public Long getCount() {
		EntityManager em = null;
		try {
			em = getEntityManager();
			return (Long) em.createQuery("SELECT count(c.id) FROM Company c").getSingleResult();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}

package fr.epf.computerdatabase.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.epf.computerdatabase.domain.Computer;

public enum ComputerDAO {

	INSTANCE;

	private EntityManagerFactory emf;

	private ComputerDAO() {
		emf = Persistence.createEntityManagerFactory("computerdatabase-PU");
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static ComputerDAO getInstance() {
		return INSTANCE;
	}

	public void create(Computer computer) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(computer);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Computer> getAll() {
		EntityManager em = null;
		try {
			em = getEntityManager();
			return em.createQuery("SELECT c FROM Computer c").getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}
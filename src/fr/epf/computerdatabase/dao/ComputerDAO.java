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

	public void update(Computer computer) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(computer);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
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

	public List<Computer> getAll(String search) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			return em
					.createQuery(
							"SELECT c FROM Computer c WHERE c.name LIKE :genre")
					.setParameter("genre", "%" + search + "%").getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Computer> getAll(Integer start, Integer length) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			return em.createQuery("SELECT c FROM Computer c")
					.setFirstResult(start).setMaxResults(length)
					.getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Computer> getAll(Integer start, Integer length, String searchName ) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			return em
					.createQuery(
							"SELECT c FROM Computer c  WHERE c.name LIKE :searchName")
					.setFirstResult(start).setMaxResults(length)
					.setParameter("searchName", "%" + searchName + "%")
					.getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public List<Computer> getAll(Integer start, Integer length, String searchName, String searchCompany ) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			return em
					.createQuery(
							"SELECT c FROM Computer c  WHERE c.name LIKE :searchName AND c.company.name LIKE :searchCompany")
					.setFirstResult(start).setMaxResults(length)
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("searchCompany", "%" + searchCompany + "%")
					.getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public Computer get(Long id) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			return em.find(Computer.class, id);
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
			return (Long) em.createQuery("SELECT count(c.id) FROM Computer c")
					.getSingleResult();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public Long getCount(String searchName) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			return (Long) em
					.createQuery(
							"SELECT count(c.id) FROM Computer c WHERE c.name LIKE :searchName")
					.setParameter("searchName", "%" + searchName + "%")
					.getSingleResult();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public Long getCount(String searchName, String searchCompany) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			return (Long) em
					.createQuery(
							"SELECT count(c.id) FROM Computer c WHERE c.name LIKE :searchName AND c.company.name LIKE :searchCompany")
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("searchCompany", "%" + searchCompany + "%")
					.getSingleResult();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public boolean delete(Long id) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(Computer.class, id));
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
				return true;
			}
			return false;
		}
	}
}

package fr.epf.computerdatabase.service;

import java.util.List;

import fr.epf.computerdatabase.dao.ComputerDAO;
import fr.epf.computerdatabase.domain.Computer;

public class ComputerDBService {
	private static ComputerDBService instance = null;

	// Static : has to be call without an instance
	public static ComputerDBService getInstance() {

		if (instance == null) {
			// If there is no instance yet just, create it.
			instance = new ComputerDBService();
		}
		return instance;
	}

	private ComputerDBService() {

	}

	public void create(Computer computer) {
		computerDAO.create(computer);
	}

	public void update(Computer computer) {
		computerDAO.update(computer);
	}

	private ComputerDAO computerDAO = ComputerDAO.getInstance();

	public List<Computer> getAll() {
		return computerDAO.getAll();
	}

	public List<Computer> getAll(Integer start, Integer length) {
		return computerDAO.getAll(start, length);
	}
	
	public List<Computer> getAll(Integer start, Integer length, String searchName) {
		return computerDAO.getAll(start, length, searchName);
	}

	public List<Computer> getAll(Integer start, Integer length, String searchName, String searchCompany) {
		if(searchCompany!=null&&searchCompany!="")
			return computerDAO.getAll(start, length, searchName, searchCompany);
		return computerDAO.getAll(start, length, searchName);
	}

	public Computer get(Long id) {
		return computerDAO.get(id);
	}

	public Long getCount() {
		return computerDAO.getCount();
	}

	public Long getCount(String searchName, String searchCompany) {
		if(searchCompany!=null&&searchCompany!="")
			return computerDAO.getCount(searchName, searchCompany);
		return computerDAO.getCount(searchName);
	}

	public boolean delete(Long id) {
		return computerDAO.delete(id);
	}
}

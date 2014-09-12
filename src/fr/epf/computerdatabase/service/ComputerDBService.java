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

	private ComputerDAO computerDAO = ComputerDAO.getInstance();

	public List<Computer> getAll() {
		return computerDAO.getAll();
	}
	
	public List<Computer> getAll(String search) {
		return computerDAO.getAll();
	}
	
	public List<Computer> getAll(Integer start, Integer length) {
		return computerDAO.getAll(start, length);
	}
	
	public Computer get(Long id) {
		return computerDAO.get(id);
	}
}

package fr.epf.computerdatabase.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.computerdatabase.domain.Company;
import fr.epf.computerdatabase.domain.Computer;
import fr.epf.computerdatabase.service.CompanyDBService;
import fr.epf.computerdatabase.service.ComputerDBService;

public class DashboardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Get a service
		ComputerDBService computerDBService = ComputerDBService.getInstance();
		CompanyDBService companyDBService = CompanyDBService.getInstance();

		List<Computer> computers = new ArrayList<>();
		List<Company> companies = new ArrayList<>();

		// Add the computer list
		req.setAttribute("computers", computerDBService.getAll());
		// Add the company list
		req.setAttribute("companies", companyDBService.getAll());

		// Get the dispatcher JSP
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("WEB-INF/views/dashboard.jsp");

		// Forward the request
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Get computer form request
		Computer computer = populateComputer(req);
		// Get company form request
		Company company = populateCompany(req);

		System.out.println(computer);
		System.out.println(company);

		ComputerDBService serviceComputer = ComputerDBService.getInstance();
		CompanyDBService serviceCompany = CompanyDBService.getInstance();

		// Persist the computer
		serviceComputer.create(computer);
		// Persist the company
		serviceCompany.create(company);

		doGet(req, resp);
	}

	private Computer populateComputer(HttpServletRequest req) {
		// Get form data
		String name = (String) req.getParameter("name");
		Timestamp introduced = (Timestamp) req.getParameter("introduced");

		Computer computer = Computer.builder().name(name)
				.introduced(introduced).build();
		return computer;
	}

	private Company populateCompany(HttpServletRequest req) {
		// Get form data
		String name = (String) req.getParameter("name");

		Company company = Company.builder().name(name).build();
		return company;
	}
}

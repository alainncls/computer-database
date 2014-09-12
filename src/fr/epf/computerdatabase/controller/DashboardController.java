package fr.epf.computerdatabase.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.computerdatabase.domain.Company;
import fr.epf.computerdatabase.domain.Computer;
import fr.epf.computerdatabase.service.CompanyDBService;
import fr.epf.computerdatabase.service.ComputerDBService;

@SuppressWarnings("serial")
@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Get a service
		ComputerDBService computerDBService = ComputerDBService.getInstance();
		CompanyDBService companyDBService = CompanyDBService.getInstance();

		List<Computer> computers = new ArrayList<>();
		List<Company> companies = new ArrayList<>();

		computers = computerDBService.getAll();
		companies = companyDBService.getAll();

		// Add the computer list
		req.setAttribute("computers", computers);
		// Add the company list
		req.setAttribute("companies", companies);

		// Get the dispatcher JSP
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/dashboard.jsp");

		// Forward the request
		dispatcher.forward(req, resp);
	}
}

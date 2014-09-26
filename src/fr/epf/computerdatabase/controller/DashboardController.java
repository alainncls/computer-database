package fr.epf.computerdatabase.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.computerdatabase.domain.Computer;
import fr.epf.computerdatabase.service.ComputerDBService;

@SuppressWarnings("serial")
@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Get a service
		ComputerDBService computerDBService = ComputerDBService.getInstance();

		List<Computer> computers = new ArrayList<>();

		String searchName = "";
		String searchCompany = "";

		if (req.getParameter("searchName") != null) {
			searchName = req.getParameter("searchName");
		}

		if (req.getParameter("searchCompany") != null) {
			searchCompany = req.getParameter("searchCompany");
		}

		int page = 1;
		int recordsPerPage = 10;
		if (req.getParameter("page") != null) {
			page = Integer.parseInt(req.getParameter("page"));
		}

		computers = computerDBService.getAll((page - 1) * recordsPerPage,
				recordsPerPage, searchName, searchCompany);

		long noOfRecords = computerDBService
				.getCount(searchName, searchCompany);
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		// Add the computer list
		req.setAttribute("computers", computers);
		req.setAttribute("noOfPages", noOfPages);
		req.setAttribute("noOfRecords", noOfRecords);
		req.setAttribute("currentPage", page);
		req.setAttribute("searchName", searchName);
		req.setAttribute("searchCompany", searchCompany);

		// Get the dispatcher JSP
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/dashboard.jsp");

		// Forward the request
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ComputerDBService serviceComputer = ComputerDBService.getInstance();

		String id = req.getParameter("delete");
		if (id != null) {
			// Persist the computer
			serviceComputer.delete(Long.valueOf(id));
		}
		req.setAttribute("searchName", req.getParameter("searchName"));
		req.setAttribute("searchCompany", req.getParameter("searchCompany"));
		req.setAttribute("page", req.getParameter("page"));
		doGet(req, resp);
	}
}

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
@WebServlet("/addComputer")
public class addComputerController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Get a service
		CompanyDBService companyDBService = CompanyDBService.getInstance();
		ComputerDBService computerDBService = ComputerDBService.getInstance();

		List<Company> companies = companyDBService.getAll();
		Computer computer = null;
		String id = req.getParameter("id");
		if(id!=null){
			computer = computerDBService.get(Long.valueOf(id));
		}else{
			computer = new Computer();
		}
		

		// Add the company list
		req.setAttribute("companies", companies);
		req.setAttribute("computer", computer);

		// Get the dispatcher JSP
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/addComputer.jsp");

		// Forward the request
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Get computer form request
		Computer computer = populateComputer(req);
		ComputerDBService serviceComputer = ComputerDBService.getInstance();
		
		String id = req.getParameter("id");
		if(id==null){
			// Persist the computer
			serviceComputer.create(computer);
		}else{
			// Merge the computer
			computer.setId(Long.valueOf(id));
			serviceComputer.update(computer);
		}
		doGet(req, resp);
	}

	private Computer populateComputer(HttpServletRequest req) {
		// Get form data
		String name = req.getParameter("name");

		Timestamp discontinued = Timestamp.valueOf(req
				.getParameter("discontinued")+" 00:00:00");
		Timestamp introduced = Timestamp.valueOf(req
				.getParameter("introduced")+" 00:00:00");
		
		CompanyDBService serviceCompany = CompanyDBService.getInstance();
		Company company = serviceCompany.get(Long.valueOf(req.getParameter("company")));

		Computer computer = Computer.builder().name(name)
				.introduced(introduced).discontinued(discontinued).company(company).build();
		return computer;
	}
}

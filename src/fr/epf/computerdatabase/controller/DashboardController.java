package fr.epf.computerdatabase.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.computerdatabase.domain.Computer;
import fr.epf.computerdatabase.service.ComputerDBService;

public class DashboardController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Get a service
		ComputerDBService computerDBService = ComputerDBService.getInstance();
		
		
		List<Computer> computers = new ArrayList<>();
		
		//GEt user with id 1
		//users.add(userDBService.get(1l));
		
		//Add the user list
		req.setAttribute("users", computerDBService.getAll());
		
		//
		
		//Get the dispatcher JSP
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/dashboard.jsp");

		//Forward the request
		dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Get user form request
		Computer computer = populateComputer(req);
		

		System.out.println(computer);
		
		
		ComputerDBService service = ComputerDBService.getInstance();
		
		//Persist the user
		service.create(computer);
		
		doGet(req,resp);
		
		
	}

	private Computer populateUser(HttpServletRequest req) {
		//GEt form data
		String firstName = (String)req.getParameter("firstName");
		String lastName = (String)req.getParameter("lastName");
		
		Computer computer = Computer.builder()
				.firstName(firstName)
				.lastName(lastName)
				.build();
		return computer;
	}
	
	
	
	

}

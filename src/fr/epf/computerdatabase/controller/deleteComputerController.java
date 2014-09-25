package fr.epf.computerdatabase.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.computerdatabase.service.ComputerDBService;

@SuppressWarnings("serial")
@WebServlet("/deleteComputer")
public class deleteComputerController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Get a service
		ComputerDBService computerDBService = ComputerDBService.getInstance();

		String id = req.getParameter("delete");
		if(id!=null){
			// Persist the computer
			computerDBService.delete(Long.valueOf(id));
		}

	}
}

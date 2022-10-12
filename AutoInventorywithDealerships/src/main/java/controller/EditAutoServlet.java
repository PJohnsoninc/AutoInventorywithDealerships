package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AutoBrands;
import model.AutoList;
/**
 * @authors peterjohnson & logan kennebeck - pmjohnson5 & ljkennebeck1
 * CIS175-Fall 2022
 * October 11, 2022
 */
/**
 * Servlet implementation class EditAutoServlet
 */
@WebServlet("/editAutoServlet")
public class EditAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AutoListHelper dao = new AutoListHelper();
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		AutoList autoToUpdate = dao.searchById(tempId);
		autoToUpdate.setMake(make);
		autoToUpdate.setModel(model);
		autoToUpdate.setYear(year);
		
		dao.updateAuto(autoToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllAutoServlet").forward(request, response);
	}

}

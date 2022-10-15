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
 * Servlet implementation class AddAutoServlet
 */
@WebServlet("/addAutoServlet")
public class AddAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AutoBrandsHelper bdao = new AutoBrandsHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		AutoBrands tempBrand = bdao.searchById(tempId);
		String brand = tempBrand.getBrandName();
		
		String make = brand;
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		
		AutoList auto = new AutoList(make, model, year);
		AutoListHelper dao = new AutoListHelper();
		dao.insertAuto(auto);
		
		getServletContext().getRequestDispatcher("/passToAutoServlet").forward(request, response);
	}

}

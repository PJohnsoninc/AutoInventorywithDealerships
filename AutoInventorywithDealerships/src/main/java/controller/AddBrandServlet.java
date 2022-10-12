package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AutoBrands;
/**
 * @authors peterjohnson & logan kennebeck - pmjohnson5 & ljkennebeck1
 * CIS175-Fall 2022
 * October 11, 2022
 */
/**
 * Servlet implementation class AddBrandServlet
 */
@WebServlet("/addBrandServlet")
public class AddBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBrandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AutoBrandsHelper dao = new AutoBrandsHelper();
		
		String brand = request.getParameter("brand");
		
		AutoBrands newBrand = new AutoBrands(brand);
		dao.insertBrand(newBrand);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}

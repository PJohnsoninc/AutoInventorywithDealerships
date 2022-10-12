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
 * Servlet implementation class brandNavServlet
 */
@WebServlet("/brandNavServlet")
public class BrandNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrandNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AutoBrandsHelper dao = new AutoBrandsHelper();
		String act = request.getParameter("doThisToBrand");
		
		String path = "/viewAllBrandsServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AutoBrands brandToDelete = dao.searchById(tempId);
				dao.deleteBrand(brandToDelete);
			}catch(NumberFormatException e) {
				System.out.println("Select a Brand");
			}
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AutoBrands brandToEdit = dao.searchById(tempId);
				request.setAttribute("brandToEdit", brandToEdit);
				path = "/edit-brand.jsp";
			}catch(NumberFormatException e) {
				System.out.println("Select a Brand");
			}
		}else if(act.equals("add")) {
			path = "/index.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}

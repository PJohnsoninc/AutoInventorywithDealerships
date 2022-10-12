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
 * Servlet implementation class AutoSearchServlet
 */
@WebServlet("/autoSearchServlet")
public class AutoSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AutoListHelper dao = new AutoListHelper();
		String act = request.getParameter("searchAutoByThis");
		String path = "/auto-search-results.jsp";
		
		String brand = request.getParameter("make");
		AutoBrands make = new AutoBrands(brand);
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		
		if(act.equals("make")) {
			request.setAttribute("autoResults", dao.searchByMake(make.getBrandName()));
			if(dao.searchByMake(make.getBrandName()).isEmpty()) {
				path = "/auto-search.jsp";
			}
		}else if(act.equals("model")) {
			request.setAttribute("autoResults", dao.searchByModel(model));
			if(dao.searchByModel(model).isEmpty()) {
				path = "/auto-search.jsp";
			}
		}else if(act.equals("year")) {
			request.setAttribute("autoResults", dao.searchByYear(year));
			if(dao.searchByYear(year).isEmpty()) {
				path = "/auto-search.jsp";
			}
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}
}
//if(act.equals("make")) {
//	request.setAttribute("autoResults", dao.searchByMake(make.getBrandName()));
//}else if(act.equals("model")) {
//	request.setAttribute("autoResults", dao.searchByModel(model));
//}else if(act.equals("year")) {
//	request.setAttribute("autoResults", dao.searchByYear(year));
//}




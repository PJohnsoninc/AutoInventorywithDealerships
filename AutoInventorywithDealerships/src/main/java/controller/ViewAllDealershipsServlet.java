package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dealership;

/**
 * Servlet implementation class ViewAllDealershipsServlet
 */
@WebServlet("/viewAllDealershipsServlet")
public class ViewAllDealershipsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllDealershipsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DealershipHelper ldh = new DealershipHelper();
		List<Dealership> dlist = ldh.showDealerships();
		request.setAttribute("allDealerships", dlist);
	
		if(dlist.isEmpty()) {
			request.setAttribute("allDealerships", " ");
		}
		
		getServletContext().getRequestDispatcher("/auto-list-by-dealership.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

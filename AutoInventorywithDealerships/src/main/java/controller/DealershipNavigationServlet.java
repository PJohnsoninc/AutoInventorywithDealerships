package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dealership;

/**
 * Servlet implementation class DealershipNavigationServlet
 */
@WebServlet("/dealershipNavigationServlet")
public class DealershipNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealershipNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DealershipHelper dao = new DealershipHelper();
		String act = request.getParameter("doThisToDealership");
		
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllDealershipsServlet").forward(request, response);
			
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Dealership dealershipToDelete = dao.searchById(tempId);
				dao.deleteDealership(dealershipToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllDealershipsServlet").forward(request, response);
			}
		
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Dealership dealershipToEdit = dao.searchById(tempId);
				request.setAttribute("dealershipToEdit", dealershipToEdit);
				
				request.setAttribute("month", dealershipToEdit.getLastModified().getMonthValue());
				request.setAttribute("date", dealershipToEdit.getLastModified().getDayOfMonth());
				request.setAttribute("year", dealershipToEdit.getLastModified().getYear());
				
				AutoListHelper daoForAutos = new AutoListHelper();
				
				request.setAttribute("allAutos", daoForAutos.showAll());
							
				if(daoForAutos.showAll().isEmpty()){
						request.setAttribute("allAutos", " ");
				}
				getServletContext().getRequestDispatcher("/edit-dealership.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllDealershipsServlet").forward(request, response);
			} 

		} else if (act.equals("add")) {
			AutoListHelper alh = new AutoListHelper();
			request.setAttribute("allAutos", alh.showAll());
			if(alh.showAll().isEmpty()) {
				request.setAttribute("allAutos", " ");
			}
			getServletContext().getRequestDispatcher("/new-dealership.jsp").forward(request, response);
		}
		
	}

}

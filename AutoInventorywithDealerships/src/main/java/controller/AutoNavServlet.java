package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AutoList;
/**
 * @authors peterjohnson & logan kennebeck - pmjohnson5 & ljkennebeck1
 * CIS175-Fall 2022
 * October 11, 2022
 */
/**
 * Servlet implementation class NavServlet
 */
@WebServlet("/autoNavServlet")
public class AutoNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AutoListHelper dao = new AutoListHelper();
		String act = request.getParameter("doThisToAuto");
		
		String path = "/viewAllAutoServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AutoList autoToDelete = dao.searchById(tempId);
				dao.deleteAuto(autoToDelete);
			}catch(NumberFormatException e) {
				System.out.println("Select a Vehicle");
			}
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AutoList autoToEdit = dao.searchById(tempId);
				request.setAttribute("autoToEdit", autoToEdit);
				path = "/edit-auto.jsp";
			}catch(NumberFormatException e) {
				System.out.println("Select a Vehicle");
			}
		}else if(act.equals("add")) {
			path = "/index.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}

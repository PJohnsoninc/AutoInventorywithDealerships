package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dealership;
import model.AutoList;
import model.AutoBrands;

/**
 * Servlet implementation class EditDealershipServlet
 */
@WebServlet("/editDealershipServlet")
public class EditDealershipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDealershipServlet() {
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
		AutoListHelper alh = new AutoListHelper();
		AutoBrandsHelper abh = new AutoBrandsHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Dealership dealershipToUpdate = dao.searchById(tempId);
		
		String newDealershipName = request.getParameter("dealershipName");

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		//String brandName = request.getParameter("brandName");
		
		//AutoBrands newBrand = abh.findBrand(brandName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
			//autos are selected in list to add
			String[] selectedAutos = request.getParameterValues("allAutosToAdd");
			List<AutoList> selectedAutosInList = new ArrayList<AutoList>();

			for (int i = 0; i < selectedAutos.length; i++) {
				System.out.println(selectedAutos[i]);
				AutoList c = alh.searchById(Integer.parseInt(selectedAutos[i]));
				selectedAutosInList.add(c);
			}
			dealershipToUpdate.setListOfVehicles(selectedAutosInList);
		} catch (NullPointerException ex) {
			// no autos selected in list - set to an empty list
			List<AutoList> selectedAutosInList = new ArrayList<AutoList>();
			dealershipToUpdate.setListOfVehicles(selectedAutosInList);
		}

		dealershipToUpdate.setName(newDealershipName);
		dealershipToUpdate.setLastModified(ld);
		//dealershipToUpdate.setBrandName(brandName);

		dao.updateDealership(dealershipToUpdate);

		getServletContext().getRequestDispatcher("/viewAllDealershipsServlet").forward(request, response);
	}

}

package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AutoBrands;
import model.AutoList;
import model.Dealership;

/**
 * Servlet implementation class CreateNewDealershipServlet
 */
@WebServlet("/createNewDealershipServlet")
public class CreateNewDealershipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewDealershipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AutoListHelper alh = new AutoListHelper();
		AutoBrandsHelper abh = new AutoBrandsHelper();
		String dealershipName = request.getParameter("dealershipName");
		System.out.println("Dealership Name: " + dealershipName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		String[] selectedBrands = request.getParameterValues("allBrandsToAdd");
		List<AutoBrands> selectedBrandsInList = new ArrayList<AutoBrands>();
		
		if(selectedBrands != null && selectedBrands.length > 0){
			for(int i = 0; i<selectedBrands.length; i++) {
				System.out.println(selectedBrands[i]);
				AutoBrands c = abh.searchById(Integer.parseInt(selectedBrands[i]));
				selectedBrandsInList.add(c);
			}
		}
		
		String[] selectedAutos = request.getParameterValues("allAutosToAdd");
		List<AutoList> selectedAutosInList = new ArrayList<AutoList>();
		
		if(selectedAutos != null && selectedAutos.length > 0){
			for(int i = 0; i<selectedAutos.length; i++) {
				System.out.println(selectedAutos[i]);
				AutoList c = alh.searchById(Integer.parseInt(selectedAutos[i]));
				selectedAutosInList.add(c);
			}
		}
		
		
		Dealership cld = new Dealership(dealershipName, ld);
		cld.setListOfVehicles(selectedAutosInList);
		cld.setCarriedBrands(selectedBrandsInList);
		DealershipHelper clh = new DealershipHelper();
		clh.insertDealership(cld);
		
		System.out.println("Success!");
		System.out.println(cld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllDealershipsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

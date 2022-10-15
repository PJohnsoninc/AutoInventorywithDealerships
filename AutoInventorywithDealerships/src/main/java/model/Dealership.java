package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * @authors peterjohnson & logan kennebeck - pmjohnson5 & ljkennebeck1
 * CIS175-Fall 2022
 * October 11, 2022
 */
@Entity

public class Dealership {
	
	@Id
	@GeneratedValue
	private int id;
	//dealership name
	private String name;
	//last time inventory was modified
	private LocalDate lastModified;
	//list of vehicles and carried brands
	//@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<AutoBrands> carriedBrands;
	//@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<AutoList> listOfVehicles;
	
	public Dealership() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dealership(int id, String name, LocalDate lastModified, List<AutoBrands> carriedBrands,
			List<AutoList> listOfVehicles) {
		super();
		this.id = id;
		this.name = name;
		this.lastModified = lastModified;
		this.carriedBrands = carriedBrands;
		this.listOfVehicles = listOfVehicles;
	}

	public Dealership(String name, LocalDate lastModified, List<AutoBrands> carriedBrands,
			List<AutoList> listOfVehicles) {
		super();
		this.name = name;
		this.lastModified = lastModified;
		this.carriedBrands = carriedBrands;
		this.listOfVehicles = listOfVehicles;
	}

	public Dealership(String name, LocalDate lastModified) {
		super();
		this.name = name;
		this.lastModified = lastModified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDate lastModified) {
		this.lastModified = lastModified;
	}

	public List<AutoBrands> getCarriedBrands() {
		return carriedBrands;
	}

	public void setCarriedBrands(List<AutoBrands> carriedBrands) {
		this.carriedBrands = carriedBrands;
	}

	public List<AutoList> getListOfVehicles() {
		return listOfVehicles;
	}

	public void setListOfVehicles(List<AutoList> listOfVehicles) {
		this.listOfVehicles = listOfVehicles;
	}

	@Override
	public String toString() {
		return "Dealership [id=" + id + ", name=" + name + ", lastModified=" + lastModified + ", carriedBrands="
				+ carriedBrands + ", listOfVehicles=" + listOfVehicles + "]";
	}
	
	
	

}

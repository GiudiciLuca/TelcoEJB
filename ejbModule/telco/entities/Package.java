package telco.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Package", schema = "telco")
@NamedQuery(name = "Package.findAll", query = "SELECT p FROM Package p")
public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private int valPeriod;
	private int monthlyFee;

	@ManyToMany
	@JoinTable(name = "packageservice", schema = "telco", joinColumns = @JoinColumn(name = "idpackage"), inverseJoinColumns = @JoinColumn(name = "idservice"))
	private List<Service> services = new ArrayList<Service>();

	@ManyToMany
	@JoinTable(name = "packageproduct", schema = "telco", joinColumns = @JoinColumn(name = "idpackage"), inverseJoinColumns = @JoinColumn(name = "idproduct"))
	private List<Product> products = new ArrayList<Product>();

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

	public int getValPeriod() {
		return valPeriod;
	}

	public void setValPeriod(int valPeriod) {
		this.valPeriod = valPeriod;
	}

	public int getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public void addService(Service s) {
		getServices().add(s);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProduct(Product p) {
		getProducts().add(p);
	}
}

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
import javax.persistence.OneToMany;
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

	@ManyToMany
	@JoinTable(name = "packageservice", schema = "telco", joinColumns = @JoinColumn(name = "packageid"), inverseJoinColumns = @JoinColumn(name = "serviceid"))
	private List<Service> services = new ArrayList<Service>();

	@ManyToMany
	@JoinTable(name = "packageproduct", schema = "telco", joinColumns = @JoinColumn(name = "packageid"), inverseJoinColumns = @JoinColumn(name = "productid"))
	private List<Product> products = new ArrayList<Product>();

	@ManyToMany
	@JoinTable(name = "packagevalperiod", schema = "telco", joinColumns = @JoinColumn(name = "packageid"), inverseJoinColumns = @JoinColumn(name = "valperiodid"))
	private List<ValPeriod> valPeriods = new ArrayList<ValPeriod>();
	
	@OneToMany(mappedBy = "pack")
	private List<Order> orders;	

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

	public List<ValPeriod> getValPeriods() {
		return valPeriods;
	}

	public void setValPeriods(List<ValPeriod> valPeriods) {
		this.valPeriods = valPeriods;
	}

}

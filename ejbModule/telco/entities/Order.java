package telco.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order", schema = "telco")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
@NamedQuery(name = "Order.findAllRejected", query = "SELECT o FROM Order o WHERE o.valid = FALSE")
@NamedQuery(name = "Order.findId", query = "SELECT o FROM Order o WHERE o.dateTime = ?1 AND o.totalValue = ?2 AND o.startDate = ?3 AND o.valid = ?4")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Timestamp dateTime;
	private int totalValue;
	private Date startDate;
	private boolean valid;
	private int failedPayments;

	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	@ManyToOne
	@JoinColumn(name = "packageid")
	private Package pack;

	@ManyToOne
	@JoinColumn(name = "valperiodid")
	private ValPeriod valPeriod;
	
	@ManyToMany
	@JoinTable(name = "orderproduct", schema = "telco", joinColumns = @JoinColumn(name = "orderid"), inverseJoinColumns = @JoinColumn(name = "productid"))
	private List<Product> products = new ArrayList<Product>();
	
	@OneToOne(mappedBy = "order")
	private SAS sas;

	public Order() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public int getFailedPayments() {
		return failedPayments;
	}

	public void setFailedPayments(int failedPayments) {
		this.failedPayments = failedPayments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Package getPackage() {
		return pack;
	}

	public void setPackage(Package pack) {
		this.pack = pack;
	}

	public ValPeriod getValPeriod() {
		return valPeriod;
	}

	public void setValPeriod(ValPeriod valPeriod) {
		this.valPeriod = valPeriod;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public SAS getSas() {
		return sas;
	}

	public void setSas(SAS sas) {
		this.sas = sas;
	}

}

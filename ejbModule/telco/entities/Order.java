package telco.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order", schema = "telco")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
@NamedQuery(name = "Order.findAllRejected", query = "SELECT o FROM Order o WHERE o.valid = FALSE")
@NamedQuery(name = "Order.findId", query = "SELECT o FROM Order o WHERE o.dateTime = ?1 AND o.totalValue = ?2 AND o.startDate = ?3 AND o.valid = ?4")
//TODO: check the error in the query --> solved doing the relationship as class
//@NamedQuery(name = "Order.findAllRejectedByUserId", query = "SELECT o FROM Order o JOIN o.userPackage WHERE o.valid = FALSE AND ")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Timestamp dateTime;

	private int totalValue;

	private Date startDate;

	private boolean valid;

	/*
	// TODO: maybe do the same thing but on User (?)
	// other solution can be: create a class with the relationship --> implemented
	// other solution can be: have 2 OneToOne relationship with 1 User and 1 Package (?)
	@OneToMany
	@JoinTable(name = "orderuserpackage")
	@MapKeyJoinColumn(name = "iduser")
	private Map<User, Package> userPackage = new HashMap<>();
	*/
	
	//TODO: to check if needed bi-directional one-to-one association to Alert and SAS
	@OneToOne
	private SAS sas;
	@OneToOne
	private Alert alert;

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

	/*
	public Map<User, Package> getUserPackage() {
		return userPackage;
	}

	public void setUserPackage(Map<User, Package> userPackage) {
		this.userPackage = userPackage;
	}
	*/

}

package telco.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@IdClass(OrderUserPackageId.class)
@Table(name = "orderuserpackage", schema = "telco")
@NamedQuery(name = "OrderUserPackage.findByUserId", query = "SELECT orp FROM OrderUserPackage orp WHERE orp.idUser = ?1")
@NamedQuery(name = "OrderUserPackage.findByUserPackageId", query = "SELECT orp FROM OrderUserPackage orp WHERE orp.idUser = ?1 AND orp.idPackage = ?2")
public class OrderUserPackage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idOrder;
	@Id
	private int idUser;
	@Id
	private int idPackage;
	
	public OrderUserPackage() {
		
	}
	
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idorder) {
		this.idOrder = idorder;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int iduser) {
		this.idUser = iduser;
	}
	public int getIdPackage() {
		return idPackage;
	}
	public void setIdPackage(int idpackage) {
		this.idPackage = idpackage;
	}
}

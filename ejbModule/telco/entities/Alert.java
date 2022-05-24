package telco.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alert", schema = "telco")
@NamedQuery(name = "Alert.findAll", query = "SELECT a FROM Alert a")
@NamedQuery(name = "Alert.findByUser", query = "SELECT a FROM Alert a WHERE a.user = ?1")
public class Alert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "userid")
	private User user;

	private Timestamp lastRejection;
	private int amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getLastRejection() {
		return lastRejection;
	}

	public void setLastRejection(Timestamp lastRejection) {
		this.lastRejection = lastRejection;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}

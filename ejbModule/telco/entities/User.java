package telco.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "telco")
@NamedQuery(name = "User.checkCredentials", query = "SELECT r FROM User r  WHERE r.username = ?1 and r.password = ?2")
@NamedQuery(name = "User.checkRegistrationUsername", query = "SELECT r FROM User r  WHERE r.username = ?1")
@NamedQuery(name = "User.checkRegistrationEmail", query = "SELECT r FROM User r  WHERE r.email = ?1")
@NamedQuery(name = "User.findInsolvents", query = "SELECT r FROM User r  WHERE r.insolvent = TRUE")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;

	private String password;

	private String email;

	private Boolean employee;

	private Boolean insolvent;

	@OneToMany(mappedBy = "user")
	private List<SAS> sas;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
	
	@OneToOne(mappedBy = "user")
	private Alert alert;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getInsolvent() {
		return insolvent;
	}

	public void setInsolvent(Boolean insolvent) {
		this.insolvent = insolvent;
	}

	public Boolean getEmployee() {
		return employee;
	}

	public void setEmployee(Boolean employee) {
		this.employee = employee;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<SAS> getSas() {
		return sas;
	}

	public void setSas(List<SAS> sas) {
		this.sas = sas;
	}

}
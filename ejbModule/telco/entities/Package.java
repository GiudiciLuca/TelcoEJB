package telco.entities;

import java.io.Serializable;
import javax.persistence.*;

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

}

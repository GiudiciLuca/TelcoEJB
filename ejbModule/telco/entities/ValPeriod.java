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
@Table(name = "ValPeriod", schema = "telco")
@NamedQuery(name = "ValPeriod.findAll", query = "SELECT v FROM ValPeriod v")
public class ValPeriod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int months;
	private int monthlyfee;

	@ManyToMany
	@JoinTable(name = "packagevalperiod", schema = "telco", joinColumns = @JoinColumn(name = "valperiodid"), inverseJoinColumns = @JoinColumn(name = "packageid"))
	private List<Package> packages = new ArrayList<Package>();
	
	@OneToMany(mappedBy = "valPeriod")
	private List<Order> orders;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public int getMonthlyfee() {
		return monthlyfee;
	}

	public void setMonthlyfee(int monthlyfee) {
		this.monthlyfee = monthlyfee;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

}

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
@Table(name = "Service", schema = "telco")
@NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String type;
	private int min;
	private int sms;
	private int giga;
	private int minfee;
	private int smsfee;
	private int gigafee;

	@ManyToMany
	@JoinTable(name = "packageservice", schema = "telco", joinColumns = @JoinColumn(name = "idservice"), inverseJoinColumns = @JoinColumn(name = "idpackage"))
	private List<Package> packages = new ArrayList<Package>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSms() {
		return sms;
	}

	public void setSms(int sms) {
		this.sms = sms;
	}

	public int getGiga() {
		return giga;
	}

	public void setGiga(int giga) {
		this.giga = giga;
	}

	public int getMinfee() {
		return minfee;
	}

	public void setMinfee(int minfee) {
		this.minfee = minfee;
	}

	public int getSmsfee() {
		return smsfee;
	}

	public void setSmsfee(int smsfee) {
		this.smsfee = smsfee;
	}

	public int getGigafee() {
		return gigafee;
	}

	public void setGigafee(int gigafee) {
		this.gigafee = gigafee;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public void addPackage(Package p) {
		getPackages().add(p);
	}

}

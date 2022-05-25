package telco.forTriggers;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchases_per_package", schema = "telco")
public class PurchasesPerPackage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int packageId;
	//private String packageName;
	private int totPurchases;

	public PurchasesPerPackage() {
		
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	/*
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	*/

	public int getTotPurchases() {
		return totPurchases;
	}

	public void setTotPurchases(int totPurchases) {
		this.totPurchases = totPurchases;
	}

}

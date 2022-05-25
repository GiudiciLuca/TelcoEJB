package telco.forTriggers;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "purchases_per_package_and_vp", schema = "telco")
public class PurchasesPerPackageAndVp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverride(name = "packageId", column = @Column(name = "packageId"))
	private PackVp id;

	private int totPurchases;

	public PackVp getId() {
		return id;
	}

	public void setId(PackVp id) {
		this.id = id;
	}

	public int getTotPurchases() {
		return totPurchases;
	}

	public void setTotPurchases(int totPurchases) {
		this.totPurchases = totPurchases;
	}

}

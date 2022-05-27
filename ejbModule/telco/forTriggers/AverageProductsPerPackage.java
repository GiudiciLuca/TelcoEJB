package telco.forTriggers;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "average_products_per_package", schema = "telco")
public class AverageProductsPerPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int packageId;
	
	private String packageName;
	private int totProducts;
	private int totOrders;
	private float avgProducts;

	public AverageProductsPerPackage() {
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public int getTotProducts() {
		return totProducts;
	}

	public void setTotProducts(int totProducts) {
		this.totProducts = totProducts;
	}

	public int getTotOrders() {
		return totOrders;
	}

	public void setTotOrders(int totOrders) {
		this.totOrders = totOrders;
	}

	public float getAvgProducts() {
		return avgProducts;
	}

	public void setAvgProducts(float avgProducts) {
		this.avgProducts = avgProducts;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
}

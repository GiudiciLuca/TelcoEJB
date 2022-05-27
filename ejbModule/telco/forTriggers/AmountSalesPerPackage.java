package telco.forTriggers;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "amount_sales_per_package", schema = "telco")
public class AmountSalesPerPackage implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int packageId;
	
	private String packageName;
	private int totSaleWithProducts;
	private int totSaleWithoutProducts;
	
	public AmountSalesPerPackage() {
		
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public int getTotSaleWithProducts() {
		return totSaleWithProducts;
	}

	public void setTotSaleWithProducts(int totSaleWithProducts) {
		this.totSaleWithProducts = totSaleWithProducts;
	}

	public int getTotSaleWithoutProducts() {
		return totSaleWithoutProducts;
	}

	public void setTotSaleWithoutProducts(int totSaleWithoutProducts) {
		this.totSaleWithoutProducts = totSaleWithoutProducts;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
}

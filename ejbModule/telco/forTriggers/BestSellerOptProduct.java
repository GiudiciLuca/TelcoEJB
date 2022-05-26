package telco.forTriggers;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "best_seller_opt_product", schema = "telco")
public class BestSellerOptProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private int totAmount;

	public BestSellerOptProduct() {
		
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getTotAmount() {
		return totAmount;
	}

	public void setTotAmount(int totAmount) {
		this.totAmount = totAmount;
	}
	
	
}

package telco.forTriggers;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ViewService {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<PurchasesPerPackage> totalPurchasesPerPackage() {

		String sql = "SELECT * FROM purchases_per_package ppp";
		return em.createNativeQuery(sql, PurchasesPerPackage.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PurchasesPerPackageAndVp> totalPurchasesPerPackageAndVp() {

		String sql = "SELECT * FROM purchases_per_package_and_vp pppvp";
		return em.createNativeQuery(sql, PurchasesPerPackageAndVp.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<AmountSalesPerPackage> totalAmountSalesPerPackage() {

		String sql = "SELECT * FROM amount_sales_per_package aspp";
		return em.createNativeQuery(sql, AmountSalesPerPackage.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<AverageProductsPerPackage> totalAverageProductsPerPackage() {

		String sql = "SELECT * FROM average_products_per_package appp";
		return em.createNativeQuery(sql, AverageProductsPerPackage.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<BestSellerOptProduct> totalBestSellerOptProduct() {

		String sql = "SELECT * FROM best_seller_opt_product bsop ORDER BY bsop.totAmount DESC";
		return em.createNativeQuery(sql, BestSellerOptProduct.class).getResultList();
	}
}

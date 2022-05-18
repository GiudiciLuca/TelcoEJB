package telco.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import telco.entities.Product;

@Stateless
public class ProductService {
	@PersistenceContext(unitName = "TelcoEJB")
	private EntityManager em;

	public ProductService() {

	}

	public List<Product> findAllProducts() {
		return em.createNamedQuery("Product.findAll", Product.class).getResultList();
	}

	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	public Product findByName(String name) {
		List<Product> results = findAllProducts();
		for (Product p : results)
			if (p.getName().equals(name))
				return p;
		return null;
	}

	public void createProduct(String name, int monthlyFee) {
		if (findByName(name) == null) {
			Product p = new Product();
			p.setName(name);
			p.setMonthlyFee(monthlyFee);
			em.persist(p);
			em.flush();
		}
	}
}
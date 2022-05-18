package telco.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
import telco.entities.Package;
import telco.entities.Product;
import telco.entities.Service;

@Stateless
public class PackageService {
	@PersistenceContext(unitName = "TelcoEJB")
	private EntityManager em;

	@EJB(name = "telco.services/ServiceService")
	private ServiceService sService;
	@EJB(name = "telco.services/ProductService")
	private ProductService pService;

	public PackageService() {
		// TODO Auto-generated constructor stub
	}

	public Package findById(int packageId) {
		return em.find(Package.class, packageId);
	}

	public Package findByName(String name) {
		List<Package> results = em.createNamedQuery("Package.findAll", Package.class).getResultList();
		for (Package p : results) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	public Package findDefault() {
		Package found = null;
		List<Package> results = em.createNamedQuery("Package.findAll", Package.class).getResultList();
		if (results.size() > 0)
			found = results.get(0);
		return found;
	}

	public List<Package> findAllPackages() {
		return em.createNamedQuery("Package.findAll", Package.class).getResultList();
	}
	
	public List<Product> findProducts(int id) {
		return em.find(Package.class, id).getProducts();
	}

	// TODO: to improve
	public void createPackage(String name, int valPeriod, String[] services, String[] products) {
		if (findByName(name) == null) {
			Package p = new Package();
			p.setName(name);
			p.setValPeriod(valPeriod);
			if (valPeriod == 12)
				p.setMonthlyFee(20);
			else if (valPeriod == 24)
				p.setMonthlyFee(18);
			else
				p.setMonthlyFee(15);
			List<Service> servicesToAdd = new ArrayList<Service>();
			for (String s : services) {
				Service serviceToAdd = sService.findByType(s);
				servicesToAdd.add(serviceToAdd);
			}
			p.setServices(servicesToAdd);
			List<Product> productsToAdd = new ArrayList<Product>();
			for (String prod : products) {
				Product productToAdd = pService.findByName(prod);
				productsToAdd.add(productToAdd);
			}
			p.setProducts(productsToAdd);
			em.persist(p);
			em.flush();
		}
	}

}

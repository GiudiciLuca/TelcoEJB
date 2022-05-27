package telco.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

import telco.entities.Alert;
import telco.entities.Package;
import telco.entities.Product;
import telco.entities.Service;
import telco.entities.ValPeriod;

@Stateless
public class PackageService {
	@PersistenceContext(unitName = "TelcoEJB")
	private EntityManager em;

	@EJB(name = "telco.services/ServiceService")
	private ServiceService sService;
	@EJB(name = "telco.services/ProductService")
	private ProductService pService;
	@EJB(name = "telco.services/ValPeriodService")
	private ValPeriodService vService;
	

	public PackageService() {
	}

	public Package findById(int packageId) {
		return em.find(Package.class, packageId);
	}

	// If it returns null, there is no package already created with that name.
	public Package findByName(String name) {
		try {
			return em.createNamedQuery("Package.findByName", Package.class).setParameter(1, name).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Package> findAllPackages() {
		return em.createNamedQuery("Package.findAll", Package.class).getResultList();
	}
	
	public List<Product> findProducts(int id) {
		return em.find(Package.class, id).getProducts();
	}
	
	public List<ValPeriod> findValPeriods(int id) {
		return em.find(Package.class, id).getValPeriods();
	}

	public String createPackage(String name, String[] valPeriods, String[] services, String[] products) {
		if (findByName(name) == null) {
			
			if(services.length == 0 | valPeriods.length == 0)
				return "Please select at least one validity periods and one service";
			
			Package p = new Package();
			p.setName(name);
			
			List<Service> servicesToAdd = new ArrayList<Service>();
			for (String s : services) {
				Integer id = Integer.parseInt(s);
				Service serviceToAdd = sService.findById(id);
				servicesToAdd.add(serviceToAdd);
			}
			p.setServices(servicesToAdd);
			
			if (products != null) {
				List<Product> productsToAdd = new ArrayList<Product>();
				for (String s : products) {
					Integer prod = Integer.parseInt(s);
					Product productToAdd = pService.findById(prod);
					productsToAdd.add(productToAdd);
				}
				p.setProducts(productsToAdd);
			}
			
			List<ValPeriod> valPeriodsToAdd = new ArrayList<ValPeriod>();
			for (String s : valPeriods) {
				Integer vp = Integer.parseInt(s);
				ValPeriod valPeriodToAdd = vService.findById(vp);
				valPeriodsToAdd.add(valPeriodToAdd);
			}
			p.setValPeriods(valPeriodsToAdd);
			
			em.persist(p);
			em.flush();
			return "Package creation successful";
		} else
			return "Package with the same name already present";
	}

}

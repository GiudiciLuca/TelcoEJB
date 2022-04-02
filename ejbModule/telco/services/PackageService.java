package telco.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import telco.entities.*;
import telco.entities.Package;

@Stateless
public class PackageService {
	@PersistenceContext(unitName = "TelcoEJB")
	private EntityManager em;
	
	public PackageService() {
		// TODO Auto-generated constructor stub
	}
	
	public Package findById(int packageId) {
		return em.find(Package.class, packageId);
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
	
}

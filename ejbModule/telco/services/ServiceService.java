package telco.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import telco.entities.Service;

@Stateless
public class ServiceService {
	@PersistenceContext(unitName = "TelcoEJB")
	private EntityManager em;

	public ServiceService() {

	}

	public List<Service> findAllServices() {
		return em.createNamedQuery("Service.findAll", Service.class).getResultList();
	}

	// TODO: to improve name
	public Service findByType(String type) {
		List<Service> results = findAllServices();
		for (Service s : results)
			if (s.getType().equals(type))
				return s;
		return null;
	}
}

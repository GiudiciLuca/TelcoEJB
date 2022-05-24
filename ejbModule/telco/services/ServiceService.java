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
	
	public Service findById(int serviceId) {
		return em.find(Service.class, serviceId);
	}

	public List<Service> findAllServices() {
		return em.createNamedQuery("Service.findAll", Service.class).getResultList();
	}
}

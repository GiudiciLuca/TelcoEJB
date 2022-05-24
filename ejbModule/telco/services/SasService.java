package telco.services;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import telco.entities.Order;
import telco.entities.SAS;
import telco.entities.User;

@Stateless
public class SasService {
	@PersistenceContext(unitName = "TelcoEJB")
	private EntityManager em;
	
	public SasService() {
		
	}
	
	public SAS findById(int sasId) {
		return em.find(SAS.class, sasId);
	}
	
	public List<SAS> findAllByUser(User user) {
		return em.createNamedQuery("Sas.findAllByUser", SAS.class).setParameter(1, user).getResultList();
	}
	
	public void createSas(User user, Date deactivationDate, Order order) {
		SAS s = new SAS();
		s.setDeactivationDate(deactivationDate);
		s.setOrder(order);
		s.setUser(user);
		em.persist(s);
		em.flush();
	}
}

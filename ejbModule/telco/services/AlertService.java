package telco.services;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import telco.entities.Alert;
import telco.entities.User;

@Stateless
public class AlertService {
	@PersistenceContext(unitName = "TelcoEJB")
	private EntityManager em;

	public AlertService() {
	}
	
	public Alert findById(int alertId) {
		return em.find(Alert.class, alertId);
	}
	
	public void deleteAlert(User user) {
		Alert a = findAlertByUser(user);
		if(a != null) {
			em.remove(a);
			em.flush();
		}
	}
	
	public void handleAlert(User user, int totalAmount) {
		Alert a = findAlertByUser(user);
		Timestamp lastRejection = new Timestamp(System.currentTimeMillis());
		if(a == null) {
			a = createAlert(user, lastRejection, totalAmount);
		} else {
			a.setLastRejection(lastRejection);
			a.setAmount(totalAmount);
		}
		em.persist(a);
		em.flush();
		
	}
	
	public Alert createAlert(User user, Timestamp lastRejection, int totalAmount) {
		Alert a = new Alert();
		a.setUser(user);
		a.setLastRejection(lastRejection);
		a.setAmount(totalAmount);
		return a;
	}

	public List<Alert> findAllAlerts() {
		return em.createNamedQuery("Alert.findAll", Alert.class).getResultList();
	}

	//TODO to check
	public Alert findAlertByUser(User user) {
		try {
			return em.createNamedQuery("Alert.findByUser", Alert.class).setParameter(1, user).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}

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
	
	public void createAlert(User user, Timestamp lastRejection) {
		Alert a = new Alert();
		a.setUser(user);
		a.setLastRejection(lastRejection);
		em.persist(a);
		em.flush();
	}

	public List<Alert> findAllAlerts() {
		return em.createNamedQuery("Alert.findAll", Alert.class).getResultList();
	}

	// TODO: we can also pass directly the user and than do the get on the userId
	public List<Alert> findAlertsByUser(int userId) {
		return em.createNamedQuery("Alert.findByUser", Alert.class).setParameter(1, userId).getResultList();
	}
}

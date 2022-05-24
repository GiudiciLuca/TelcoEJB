package telco.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import telco.entities.ValPeriod;

@Stateless
public class ValPeriodService {
	@PersistenceContext(unitName = "TelcoEJB")
	private EntityManager em;
	
	public ValPeriodService() {
		
	}

	public ValPeriod findById(int valPeriodId) {
		return em.find(ValPeriod.class, valPeriodId);
	}
	
	public List<ValPeriod> findAllValPeriods() {
		return em.createNamedQuery("ValPeriod.findAll", ValPeriod.class).getResultList();
	}
}

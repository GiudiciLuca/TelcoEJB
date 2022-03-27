package telco.services;

import javax.ejb.Stateful;
import javax.ejb.Remove;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
public class QueryService  {
	@PersistenceContext(unitName = "TelcoEJB", type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	public QueryService() {
		// TODO Auto-generated constructor stub
	}

	@Remove
	public void remove() {}
}

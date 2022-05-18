package telco.services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import telco.entities.Order;
import telco.entities.OrderUserPackage;

@Stateless
public class OrderService {
	@PersistenceContext(unitName = "TelcoEJB")
	private EntityManager em;

	public OrderService() {
	}

	public Order findById(int orderId) {
		return em.find(Order.class, orderId);
	}

	// TODO: we can also pass directly the user and the package and than do the get
	// on the userId and packageId
	// check also if it makes sense :)
	public void createOrder(int userId, int packageId, Timestamp dateTime, int totalValue, Date startDate,
			boolean valid) {
		Order o = new Order();
		o.setDateTime(dateTime);
		o.setTotalValue(totalValue);
		o.setStartDate(startDate);
		o.setValid(valid);
		em.persist(o);
		em.flush();

		//This query is done to retrieve the id of the order that we have just create
		Order o1 = em.createNamedQuery("Order.findId", Order.class).setParameter(1, dateTime)
				.setParameter(2, totalValue).setParameter(3, startDate).setParameter(4, valid).getSingleResult();

		OrderUserPackage oup = new OrderUserPackage();
		oup.setIdOrder(o1.getId());
		oup.setIdUser(userId);
		em.persist(oup);
		em.flush();
	}

	public List<Order> findAllOrders() {
		return em.createNamedQuery("Order.findAll", Order.class).getResultList();
	}

	public List<Order> findRejectedOrders() {
		return em.createNamedQuery("Order.findAllRejected", Order.class).getResultList();
	}

	// TODO: improve it (for example use "findRejectedOrders()")
	public List<Order> findRejectedOrdersByUserId(int userId) {
		List<OrderUserPackage> oupList = em.createNamedQuery("OrderUserPackage.findByUserId", OrderUserPackage.class)
				.setParameter(1, userId).getResultList();
		List<Order> rejectedOrders = new ArrayList<>();
		for (OrderUserPackage oup : oupList) {
			Order o = findById(oup.getIdOrder());
			if (o != null) {
				if (!o.isValid())
					rejectedOrders.add(o);
			}
		}

		return rejectedOrders;
	}
}

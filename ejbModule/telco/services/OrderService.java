package telco.services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import telco.entities.Order;
import telco.entities.Package;
import telco.entities.Product;
import telco.entities.User;
import telco.entities.ValPeriod;

@Stateless
public class OrderService {
	@PersistenceContext(unitName = "TelcoEJB")
	private EntityManager em;

	public OrderService() {
	}

	public Order findById(int orderId) {
		return em.find(Order.class, orderId);
	}

	public Order createOrder(User user, Package pack, ValPeriod valPeriod, int totalValue, Date startDate,
			boolean valid, List<Product> products) {
		Order o = new Order();
		o.setDateTime(new Timestamp(System.currentTimeMillis()));
		o.setTotalValue(totalValue);
		o.setStartDate(startDate);
		o.setValid(valid);
		if (valid)
			o.setFailedPayments(0);
		else
			o.setFailedPayments(1);
		o.setUser(user);
		o.setPackage(pack);
		o.setValPeriod(valPeriod);
		o.setProducts(products);
		em.persist(o);
		em.flush();
		return o;
	}

	public Order validOrder(Order order) {
		Order o = findById(order.getId());
		o.setValid(true);
		o.setFailedPayments(0);
		em.persist(o);
		em.flush();
		return o;
	}

	public void invalidOrder(Order order) {
		Order o = findById(order.getId());
		if (!o.isValid()) {
			o.setFailedPayments(o.getFailedPayments() + 1);
			em.persist(o);
			em.flush();
		}
	}

	public List<Order> findAllOrders() {
		return em.createNamedQuery("Order.findAll", Order.class).getResultList();
	}

	public List<Order> findAllRejectedOrders() {
		return em.createNamedQuery("Order.findAllRejected", Order.class).getResultList();
	}

	public List<Order> findRejectedOrdersByUser(User user) {
		return em.createNamedQuery("Order.findAllRejectedByUser", Order.class).setParameter(1, user).getResultList();
	}
}

package telco.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.NonUniqueResultException;
import telco.entities.User;
import telco.exceptions.CredentialsException;
import java.util.List;

@Stateless
public class UserService {
	@PersistenceContext(unitName = "TelcoEJB")
	private EntityManager em;

	public UserService() {
	}

	public User checkCredentials(String usrn, String pwd) throws CredentialsException, NonUniqueResultException {
		List<User> uList = null;
		try {
			uList = em.createNamedQuery("User.checkCredentials", User.class).setParameter(1, usrn).setParameter(2, pwd)
					.getResultList();
		} catch (PersistenceException e) {
			throw new CredentialsException("Could not verify credentals");
		}
		if (uList.isEmpty())
			return null;
		else if (uList.size() == 1)
			return uList.get(0);
		throw new NonUniqueResultException("More than one user registered with same credentials");
	}

	public String registration(String usrn, String email, String pwd) throws CredentialsException {
		List<User> uList = null;
		try {
			uList = em.createNamedQuery("User.checkRegistrationUsername", User.class).setParameter(1, usrn)
					.getResultList();

			// ------------ check
			System.out.println("username " + uList);

			if (!uList.isEmpty())
				return "Username already used";

			uList = em.createNamedQuery("User.checkRegistrationEmail", User.class).setParameter(1, email)
					.getResultList();

			// ------------ check
			System.out.println("email " + uList);

			if (!uList.isEmpty())
				return "Email already used";

			User user = new User();
			user.setUsername(usrn);
			user.setEmail(email);
			user.setPassword(pwd);
			user.setEmployee(false);
			em.persist(user);
			em.flush();

			return "OK";

		} catch (PersistenceException e) {
			throw new CredentialsException("Could not verify credentals");
		}

	}
}

package telco.entities;

import java.io.Serializable;
import java.util.Objects;

public class OrderUserPackageId implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idOrder;
	private int idUser;
	private int idPackage;
	
	@Override
	public int hashCode() {
		return Objects.hash(idOrder, idPackage, idUser);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderUserPackageId other = (OrderUserPackageId) obj;
		return idOrder == other.idOrder && idPackage == other.idPackage && idUser == other.idUser;
	}
	
}

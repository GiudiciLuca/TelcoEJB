package telco.forTriggers;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class PackVp implements Serializable {
	private static final long serialVersionUID = 1L;

	int packageId;
	int valPeriodId;

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public int getValPeriodId() {
		return valPeriodId;
	}

	public void setValPeriodId(int valPeriodId) {
		this.valPeriodId = valPeriodId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(packageId, valPeriodId);
	}
	//Auto-generated method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PackVp other = (PackVp) obj;
		return packageId == other.packageId && valPeriodId == other.valPeriodId;
	}

}

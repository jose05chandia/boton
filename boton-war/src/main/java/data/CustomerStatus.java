package data;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "CustomerStatus")
@SequenceGenerator(name = "SEQ_CUSTOMERSTATUS", sequenceName = "SEQ_CUSTOMERSTATUS")
public class CustomerStatus implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_CUSTOMERSTATUS", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "customerStatus")
	private String customerStatus;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CustomerStatus)) {
			return false;
		}
		CustomerStatus other = (CustomerStatus) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String userStatus) {
		this.customerStatus = userStatus;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (customerStatus != null && !customerStatus.trim().isEmpty())
			result += "customerStatus: " + customerStatus;
		return result;
	}
}
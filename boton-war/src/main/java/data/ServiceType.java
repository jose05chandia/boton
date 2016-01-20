package data;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "ServiceType")
@SequenceGenerator(name = "SEQ_SERVICETYPE", sequenceName = "SEQ_SERVICETYPE")
public class ServiceType implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_SERVICETYPE", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "serviceType")
	private String serviceType;

	@Column(name = "genericPhone")
	private long genericPhone;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAlert")
	private Alert alert;

	public Alert getAlert() {
		return alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

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
		if (!(obj instanceof ServiceType)) {
			return false;
		}
		ServiceType other = (ServiceType) obj;
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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public long getGenericPhone() {
		return genericPhone;
	}

	public void setGenericPhone(long genericPhone) {
		this.genericPhone = genericPhone;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (serviceType != null && !serviceType.trim().isEmpty())
			result += "serviceType: " + serviceType;
		result += ", genericPhone: " + genericPhone;
		return result;
	}
}
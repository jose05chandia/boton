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
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "Service")
@SequenceGenerator(name = "SEQ_SERVICE", sequenceName = "SEQ_SERVICE")

public class Service implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_SERVICE", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "service")
	private String service;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private int phone;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idServiceType")
	private ServiceType serviceType;

	public Service() {

	}

	public Service(Long id, String service, String address, int phone,
			ServiceType serviceType) {
		super();
		this.id = id;
		this.service = service;
		this.address = address;
		this.phone = phone;
		this.serviceType = serviceType;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
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
		if (!(obj instanceof Service)) {
			return false;
		}
		Service other = (Service) obj;
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

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (service != null && !service.trim().isEmpty())
			result += "service: " + service;
		if (address != null && !address.trim().isEmpty())
			result += ", address: " + address;

		return result;
	}
}
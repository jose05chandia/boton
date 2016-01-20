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
@Table(name = "Device")
@SequenceGenerator(name = "SEQ_DEVICE", sequenceName = "SEQ_DEVICE")
public class Device implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_DEVICE", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "brand")
	private String brand;

	@Column(name = "model")
	private String model;

	@Column(name = "operatingSystem")
	private String operatingSystem;

	@Column(name = "token")
	private String token;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCustomer")
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDeviceType")
	private DeviceType deviceType;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
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
		if (!(obj instanceof Device)) {
			return false;
		}
		Device other = (Device) obj;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (brand != null && !brand.trim().isEmpty())
			result += "brand: " + brand;
		if (model != null && !model.trim().isEmpty())
			result += ", model: " + model;
		if (operatingSystem != null && !operatingSystem.trim().isEmpty())
			result += ", operatingSystem: " + operatingSystem;
		if (token != null && !token.trim().isEmpty())
			result += ", token: " + token;

		return result;
	}
}
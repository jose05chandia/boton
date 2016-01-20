package data;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "DeviceType")
@SequenceGenerator(name = "SEQ_DEVICETYPE", sequenceName = "SEQ_DEVICETYPE")
public class DeviceType implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_DEVICETYPE", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "deviceType")
	private String deviceType;

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
		if (!(obj instanceof DeviceType)) {
			return false;
		}
		DeviceType other = (DeviceType) obj;
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

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (deviceType != null && !deviceType.trim().isEmpty())
			result += "deviceType: " + deviceType;
		return result;
	}
}
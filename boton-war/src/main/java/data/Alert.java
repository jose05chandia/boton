package data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Alert")
@SequenceGenerator(name = "SEQ_ALERT", sequenceName = "SEQ_ALERT")
public class Alert implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_ALERT", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "dateTimeStart")
	private Date dateTimeStart;

	@Column(name = "dateTimeEnd")
	private Date dateTimeEnd;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCustomer")
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCustomerStatus")
	private CustomerStatus customerStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCentralStatus")
	private CentralStatus centralStatus;

	public Alert() {

	}

	public Alert(Long id, Date dateTimeStart, Date dateTimeEnd,
			String latitude, String longitude, Customer customer,
			CustomerStatus customerStatus, CentralStatus centralStatus) {
		super();
		this.id = id;
		this.dateTimeStart = dateTimeStart;
		this.dateTimeEnd = dateTimeEnd;
		this.latitude = latitude;
		this.longitude = longitude;
		this.customer = customer;
		this.customerStatus = customerStatus;
		this.centralStatus = centralStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerStatus getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(CustomerStatus customerStatus) {
		this.customerStatus = customerStatus;
	}

	public CentralStatus getCentralStatus() {
		return centralStatus;
	}

	public void setCentralStatus(CentralStatus centralStatus) {
		this.centralStatus = centralStatus;
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
		if (!(obj instanceof Alert)) {
			return false;
		}
		Alert other = (Alert) obj;
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

	public Date getDateTimeStart() {
		return dateTimeStart;
	}

	public void setDateTimeStart(Date dateTimeStart) {
		this.dateTimeStart = dateTimeStart;
	}

	public Date getDateTimeEnd() {
		return dateTimeEnd;
	}

	public void setDateTimeEnd(Date dateTimeEnd) {
		this.dateTimeEnd = dateTimeEnd;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (latitude != null && !latitude.trim().isEmpty())
			result += "latitude: " + latitude;
		if (longitude != null && !longitude.trim().isEmpty())
			result += ", longitude: " + longitude;

		return result;
	}
}
package data;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "CentralStatus")
@SequenceGenerator(name = "SEQ_CENTRALSTATUS", sequenceName = "SEQ_CENTRALSTATUS")
public class CentralStatus implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_CENTRALSTATUS", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "centralStatus")
	private String centralStatus;

	public CentralStatus() {

	}

	public CentralStatus(Long id, String centralStatus) {
		super();
		this.id = id;
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
		if (!(obj instanceof CentralStatus)) {
			return false;
		}
		CentralStatus other = (CentralStatus) obj;
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

	public String getCentralStatus() {
		return centralStatus;
	}

	public void setCentralStatus(String centralStatus) {
		this.centralStatus = centralStatus;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (centralStatus != null && !centralStatus.trim().isEmpty())
			result += "centralStatus: " + centralStatus;
		return result;
	}
}
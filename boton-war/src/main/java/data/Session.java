package data;
import java.io.Serializable;
import java.util.Date;

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
@Table(name = "Session")
@SequenceGenerator(name = "SEQ_SESSION", sequenceName = "SEQ_SESSION")
public class Session implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_SESSION", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "dateTimeLogin")
	private Date dateTimeLogin;

	@Column(name = "dateTimeExpired")
	private Date dateTimeExpired;

	@Column(name = "autentication")
	private String autentication;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDevice")
	private Device device;

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
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
		if (!(obj instanceof Session)) {
			return false;
		}
		Session other = (Session) obj;
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

	public Date getDateTimeLogin() {
		return dateTimeLogin;
	}

	public void setDateTimeLogin(Date dateTimeLogin) {
		this.dateTimeLogin = dateTimeLogin;
	}

	public Date getDateTimeExpired() {
		return dateTimeExpired;
	}

	public void setDateTimeExpired(Date dateTimeExpired) {
		this.dateTimeExpired = dateTimeExpired;
	}

	public String getAutentication() {
		return autentication;
	}

	public void setAutentication(String autentication) {
		this.autentication = autentication;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (autentication != null && !autentication.trim().isEmpty())
			result += "autentication: " + autentication;

		return result;
	}
}
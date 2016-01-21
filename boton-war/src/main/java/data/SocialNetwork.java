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
@Table(name = "SocialNetwork")
@SequenceGenerator(name = "SEQ_SOCIALNETWORK", sequenceName = "SEQ_SOCIALNETWORK")
public class SocialNetwork implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_SOCIALNETWORK", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "idProvider")
	private int idProvider;

	@Column(name = "provider")
	private String provider;

	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCustomer")
	private Customer customer;

	public SocialNetwork() {

	}

	public SocialNetwork(Long id, int idProvider, String provider,
			String description, Customer customer) {
		super();
		this.id = id;
		this.idProvider = idProvider;
		this.provider = provider;
		this.description = description;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		if (!(obj instanceof SocialNetwork)) {
			return false;
		}
		SocialNetwork other = (SocialNetwork) obj;
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

	public int getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		result += "idProvider: " + idProvider;
		if (provider != null && !provider.trim().isEmpty())
			result += ", provider: " + provider;
		if (description != null && !description.trim().isEmpty())
			result += ", description: " + description;

		return result;
	}
}
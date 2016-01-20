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
@Table(name = "Customer")
@SequenceGenerator(name = "SEQ_CUSTOMER", sequenceName = "SEQ_CUSTOMER")
public class Customer implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_CUSTOMER", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "RUN")
	private String RUN;

	@Column(name = "name")
	private String name;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private int phone;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idState")
	private State state;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRole")
	private Role role;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) obj;
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

	public String getRUN() {
		return RUN;
	}

	public void setRUN(String RUN) {
		this.RUN = RUN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (RUN != null && !RUN.trim().isEmpty())
			result += "RUN: " + RUN;
		if (name != null && !name.trim().isEmpty())
			result += ", name: " + name;
		if (lastName != null && !lastName.trim().isEmpty())
			result += ", lastName: " + lastName;
		if (address != null && !address.trim().isEmpty())
			result += ", address: " + address;
		result += ", phone: " + phone;
		if (email != null && !email.trim().isEmpty())
			result += ", email: " + email;
		if (password != null && !password.trim().isEmpty())
			result += ", password: " + password;

		return result;
	}
}
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
@Table(name = "State")
@SequenceGenerator(name = "SEQ_STATE", sequenceName = "SEQ_STATE")
public class State implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_STATE", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "state")
	private String state;

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
		if (!(obj instanceof State)) {
			return false;
		}
		State other = (State) obj;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (state != null && !state.trim().isEmpty())
			result += "status: " + state;
		return result;
	}
}
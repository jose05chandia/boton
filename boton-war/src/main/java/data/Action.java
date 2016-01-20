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
@Table(name = "Action")
@SequenceGenerator(name = "SEQ_ACTION", sequenceName = "SEQ_ACTION")
public class Action implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_ACTION", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "action")
	private String action;

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
		if (!(obj instanceof Action)) {
			return false;
		}
		Action other = (Action) obj;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (action != null && !action.trim().isEmpty())
			result += "action: " + action;
		return result;
	}
}
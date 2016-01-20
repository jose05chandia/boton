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
@Table(name = "Activity")
@SequenceGenerator(name = "SEQ_ACTIVITY", sequenceName = "SEQ_ACTIVITY")
public class Activity implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_ACTIVITY", strategy = GenerationType.AUTO)
	private Long id;


	@Column(name = "activity")
	private String activity;

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
		if (!(obj instanceof Activity)) {
			return false;
		}
		Activity other = (Activity) obj;
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

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (activity != null && !activity.trim().isEmpty())
			result += "function: " + activity;
		return result;
	}
}
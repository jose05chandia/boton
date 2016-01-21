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
@Table(name = "File")
@SequenceGenerator(name = "SEQ_FILE", sequenceName = "SEQ_FILE")
public class File implements Serializable {

	@Id
	@GeneratedValue(generator = "SEQ_FILE", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "file")
	private String file;

	@Column(name = "description")
	private String description;

	@Column(name = "size")
	private int size;

	@Column(name = "MIME")
	private String MIME;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAlert")
	private Alert alert;

	public File() {

	}

	public File(Long id, String file, String description, int size,
			String mIME, Alert alert) {
		super();
		this.id = id;
		this.file = file;
		this.description = description;
		this.size = size;
		MIME = mIME;
		this.alert = alert;
	}

	public Alert getAlert() {
		return alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
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
		if (!(obj instanceof File)) {
			return false;
		}
		File other = (File) obj;
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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getMIME() {
		return MIME;
	}

	public void setMIME(String MIME) {
		this.MIME = MIME;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (file != null && !file.trim().isEmpty())
			result += "file: " + file;
		if (description != null && !description.trim().isEmpty())
			result += ", description: " + description;
		result += ", size: " + size;
		if (MIME != null && !MIME.trim().isEmpty())
			result += ", MIME: " + MIME;
		return result;
	}
}
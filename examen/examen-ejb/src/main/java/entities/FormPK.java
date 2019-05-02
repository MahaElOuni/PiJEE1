package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FormPK
 *
 */
@Embeddable
public class FormPK implements Serializable {

	
	private int formId;
	private int eventId;
	private static final long serialVersionUID = 1L;

	public FormPK() {
		super();
	}   
	public int getFormId() {
		return this.formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}   
	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	@Override
	public String toString() {
		return "FormPK [formId=" + formId + ", eventId=" + eventId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventId;
		result = prime * result + formId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormPK other = (FormPK) obj;
		if (eventId != other.eventId)
			return false;
		if (formId != other.formId)
			return false;
		return true;
	}
	
	
   
}

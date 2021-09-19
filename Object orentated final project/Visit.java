import java.time.LocalDate;
public class Visit {// attributes
	
	private LocalDate DOV;
	private String notes;
	
	public Visit(String Notes) {// constructor with only notes
		this.DOV=LocalDate.now();
		this.notes = Notes;
	}
	public Visit(LocalDate date, String Notes) {// constructor with date and notes
		this.DOV=date;
		this.notes = Notes;
	}

	public LocalDate getDOV() {// getters and setters
		return DOV;
	}

	public void setDOV(LocalDate dOV) {
		DOV = dOV;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

	@Override
	public String toString() {// tostring
		return "Visit [DOV=" + DOV + ", notes=" + notes + "]";
	}

	public boolean equals(Object obj) {// equals
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visit other = (Visit) obj;
		if (DOV == null) {
			if (other.DOV != null)
				return false;
		} else if (!DOV.equals(other.DOV))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		return true;
	}
	
}

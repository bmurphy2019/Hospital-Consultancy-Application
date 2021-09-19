import java.util.ArrayList;

public class Practice { // attributes
	ArrayList<Consultant> consults;
	
	public Practice(){ // constructor
		consults = new ArrayList<Consultant>(10);
	}
	
	public void addConsultant(Consultant consult) { // adds a new Consultant
		this.consults.add(consult);
	}
	
	
	public void showConsults () { // shows all Consultants in practice
		int index =0;
		int size = this.consults.size();
		while (index < size) {
			Consultant currentconsult = this.consults.get(index);
			System.out.println(currentconsult.toString());
			index = index +1;
		}
	
	}
	
	public Consultant findConsultant(String Name) { // finds a consultant by their name
		Consultant res = null;
		
		int index =0;
		int size = this.consults.size();
		while (index < size) {
			Consultant currentconsult = this.consults.get(index);
			if (currentconsult.equals(Name)) {
				res = currentconsult;
				return res;
			}
			index = index +1;
		}
	
		
		return res;
	}
	
	public void showConsultsPatientsVisits () { // shows everything
		int index =0;
		int size = this.consults.size();
		while (index < size) {
			Consultant currentconsult = this.consults.get(index);
			System.out.println(currentconsult.toString());
			currentconsult.showPatientsVisits();
			index = index +1;
		}
	}
	
	public Patient findPatient(String Name) { // finds a patient by their name
		Patient res=null;
		
		int index =0;
		int size = this.consults.size();
		while (index < size) {
			Consultant currentconsult = this.consults.get(index);
			int size1 = currentconsult.patientList.size();
			int index1 = 0;	
			while (index1 < size1) {
				Patient currentPatient = currentconsult.patientList.get(index1);
				if (currentPatient.equals(Name)) {
					res = currentPatient;
				}
				index1=index1+1;
			}
			index = index+1;
		}
		
		return res;
	}

	public ArrayList<Consultant> getConsults() { // getters and setters
		return consults;
	}

	public void setConsults(ArrayList<Consultant> consults) {
		this.consults = consults;
	}


	@Override
	public boolean equals(Object obj) { // equals
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Practice other = (Practice) obj;
		if (consults == null) {
			if (other.consults != null)
				return false;
		} else if (!consults.equals(other.consults))
			return false;
		return true;
	}

	@Override
	public String toString() { // tostring
		return "Practice [consults=" + consults + "]";
	}
	
	
	
	
	
}

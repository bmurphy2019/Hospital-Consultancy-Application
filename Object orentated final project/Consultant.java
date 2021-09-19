import java.util.ArrayList;
public class Consultant extends Person { // attributes
	ArrayList<Patient>  patientList; 
	private String expertise;
	
	
	Consultant(Name name,String id,String phone,String expertise){ // constructor
		super(name,id,phone);
		patientList = new ArrayList<Patient>(10);
		this.expertise = expertise;
	}
	public void addPatients (Patient patient) { // adds a new patient
		this.patientList.add(patient);
	}
	public void addPatientVisit(Patient patient, Visit visit) { // adds a visit to a patient
		patient.addVisit(visit);
	}
	public void showPatients () { // shows all patients
		int index =0;
		int size = this.patientList.size();
		while (index < size) {
			Patient currentPatient = this.patientList.get(index);
			System.out.println(currentPatient.toString());
			index = index +1;
		}
		if(size ==0) {
			System.out.println("no patients");
		}
		
	}
	
	public void showPatientsVisits () {// shows all patients and visits
		int index =0;
		int size = this.patientList.size();
		while (index < size) {
			Patient currentPatient = this.patientList.get(index);
			System.out.println(currentPatient.toString());
			currentPatient.showVisits();
			index = index +1;
		}
	}
	
	public String toString() {// tostring
		return "CONSULT Name= "+name.getFirstname() +" " +name.getLastName()+" ID= "+this.id+ " Phone= " +this.phone+ ", expertise=" + expertise + "";
	}

	@Override
	public boolean equals(Object obj) {// equals
		if (this == obj) 
			return true;
		if (super.equals(obj)) 
			return true;
		if (getClass() != obj.getClass())
			return false;
		Consultant other = (Consultant) obj;
		if (expertise == null) {
			if (other.expertise != null)
				return false;
		} else if (!expertise.equals(other.expertise))
			return false;
		if (patientList == null) {
			if (other.patientList != null)
				return false;
		} else if (!patientList.equals(other.patientList))
			return false;
		return true;
	}
	public ArrayList<Patient> getPatientList() {// getters and setters
		return patientList;
	}
	public void setPatientList(ArrayList<Patient> patientList) {
		this.patientList = patientList;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
	
	
	
}

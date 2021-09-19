import java.util.ArrayList;


public class Patient extends Person {// class attributes
	private ArrayList<Visit> visitList;
	private String illnesses;
	private enum Severity{ MILD,LOW,MEDIUM,HIGH,SEVERE;} 
	
	private Severity severity;
	
	public Patient(Name name, String id, String phone,String illness, int severity) {// constructor
		super(name,id,phone);
		ArrayList<Visit> visitList = new ArrayList<Visit>();
		this.visitList = visitList;
		this.illnesses = illness;
		if (severity ==1){
			this.severity = Severity.MILD;
		}
		else if (severity ==2){
			this.severity = Severity.LOW;
		}
		else if (severity ==3){
			this.severity = Severity.MEDIUM;
		}
		else if (severity ==4){
			this.severity = Severity.HIGH;
		}
		else if (severity ==5){
			this.severity = Severity.SEVERE;
		}
	}
	
	public void addVisit(Visit visit) {// adds a visit
		this.visitList.add(visit);
	}
	
	public void showVisits() {// shows all visits
		int index =0;
		int size = this.visitList.size();
		while (index < size) {
			Visit currentVisit = this.visitList.get(index);
			System.out.println(currentVisit.toString());
			index = index +1;
		}
		System.out.println(" ");
		
	}

	@Override
	public String toString() {// tostring
		return "PATIENT name= "+ name.getFirstname() +" "+name.getLastName()+ " illnesses= " + illnesses + ", severity= " + severity + ", id= " + id + ", phone=" + phone + "";
	}


	@Override
	public boolean equals(Object obj) {// equals
		if (this == obj)
			return true;
		if (super.equals(obj))
			return true;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (illnesses == null) {
			if (other.illnesses != null)
				return false;
		} else if (!illnesses.equals(other.illnesses))
			return false;
		if (severity != other.severity)
			return false;
		if (visitList == null) {
			if (other.visitList != null)
				return false;
		} else if (!visitList.equals(other.visitList))
			return false;
		return true;
	}

	public ArrayList<Visit> getVisitList() {// setters and getters
		return visitList;
	}

	public void setVisitList(ArrayList<Visit> visitList) {
		this.visitList = visitList;
	}

	public String getIllnesses() {
		return illnesses;
	}

	public void setIllnesses(String illnesses) {
		this.illnesses = illnesses;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	
	
	

}



public class Name { // class attributes
	private String firstname; 
	private String lastName;
	
	public Name(String firstname,String lastname) { // constructor
		this.firstname = firstname;
		this.lastName = lastname;
	}

	public String getFirstname() { // getters and setters
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String toString() { // tostring
		return "Name firstname=" + firstname + ", lastName=" + lastName + "";
	}


	@Override
	public boolean equals(Object obj) { // equals
		if (obj.equals(firstname)) {
			return true;}
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	
	
	
}


public class Person { // class atributes
	protected Name name;
	protected String id;
	protected String phone;
	public Person(Name name, String id, String phone) { // constructor
		this.name = name;
		this.id = id;
		this.phone = phone;
	}
	public String getId() { // getters and setters
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() { //tostring
		return "Person "+this.name.toString()+" id=" + id + ", phone=" + phone + "]";
	}


	public boolean equals(Object obj) {// equals
		if (name.equals(obj)) 
			return true;
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	
	
	
}

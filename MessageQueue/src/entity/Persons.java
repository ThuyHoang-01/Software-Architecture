package entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persons {
	
	private List<Person> listPerson = new ArrayList<>();

	public Persons(List<Person> listPerson) {
		super();
		this.listPerson = listPerson;
	}

	public Persons() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Person> getListPerson() {
		return listPerson;
	}

	@XmlElement(name = "person")
	public void setListPerson(List<Person> listPerson) {
		this.listPerson = listPerson;
	}
	
	public int length() {
		int l = listPerson.size();
		
		return l;
	}
	
	public String getHoTen(int i) {
		String hoTen = listPerson.get(i).getHoten();
		
		return hoTen;
	}
	
	public Person getPersonFromIndex(int i) {
		Person p = listPerson.get(i);
		return p;
	}
	
}
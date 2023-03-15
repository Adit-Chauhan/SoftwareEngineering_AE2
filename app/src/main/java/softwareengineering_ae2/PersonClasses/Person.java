package softwareengineering_ae2.PersonClasses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
abstract class Person {
	private String name;
	private int age;
	
	public Person(String n, int a) {
		this.setName(n); this.setAge(a);
	}

	//getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
    
}

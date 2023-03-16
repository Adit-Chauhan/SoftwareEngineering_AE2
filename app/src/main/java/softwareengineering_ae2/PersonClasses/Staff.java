package softwareengineering_ae2.PersonClasses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
abstract class Staff extends Person{
	private UUID id;
	private String title;
	
	public Staff (String name, int age, String title) {
		super(name, age);
		this.setTitle(title);
		this.id = UUID.randomUUID();
	}

	//getter and setter

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}

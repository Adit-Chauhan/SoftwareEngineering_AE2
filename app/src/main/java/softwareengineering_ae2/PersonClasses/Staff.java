package softwareengineering_ae2.PersonClasses;

abstract class Staff extends Person{
	private int id;
	private String title;
	
	public Staff (Stirng name, int age, int id, String title) {
		super(name, age);
		this.id = id;
		this.title = title;
	}
	
	
	
}

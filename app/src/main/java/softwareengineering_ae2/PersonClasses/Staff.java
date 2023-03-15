

abstract class Staff extends Person{
	private int id;
	private String title;
	
	public Staff (String name, int age, int id, String title) {
		super(name, age);
		this.setId(id);
		this.setTitle(title);
	}

	//getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}

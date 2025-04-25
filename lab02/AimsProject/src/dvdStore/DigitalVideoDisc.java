package dvdStore;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	// Class variable to track total DVDs created
    private static int nbDigitalVideoDiscs = 0;
    
    // Instance variable for unique ID
    private int id;
	
	//setter & getter method
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	//constructor full attributes
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.director = director;
		this.length = length;
		// Increment the class variable and assign ID
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
	}
	//constructor 4 attributes
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	//constructor 3 attributes
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
}

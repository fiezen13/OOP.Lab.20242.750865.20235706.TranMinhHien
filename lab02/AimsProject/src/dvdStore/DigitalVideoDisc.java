package dvdStore;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
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
	
	//constructor full attributes
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.director = director;
		this.length = length;
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
	//constructor by title
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	
}

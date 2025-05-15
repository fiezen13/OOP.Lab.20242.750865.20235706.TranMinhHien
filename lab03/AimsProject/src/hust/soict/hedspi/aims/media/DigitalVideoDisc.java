package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    // Class variable to track total DVDs created
    

    @Override
    public String toString() {
        return "DVD: " + getTitle() + " - Category: " + getCategory() + " - Director: " + getDirector() + " - Length: " + getLength() + " mins - Cost: " + getCost() + " $";
    }

    // Constructor with title only
    public DigitalVideoDisc(String title) {
        super(title, "", 0.0f, 0, ""); 
    }

    // Constructor with full attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director); // Call Disc constructor
    }

    // Implement play() method
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    // New method: Để phục vụ cho tìm kiếm
    public boolean isMatch(String title) {
        return getTitle().equalsIgnoreCase(title);
    }
}
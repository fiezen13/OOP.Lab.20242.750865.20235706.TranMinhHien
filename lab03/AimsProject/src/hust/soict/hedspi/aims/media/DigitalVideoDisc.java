package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    // Class variable to track total DVDs created
    private static int nbDigitalVideoDiscs = 0;

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - Director: " + getDirector() + " - Length: " + getLength() + " mins - " + getCost() + " $";
    }

    // Constructor with title only
    public DigitalVideoDisc(int id, String title) {
        super(id, title, "", 0.0f, 0, ""); // Call Disc constructor
        nbDigitalVideoDiscs++;
    }

    // Constructor with full attributes
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost, length, director); // Call Disc constructor
        nbDigitalVideoDiscs++;
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
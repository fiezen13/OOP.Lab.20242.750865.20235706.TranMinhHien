package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

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
    public StringBuffer play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
            System.out.println("Category: " + this.getCategory()); 
            System.out.println("Director: " + this.getDirector());

            StringBuffer info = new StringBuffer("");
            info.append("Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength()+ "\n" + "Category: " + this.getCategory() +"\n" + "Cost: " + this.getCost());
            return info;
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
    
    // New method: Để phục vụ cho tìm kiếm
    public boolean isMatch(String title) {
        return getTitle().equalsIgnoreCase(title);
    }
}
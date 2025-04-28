package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aims {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();
        mediaList.add(new Book(1, "Book A", "Fiction", 100));
        mediaList.add(new CompactDisc(2, "CD A", "Music", 120, 60, "Director A", "Artist A"));
        mediaList.add(new DigitalVideoDisc(3, "DVD A", "Movies", "Director B", 90, 150));
        mediaList.add(new Book(4, "Book B", "Science", 80));

        // Sắp xếp theo title, sau đó cost
        Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Sorted by title, then cost:");
        for (Media media : mediaList) {
            System.out.println(media.getTitle() + " - " + media.getCost());
        }

        // Sắp xếp theo cost, sau đó title
        Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);
        System.out.println("\nSorted by cost, then title:");
        for (Media media : mediaList) {
            System.out.println(media.getTitle() + " - " + media.getCost());
        }
    }
}
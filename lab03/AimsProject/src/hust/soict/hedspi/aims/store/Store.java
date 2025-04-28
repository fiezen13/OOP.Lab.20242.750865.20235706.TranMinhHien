package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    // Method to add a media item to the store
    public void addMedia(Media media) {
        if (media != null) {
            itemsInStore.add(media);
            System.out.println("The media has been added to the store: " + media.getTitle());
        } else {
            System.out.println("Cannot add a null media to the store.");
        }
    }

    // Method to remove a media item from the store
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media has been removed from the store: " + media.getTitle());
        } else {
            System.out.println("The media is not available in the store.");
        }
    }

    // Method to display all media items in the store
    public void displayStore() {
        System.out.println("Items currently in the store:");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            for (Media media : itemsInStore) {
                System.out.println("- " + media.getId() + ". " + media.getTitle() + " (" + media.getCategory() + ") - " + media.getCost() + "$");
            }
        }
    }
}
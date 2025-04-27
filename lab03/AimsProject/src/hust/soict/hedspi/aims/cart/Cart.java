package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered;

    public Cart() {
        itemsOrdered = new ArrayList<>(); 
    }

    // Updated print method
    public void print() {
        System.out.println("************************CART************************");
        System.out.println("Ordered Items:");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty!");
        } else {
            float totalCost = 0.0f;
            for (int i = 0; i < itemsOrdered.size(); i++) {
                Media media = itemsOrdered.get(i);
                System.out.printf("%d. %s\n", (i + 1), media.toString());
                totalCost += media.getCost();
            }
            System.out.printf("Total cost: %.2f\n", totalCost);
        }
        System.out.println("***************************************************");
    }

    // Add a Media to the cart
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add more items.");
        } else {
            itemsOrdered.add(media);
            System.out.println("The item " + media.getTitle() + " has been added.");
        }
    }

    // Remove a Media from the cart
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The item " + media.getTitle() + " has been removed.");
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    // Calculate total cost
    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Search Media by ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found item: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }

    // Search Media by Title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found item: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
    }
}
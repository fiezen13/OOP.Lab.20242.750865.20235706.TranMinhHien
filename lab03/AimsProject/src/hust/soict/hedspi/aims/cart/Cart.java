package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public DigitalVideoDisc[] getItemsOrdered() {
        return this.itemsOrdered;
    }

    public void setItemsOrdered(DigitalVideoDisc[] itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public int getQtyOrdered() {
        return this.qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    // Updated print method
    public void print() {
        System.out.println("************************CART************************");
        System.out.println("Ordered Items:");
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty!");
        } else {
            float totalCost = 0.0f;
            for (int i = 0; i < qtyOrdered; i++) {
                DigitalVideoDisc disc = itemsOrdered[i];
                System.out.printf("%d. DVD - %s\n", (i + 1), disc.toString());
                totalCost += disc.getCost();
            }
            System.out.printf("Total cost: %.2f\n", totalCost);
        }
        System.out.println("***************************************************");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add more discs.");
        } else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc " + disc.getTitle() + " has been added.");
        }
    }

    // Overload 1: Add an array of DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (dvdList == null || dvdList.length == 0) {
            System.out.println("DVD list is empty!");
            return;
        }

        if (qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED) {
            System.out.println("Cannot add all discs. Out of capacity!");
        } else {
            for (DigitalVideoDisc dvd : dvdList) {
                itemsOrdered[qtyOrdered] = dvd;
                qtyOrdered++;
                System.out.println("The disc " + dvd.getTitle() + " has been added.");
            }
        }
    }

    // Overload 2: Add two DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
            System.out.println("Cannot add all discs. The cart will exceed capacity.");
            return;
        }
        itemsOrdered[qtyOrdered] = dvd1;
        qtyOrdered++;
        System.out.println("The disc " + dvd1.getTitle() + " has been added.");

        itemsOrdered[qtyOrdered] = dvd2;
        qtyOrdered++;
        System.out.println("The disc " + dvd2.getTitle() + " has been added.");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                found = true;
                System.out.println("The disc " + disc.getTitle() + " has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("Disc not found.");
        }
    }

    public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    // Search DVD by ID
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found DVD: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }

    // Search DVD by Title
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found DVD: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
    }
}
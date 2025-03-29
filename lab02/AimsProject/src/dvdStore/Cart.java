package dvdStore;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    
    public DigitalVideoDisc[] getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(DigitalVideoDisc[] itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add more discs.");
        } else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc "+ disc.getTitle()+ " has been added.");
        }
    }
    
    
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                // Dồn các phần tử phía sau lên
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
}

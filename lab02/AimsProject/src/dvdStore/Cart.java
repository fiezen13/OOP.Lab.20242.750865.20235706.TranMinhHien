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
    
    //Overload 1: Thêm một mảng DVD
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		// Kiểm tra mảng rỗng hoặc null
	    if (dvdList == null || dvdList.length == 0) {
	        System.out.println("DVD list is empty!");
	        return;
	    }
	    
		if(qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED) {
			System.out.println("Cannot add all disc. Out of capacity!");
		} else {
			for(int i = 0; i < dvdList.length; i++) {
				itemsOrdered[qtyOrdered] = dvdList[i];
				qtyOrdered++;
				System.out.println("The disc "+ dvdList[i].getTitle()+ " has been added.");
			}
		}
	}
	
	//Overload 2
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

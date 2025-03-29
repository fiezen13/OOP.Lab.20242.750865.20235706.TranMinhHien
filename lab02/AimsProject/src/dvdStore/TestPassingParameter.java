package dvdStore;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Tạo hai đối tượng DVD
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Gọi hàm swap để thử hoán đổi hai tham chiếu
        swap(jungleDVD, cinderellaDVD);

        // In tiêu đề sau khi gọi swap (sẽ không thay đổi)
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Gọi hàm changeTitle để đổi tiêu đề của jungleDVD thành "Cinderella"
        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        // In tiêu đề sau khi đổi tiêu đề (sẽ thay đổi)
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // Phương thức hoán đổi hai tham chiếu Object (không có tác dụng thực sự)
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // Phương thức đổi tiêu đề DVD
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();  // Lưu lại tiêu đề cũ
        dvd.setTitle(title);               // Đổi tiêu đề
        dvd = new DigitalVideoDisc(oldTitle); // Tạo đối tượng mới 
    }
}


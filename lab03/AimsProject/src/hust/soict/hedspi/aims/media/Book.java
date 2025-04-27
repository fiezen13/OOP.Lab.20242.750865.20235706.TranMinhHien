package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }
    
    @Override
    public String toString() {
        return "Book{" +
               "id=" + getId() +
               ", title='" + getTitle() + '\'' +
               ", category='" + getCategory() + '\'' +
               ", cost=" + getCost() +
               ", authors=" + authors +
               '}';
    }
    
    public void addAuthor(String authorName) {
        // Kiểm tra xem tác giả có null hoặc là chuỗi rỗng không
        if (authorName != null && !authorName.isEmpty()) {
            // Kiểm tra xem tác giả đã có trong danh sách chưa trước khi thêm
            if (!this.authors.contains(authorName)) {
                this.authors.add(authorName);
            }
        }
    }

    public void removeAuthor(String authorName) {
        // Kiểm tra xem tác giả có null không và có trong danh sách không trước khi xóa
        if (authorName != null && this.authors.contains(authorName)) {
            this.authors.remove(authorName);
        }
    }
}
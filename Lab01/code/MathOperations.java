import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhận dữ liệu từ người dùng
        Scanner scanner = new Scanner(System.in);
        
        // Nhập số thứ nhất dưới dạng chuỗi
        System.out.print("Enter the first number: ");
        String strNum1 = scanner.nextLine();
        
        // Nhập số thứ hai dưới dạng chuỗi
        System.out.print("Enter the second number: ");
        String strNum2 = scanner.nextLine();
        
        // Chuyển đổi từ String sang double
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        
        // Các phép toán
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        
        // Kiểm tra nếu số chia không phải là 0 trước khi thực hiện phép chia
        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.println("Quotient: " + quotient);
        } else {
            System.out.println("Division by zero is not allowed.");
        }

        // In kết quả
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        
        // Đóng đối tượng Scanner
        scanner.close();
    }
}

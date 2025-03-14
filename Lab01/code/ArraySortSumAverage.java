import java.util.Arrays;
import java.util.Scanner;

public class ArraySortSumAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng phần tử trong mảng
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Khởi tạo mảng
        int[] myArray = new int[n];

        // Nhập các phần tử của mảng
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            myArray[i] = scanner.nextInt();
        }

        // Sắp xếp mảng
        Arrays.sort(myArray);

        // Tính tổng và giá trị trung bình
        int sum = 0;
        for (int num : myArray) {
            sum += num;
        }
        double average = (double) sum / n;

        // In ra mảng đã sắp xếp
        System.out.println("Sorted array: " + Arrays.toString(myArray));

        // In ra tổng và giá trị trung bình
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + average);

        scanner.close();
    }
}

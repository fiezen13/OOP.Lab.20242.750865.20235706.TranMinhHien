import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập tháng và năm
        System.out.print("Enter the month: ");
        String month = scanner.nextLine();
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        // Kiểm tra năm nhuận
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Số ngày trong các tháng
        int daysInMonth = 0;
        switch (month) {
            case "January": case "Jan": case "Jan.": case "1": daysInMonth = 31; break;
            case "February": case "Feb": case "Feb.": case "2": daysInMonth = isLeapYear ? 29 : 28; break;
            case "March": case "Mar": case "Mar.": case "3": daysInMonth = 31; break;
            case "April": case "Apr": case "Apr.": case "4": daysInMonth = 30; break;
            case "May": case "May.": case "5": daysInMonth = 31; break;
            case "June": case "6": daysInMonth = 30; break;
            case "July": case "7": daysInMonth = 31; break;
            case "August": case "Aug": case "Aug.": case "8": daysInMonth = 31; break;
            case "September": case "Sep": case "Sep.": case "9": daysInMonth = 30; break;
            case "October": case "Oct": case "Oct.": case "10": daysInMonth = 31; break;
            case "November": case "Nov": case "Nov.": case "11": daysInMonth = 30; break;
            case "December": case "Dec": case "Dec.": case "12": daysInMonth = 31; break;
            default: 
                System.out.println("Invalid month."); 
                return;  // Kết thúc chương trình nếu tháng không hợp lệ
        }

        System.out.println("The number of days in " + month + " " + year + " is: " + daysInMonth);
        scanner.close();
    }
}


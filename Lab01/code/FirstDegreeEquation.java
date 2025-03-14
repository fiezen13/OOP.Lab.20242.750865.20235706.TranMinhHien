import java.util.Scanner;
public class FirstDegreeEquation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); //Tạo đối tuowgnj Scanner nhằm nhận dữ liệu từ bàn phím

        System.out.print("Enter the value of a: "); //in xâu mà con trỏ chuột vẫn ở trên dòng này
        double a = scanner.nextDouble();
        if(a==0){
            System.out.println("a cannot be zero. Please try agian!");
            scanner.close();
            return;
        }

        System.out.print("Enter the value of b: ");
        double b =  scanner.nextDouble();
        double x = -b/a; //Giải phuowgn trình y=ax+b;
        System.out.println("The solution of the problem is x= "+x);

        scanner.close(); //Đóng thư viện để không gây tràn
    }
}

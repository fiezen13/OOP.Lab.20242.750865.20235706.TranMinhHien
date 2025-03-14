import java.util.Scanner;
public class LinearEquation {
    public static void main(String[] args){
        //Tạo đối tượng scanner để nhận dối tượng từ bàn phím
        Scanner scanner = new Scanner(System.in);
        //Nhập các hệ số của phuowgn trình
        System.out.print("Enter a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Enter a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Enter b1: ");
        double b1 = scanner.nextDouble();

        System.out.print("Enter a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Enter a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Enter b2: ");
        double b2 = scanner.nextDouble();

        //Tinhd toán định thức D1, D2, D
        double D = a11*a22-a12*a21;
        double D1 = b1*a22-b2*a12;
        double D2= a11*b2-a21*b1;

        if(D==0){
            if(D1==0 && D2==0){
                System.out.println("The equation has many solutions.");
            } else{
                System.out.println("The equation has no solution.");
            }
        } else{
            double x1=D1/D;
            double x2=D2/D;
            System.out.println("The solution is x1 = "+ x1 +", x2 = "+x2);
        }

        scanner.close();
    }

}

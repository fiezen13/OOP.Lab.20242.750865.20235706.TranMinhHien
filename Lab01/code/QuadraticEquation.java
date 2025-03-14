import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the value of b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter the value of c: ");
        double c = scanner.nextDouble();

        double delta=b*b-4*a*c;
        if(delta>0){
            double x1=(-b+Math.sqrt(delta))/(2*a);
            double x2=(-b-Math.sqrt(delta))/(2*a);
            System.out.println("The two roots are x1="+x1+", x2="+x2);
        } else if(delta==0){
            double x=-b/(2*a);
            System.out.println("The two roots are x1=x2="+x);
        } else {
            System.out.println("The equation has no real roots.");
        }

        scanner.close();
    }
}

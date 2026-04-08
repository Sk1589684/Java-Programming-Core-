package Table;
import java.util.Scanner;

public class Table {

    public static void printTable(int num) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + "*" + i + "=" + (num * i));
        }
    }

    public static int factorial(int num) {
        int fact = 1;

        for (int i = 1; i <= num; i++) {
            fact *= i;
        }

        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter A Number:");
        int num = sc.nextInt();

        int result = factorial(num);
        System.out.println("Factorial Is " + result);

        printTable(num);
        sc.close();
    }
}
//package FirstPackage;
//class Calculator {
//    public static void main(String[] args) {
//        String Operator = args[0];
//        int num1 = Integer.parseInt(args[1]);
//        int num2 = Integer.parseInt(args[2]);
//        int num3 = 0;
//
//        switch (Operator) {
//            case "+":
//                num3 = num1 + num2;
//                break;
//            case "-":
//                num3 = num1 - num2;
//                break;
//            case "x":
//                num3 = num1 * num2;
//                break;
//            case "/":
//                num3 = num1 / num2;
//                break;
//            default:
//                System.out.println("Invalid operator");
//                return;
//        }
//
//        System.out.println("Calculation is: " + num3);
//    }
//}


package FirstPackage;

import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter operator (+, -, *, /): ");
        String operator = sc.next();

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        int result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
            case "x":
                result = num1 * num2;
                break;

            case "/":
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero!");
                    return;
                }
                result = num1 / num2;
                break;

            default:
                System.out.println("Invalid operator!");
                return;
        }

        System.out.println("Calculation is: " + result);
    }
}
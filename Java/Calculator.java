class Calculator {
    public static void main(String[] args) {
        String Operator = args[0];
        int num1 = Integer.parseInt(args[1]);
        int num2 = Integer.parseInt(args[2]);
        int num3 = 0;

        switch (Operator) {
            case "+":
                num3 = num1 + num2;
                break;
            case "-":
                num3 = num1 - num2;
                break;
            case "x":
                num3 = num1 * num2;
                break;
            case "/":
                num3 = num1 / num2;
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }

        System.out.println("Calculation is: " + num3);
    }
}
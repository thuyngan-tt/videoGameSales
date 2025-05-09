import java.util.Scanner;


public class testCode {
    static double add(double a, double b) {
        return a + b;
    }
    static double sub(double a, double b) {
        return a - b;
    }
    static double mul(double a, double b) {
        return a * b;
    }
    static double div(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println("Please enter two number then choose one of 4 options:\n 1: addition\n 2: subtraction\n 3: division\n 4: multiplication\n 5: Exit code ");
        Scanner sc = new Scanner(System.in);
        int enter = 0;

        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        do {
            if (enter == 0) {
                System.out.println("Please choose one of 4 options:\n 1: addition\n 2: subtraction\n 3: division\n 4: multiplication\n 5: Exit code ");
                int c = sc.nextInt();
                    if (c == 1) {
                        System.out.println("The addition of two numbers is " + add(a, b));
                    } else if (c == 2) {
                        System.out.println("The subtraction of two numbers  is " + sub(a, b));
                    } else if (c == 3) {
                        System.out.println("The division of two numbers is " + div(a, b));
                    } else if (c == 4) {
                        System.out.println("The multiplication of two numbers is " + mul(a, b));
                    }
                    else if (c == 5) {
                        break;
                    }
            }
            System.out.print("Enter 0 to continue, enter 6 to end: ");
            enter = sc.nextInt();
        } while (enter == 0);
    }
}







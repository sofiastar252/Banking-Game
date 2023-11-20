import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingGame {
    private static Map<String, Double> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Banking Game!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create an account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using the Banking Game. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void createAccount() {
        System.out.print("Enter your name: ");
        String name = scanner.next();
        accounts.put(name, 0.0);
        System.out.println("Account created successfully!");
    }

    private static void depositMoney() {
        System.out.print("Enter your name: ");
        String name = scanner.next();

        if (accounts.containsKey(name)) {
            System.out.print("Enter the amount to deposit: ");
            double amount = scanner.nextDouble();
            double currentBalance = accounts.get(name);
            accounts.put(name, currentBalance + amount);
            System.out.println("Deposit successful. New balance: " + accounts.get(name));
        } else {
            System.out.println("Account not found. Please create an account first.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter your name: ");
        String name = scanner.next();

        if (accounts.containsKey(name)) {
            System.out.print("Enter the amount to withdraw: ");
            double amount = scanner.nextDouble();
            double currentBalance = accounts.get(name);

            if (amount <= currentBalance) {
                accounts.put(name, currentBalance - amount);
                System.out.println("Withdrawal successful. New balance: " + accounts.get(name));
            } else {
                System.out.println("Insufficient funds. Please enter a valid amount.");
            }
        } else {
            System.out.println("Account not found. Please create an account first.");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter your name: ");
        String name = scanner.next();

        if (accounts.containsKey(name)) {
            System.out.println("Your current balance: " + accounts.get(name));
        } else {
            System.out.println("Account not found. Please create an account first.");
        }
    }
}

package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountDatabase database = new AccountDatabase();

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        src.Account account = database.getAccount(userId, pin);

        if (account != null) {
            System.out.println("Login successful!");
            boolean quit = false;
            while (!quit) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        account.displayTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient's user ID: ");
                        String recipientId = scanner.next();
                        src.Account recipientAccount = database.getAccount(recipientId);
                        if (recipientAccount == null) {
                            System.out.println("Recipient account not found.");
                        } else {
                            System.out.print("Enter amount to transfer: ");
                            double transferAmount = scanner.nextDouble();
                            account.transfer(recipientAccount, transferAmount);
                        }
                        break;
                    case 5:
                        quit = true;
                        System.out.println("Thank you for using the ATM!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid user ID or PIN. Please try again.");
        }
    }
}

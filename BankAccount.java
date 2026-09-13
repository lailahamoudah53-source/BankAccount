import java.util.Scanner;

public class BankAccount {

    // Private variables to protect account data
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Display account information
    public void displayAccountInfo() {
        System.out.println("\n==============================");
        System.out.println("       ACCOUNT INFORMATION");
        System.out.println("==============================");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: $" + balance);
    }

    // Deposit money
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");

        } else if (amount > balance) {
            System.out.println("Insufficient balance.");

        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
            System.out.println("New Balance: $" + balance);
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = input.nextLine();

        System.out.print("Enter initial balance: $");
        double initialBalance = input.nextDouble();

        // Create a BankAccount object
        BankAccount account = new BankAccount(name, initialBalance);

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("        SIMPLE BANK");
            System.out.println("==============================");
            System.out.println("1. Account Information");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    account.displayAccountInfo();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = input.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = input.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using Simple Bank!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 4);

        input.close();
    }
          }

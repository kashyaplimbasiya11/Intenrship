import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Not funds. Withdrawal failed.");
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);
        double amount;

        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                amount = scanner.nextDouble();
                if (userAccount.withdraw(amount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                }
                break;

            case 2:
                System.out.print("Enter deposit amount: ");
                amount = scanner.nextDouble();
                userAccount.deposit(amount);
                System.out.println("Deposit successful. Updated balance: " + userAccount.getBalance());
                break;

            case 3:
                System.out.println("Current balance: " + userAccount.getBalance());
                break;

            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class Atminterface {
    public static void main(String[] args) {
        // Creating a Bank Account with an initial balance of 1000
        BankAccount userAccount = new BankAccount(1000);

        // Creating an ATM object connected to the user's bank account
        ATM atmMachine = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Displaying the ATM menu
            atmMachine.displayMenu();

            // Taking user input for the selected option
            System.out.print("Enter option (1-4): ");
            int option = scanner.nextInt();

            // Processing the selected option
            atmMachine.processOption(option);
        }
    }
}

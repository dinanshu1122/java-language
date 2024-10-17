import java.util.Scanner;

class Bank {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public Bank(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
        } else {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        }
    }

    public void changeAccountHolderName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            System.out.println("Invalid name. Please enter a valid name.");
        } else {
            accountHolderName = newName;
            System.out.println("Name change successful. New account holder name: " + accountHolderName);
        }
    }

    public void requestPassbook() {
        System.out.println("Passbook requested for account: " + accountNumber);
    }

    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank account = new Bank("John Doe", "123456789", 1000.0);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Change Account Holder Name");
            System.out.println("4. Request Passbook");
            System.out.println("5. Display Account Details");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter new account holder name: ");
                    String newName = scanner.nextLine();
                    account.changeAccountHolderName(newName);
                    break;
                case 4:
                    account.requestPassbook();
                    break;
                case 5:
                    account.displayAccountDetails();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}

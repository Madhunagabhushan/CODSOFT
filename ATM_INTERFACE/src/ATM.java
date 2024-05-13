import java.util.Scanner;
class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

  public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful,New balance: " + balance);
    }

  public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal Successfull, New balance: " + balance);
        } else {
            System.out.println("there is no suffucient balance. Withdrawal failed, your current balance is: "+balance);
        }
    }
}


public class ATM {
    private Account account;


    public ATM(Account account) {
        this.account = account;
    }


    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void handleInput(int ch, Scanner scanner) {
        switch (ch) {
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Thank you for using ATM. Namasthe!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }


    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public static void main(String[] args) {
       Account userAccount = new Account(1000);
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int ch = scanner.nextInt();
            atm.handleInput(ch, scanner);
        }
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }
}

public class ATM extends JFrame {
    private Account account;
    private JLabel balanceLabel;
    private JTextField amountField;

    public ATM(Account account) {
        this.account = account;
        initializeGUI();
        updateBalanceLabel(); 
    }

    private void initializeGUI() {
        setTitle("ATM");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        balanceLabel = new JLabel("Current Balance: $" + account.getBalance());
        balanceLabel.setBounds(20, 20, 250, 25);
        add(balanceLabel);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(20, 60, 80, 25);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(100, 60, 150, 25);
        add(amountField);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(20, 100, 120, 25);
        checkBalanceButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateBalanceLabel();
                JOptionPane.showMessageDialog(null, "Current Balance: $" + account.getBalance());
            }
        });
        add(checkBalanceButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(150, 100, 100, 25);
        depositButton.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });
        add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(20, 130, 120, 25);
        withdrawButton.addActionListener(new ActionListener() {
       
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });
        add(withdrawButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(150, 130, 100, 25);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Current Balance: $" + account.getBalance());
    }

    private void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            account.deposit(amount);
            updateBalanceLabel();
            JOptionPane.showMessageDialog(this, "Deposit successful, new balance: $" + account.getBalance());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
        }
    }

    private void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            account.withdraw(amount);
            updateBalanceLabel();
            JOptionPane.showMessageDialog(this, "Withdrawal successful, new balance: $" + account.getBalance());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public static void main(String[] args) {
        Account userAccount = new Account(1000);
        ATM atm = new ATM(userAccount);
        atm.setVisible(true);
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

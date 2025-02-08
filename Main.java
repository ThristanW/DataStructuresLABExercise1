class BankAccount {
    private String accountNumber; // private for encapsulation
    private String accountName;
    protected double accountBalance; // double allows for decimal values

    // initializing account details
    public BankAccount(String accountNumber, String accountName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    // method to deposit money
    public void depositFunds(double amount) {
        // verifying if amount is positive
        if (amount > 0) {
            accountBalance += amount; // adding the amount to the balance
            System.out.println("$" + amount + " has been successfully added into account: " + accountName);
        } else {
            System.out.println("Amount must be positive");
        }
    }

    // method to withdraw money
    public void withdrawFunds(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("$" + amount + " has been successfully withdrawn from account: " + accountName);
        } else {
            System.out.println("Invalid amount withdrawal. Check amount or balance.");
        }
    }

    // method to show balance
    public void showBalance() {
        System.out.println("Balance: $" + accountBalance);
    }
}

class SavingsAccount extends BankAccount {
    private double annualInterestRate; // interest rate for a savings account per year

    // initializing savings account details
    public SavingsAccount(String accountNumber, String accountName, double accountBalance, double annualInterestRate) {
        super(accountNumber, accountName, accountBalance);
        this.annualInterestRate = annualInterestRate;
    }

    // method to calculate interest
    public void calculateInterest() {
        double interest = accountBalance * annualInterestRate / 100;
        accountBalance += interest; // applying interest
        System.out.println("Interest earned: $" + interest);
    }
}

class LebronJames {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("LJ6969", "Lebron James", 100000, 2);
        savings.showBalance();
        savings.depositFunds(1000);
        savings.withdrawFunds(6900);
        savings.calculateInterest();
        savings.showBalance();
    }
}
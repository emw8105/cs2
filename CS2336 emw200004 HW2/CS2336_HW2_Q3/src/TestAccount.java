import java.util.*;

class Account {

    // class variables and default value initialization
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated = new Date(); // use built in java Date class

    // construct an account object with default parameters
    Account() {

    }
    // construct an account object
    Account(int id_, double balance_) {
        id = id_;
        balance = balance_;
    }

    // accessor methods
    int getId() {
        return id;
    }
    double getBalance() {
        return balance;
    }
    double getAnnualInterestRate() {
        return annualInterestRate;
    }
    Date getDateCreated() {
        return dateCreated;
    }

    // mutator methods
    void setId(int newID) {
        id = newID;
    }
    void setBalance(double newBalance) {
        balance = newBalance;
    }
    void setAnnualInterestRate(double newInterest) {
        annualInterestRate = newInterest / 100; // convert from percent to decimal
    }

    // other methods
    double getMonthlyInterestRate() {
        return annualInterestRate / 12; // split yearly rate into monthly
    }
    double getMonthlyInterest() {
        return balance * getMonthlyInterestRate(); // monthly interest formula
    }
    void withdrawal (double wthdrw) {
        balance = balance - wthdrw;
    }
    void deposit (double depo) {
        balance = balance + depo;
    }
}

public class TestAccount {
    public static void main(String[] args) {
        Account account1 = new Account(1122, 20000);
        account1.setAnnualInterestRate(4.5);
        account1.withdrawal(2500);
        account1.deposit(3000);

        System.out.println("Balance: " + account1.getBalance());
        System.out.println("Monthly Interest: " + account1.getMonthlyInterest());
        System.out.println("Date Created: " + account1.getDateCreated());
    }
}
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
        balance -= wthdrw;
    }
    void deposit (double depo) {
        balance += depo;
    }
}

public class ATM {
    public static void main(String[] args) {

        Account[] accntArr = new Account[10];
        int balance = 100;
        for (int i = 0; i < accntArr.length; i++) {
            accntArr[i] = new Account();
            accntArr[i].setId(i); // set id's to 0-9 for array indexes 0-9
            accntArr[i].setBalance(balance); // set each account's balance to 10
        }

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an id: "); // prompt user for id #
            int id = input.nextInt(); // get next integer entered by user

            while (id < 0 || id > 9) { // loop until id is valid
                System.out.print("Invalid, please enter a correct id: "); // prompt user for id #
                id = input.nextInt(); // get next integer entered by user
            }

            int menuChoice = 0;
            do {
                System.out.println("\n1: check balance\n2: withdrawal\n3: deposit\n4: exit");
                System.out.println("Enter a choice: ");
                menuChoice = input.nextInt();

                if (menuChoice == 1) { // check the balance of the given account
                    System.out.println("The balance is " + accntArr[id].getBalance());
                }
                else if (menuChoice == 2) { // withdrawal from the account
                    System.out.println("Enter an amount to withdraw: ");
                    double wthdrw = input.nextDouble();
                    accntArr[id].withdrawal(wthdrw);
                }
                else if (menuChoice == 3) { // deposit to the account
                    System.out.println("Enter an amount to deposit: ");
                    double depo = input.nextDouble();
                    accntArr[id].deposit(depo);
                }
            }while (menuChoice != 4);
            // once exiting, program loops back to ask for a new id
        }
    }
}
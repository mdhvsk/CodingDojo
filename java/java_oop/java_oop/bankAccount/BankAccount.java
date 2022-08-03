package bankAccount;

public class BankAccount {
    
    private double checkingBalance;
    private double savingsBalance;
    private static int numOfAccounts = 0;
    private static double totalMoney = 0;
    private long accountNumber;

    public BankAccount(){
        numOfAccounts++;
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public String depositMoney(String account, double amount){
        if(account == "checking") {
            this.checkingBalance += amount;
        }
        else if (account == "savings"){
            this.savingsBalance += amount;
        }
        else {
            return "Invalid account";
        }

        totalMoney += amount;
        return "Transaction Completed";
    }

    public String withdrawMoney(String account, double amount){
        if(account == "checking" && amount <= checkingBalance) {
            this.checkingBalance -= amount;
        }
        else if (account == "savings" && amount <= savingsBalance){
            this.savingsBalance -= amount;
        }
        else {
            return "Invalid transaction";
        }

        totalMoney -= amount;
        return "Transaction Completed";
    }

    public void displayAccountBalances(){
        System.out.printf("Checking account balance: %s \n", this.checkingBalance);
        System.out.printf("Savings account balance: %s \n", this.savingsBalance);
    }

    
}

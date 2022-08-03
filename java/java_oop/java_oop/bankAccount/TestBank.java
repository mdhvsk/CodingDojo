package bankAccount;

public class TestBank {
    
    public static void main(String[] args){
        BankAccount account1 = new BankAccount();

        System.out.println(account1.depositMoney("checking", 150));
        System.out.println(account1.getCheckingBalance());

    }

}

package pl.sampleproject.bankApp;

public class Main {
    public static void main(String[] args) {
        TransactionRepository transactionRepository = new TransactionRepository();
        Account account = new Account(transactionRepository);
        account.printStatement();
        try{
        account.deposit(450);
        account.deposit(150);
        account.withdraw(150);
        account.printStatement();
        } catch (NotEnoughFundsOnAccountException e) {
            System.err.println("Not Enough funds on your account.");
        }
    }
}

package pl.sampleproject.bankApp;

import java.time.LocalDate;
import static java.lang.Math.abs;

public class Account {

    private double balance;
    private TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += abs(amount);
            Transaction transaction = new Transaction(LocalDate.now(), amount, this.balance);
            transactionRepository.add(transaction);
        }
    }
    public void withdraw(int amount) {
        if(amount <= this.balance) {
            this.balance -= abs(amount);
        Transaction transaction = new Transaction(LocalDate.now(), amount, this.balance);
        transactionRepository.add(transaction);
        } else {
            throw new NotEnoughFundsOnAccountException();
        }
    }

    public void printStatement() {
        System.out.println(balance);
        System.out.println(transactionRepository.transactionList);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

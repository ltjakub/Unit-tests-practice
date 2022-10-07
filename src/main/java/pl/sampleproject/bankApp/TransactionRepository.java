package pl.sampleproject.bankApp;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    public List<Transaction> transactionList = new ArrayList<>();

    public void add(Transaction transaction) {
        transactionList.add(transaction);
    }

}

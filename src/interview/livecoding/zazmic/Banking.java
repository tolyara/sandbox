package interview.livecoding.zazmic;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {

    private int balance;

    String deposit(int money) {
        balance += money;
        return "Depositing $" + money;
    }

    String withdraw(int money) {
        String result = "Withdrawing $" + money;
        if (money > balance) {
            return result + " (Insufficient Balance)";
        }
        balance -= money;
        return result;
    }

    public int getBalance() {
        return balance;
    }
}


class Transaction {

    private Account account;
    private List<String> transactions;

    public Transaction(Account account) {
        this.account = account;
    }

    public List<String> getTransaction() {
        return transactions;
    }

    public void deposit(int money) {
        transactions.add(account.deposit(money));
    }

    public void withdraw(int money) {
        transactions.add(account.withdraw(money));
    }
}

public class Banking {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Account ACCOUNT = new Account();
    private static final Transaction TRANSACTION = new Transaction(ACCOUNT);

    public static void main(String[] args) throws InterruptedException {
        int threadsCount = Integer.parseInt(SCANNER.nextLine());
        Thread[] threads = new Thread[threadsCount];

        int expectedTransactionsCount = 0;
        for (int i = 0; i < threadsCount; i++) {
            int transactionsCount = Integer.parseInt(SCANNER.nextLine());
            expectedTransactionsCount += transactionsCount;

            threads[i] = new Thread(new TransactionRunnable(TRANSACTION, transactionsCount));
        }

        for (int i = 0; i < threadsCount; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threadsCount; i++) {
            threads[i].join();
        }

        List<String> transactions = TRANSACTION.getTransaction();

        if (transactions.size() != expectedTransactionsCount) {
            System.out.println("Wrong Answer");
        } else {
            boolean correct = true;
            for (String transaction: transactions) {
                if (transaction == null) {
                    correct = false;

                    break;
                }
            }

            if (!correct) {
                System.out.println("Wrong Answer");
            } else {
                int balance = ACCOUNT.getBalance();

                if (balance < 0) {
                    System.out.println("Wrong Answer");
                } else {
                    for (String transaction: transactions) {
                        System.out.println(transaction);
                    }

                    System.out.println("Balance $" + balance);
                }
            }
        }
    }

}


/*
 * Create the Account and Transaction classes here.
 */
class TransactionRunnable implements Runnable {
    private static final SecureRandom RANDOM_GENERATOR = new SecureRandom();
    private final Transaction transaction;
    private final int transactionsCount;

    public TransactionRunnable(Transaction transaction, int transactionsCount) {
        this.transaction = transaction;
        this.transactionsCount = transactionsCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.transactionsCount; i++) {
            int transactionType = RANDOM_GENERATOR.nextInt() % 2;
            int money = RANDOM_GENERATOR.nextInt(100) + 1;

            if (transactionType == 0) {
                this.transaction.deposit(money);
            } else {
                this.transaction.withdraw(money);
            }
        }
    }
}




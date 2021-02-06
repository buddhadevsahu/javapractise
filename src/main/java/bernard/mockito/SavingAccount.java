package bernard.mockito;

public class SavingAccount {

    public double withdraw(double amount) {
        System.out.println("withdrawing");
    double balance=getBalance();
    balance = balance -amount;
    updateBalanceInDatabase();
    return balance;
    }

    protected void updateBalanceInDatabase() {
        System.out.println("updating balance in DB");
    }

    public double getBalance() {

        System.out.println("getting balance from DB");
        return 50000;
    }
    public double getMaturityAmount(double amount, int years){
        System.out.println("computing maturity amount");
        return 10000;
    }
}

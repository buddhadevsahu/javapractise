package bernard.mockito;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class SavingAccountTest {

    @Test
    public void testSBAcountWithdrawalWhenBalanceIs5000INR(){
        SavingAccount account = new SavingAccount();

        SavingAccount accountSpy = spy(account);
        doReturn(5000.00).when(accountSpy).getBalance();
        doNothing().when(accountSpy).updateBalanceInDatabase();
        doReturn(5000.00).doReturn(4000.00).when(accountSpy).getMaturityAmount(10.00,5);
       // doReturn(5000.00).when(accountSpy).getMaturityAmount(10.00,5);

        //act
        double actualBalance = account.withdraw(5000.00);
        double expectedBalance=45000.00;

        assertEquals(expectedBalance,actualBalance,0.001);
    }
}

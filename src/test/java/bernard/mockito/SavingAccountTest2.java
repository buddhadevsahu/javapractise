package bernard.mockito;

import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SavingAccountTest2 {

    @Spy
    private SavingAccount accountSpy;

    public SavingAccountTest2(){
        //this is to initialize spy for each tests
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void test1(){
        doReturn(5000.00).when(accountSpy).getBalance();
        doNothing().when(accountSpy).updateBalanceInDatabase();
        doReturn(5000.00).doReturn(4000.00).when(accountSpy).getMaturityAmount(10.00,5);
       // doReturn(5000.00).when(accountSpy).getMaturityAmount(10.00,5);

        //act
        double actualBalance = accountSpy.withdraw(5000.00);
        double expectedBalance=45000.00;

        assertEquals(expectedBalance,actualBalance,0.001);
        reset(accountSpy); //reseting all the stored information.
    }

    @Test
    public void test2(){
 /*       doReturn(5000.00).when(accountSpy).getBalance();
        doNothing().when(accountSpy).updateBalanceInDatabase();
        doReturn(5000.00).doReturn(4000.00).when(accountSpy).getMaturityAmount(10.00,5);
        // doReturn(5000.00).when(accountSpy).getMaturityAmount(10.00,5);

        //act
     */
        double actualBalance = accountSpy.withdraw(5000.00);
        double expectedBalance=45000.00;

        assertEquals(expectedBalance,actualBalance,0.001);
    }
}

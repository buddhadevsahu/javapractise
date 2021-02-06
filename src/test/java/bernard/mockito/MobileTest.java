package bernard.mockito;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class MobileTest {

    @Test
    public void testMobilePowerOnwhenCameraWorksFine(){

        //mocking :faking camera functionality with dummy object
        ICamera mockedCamera = mock(ICamera.class);

        //stubbing : hard codding method of dependant method.
        when(mockedCamera.On()).thenReturn(true);

        Mobile mobile = new Mobile(mockedCamera);
        //act
        boolean actualStatus= mobile.powerOn();
        boolean expectedStatus=true;
        assertEquals(expectedStatus,actualStatus);
        //checking the poweron method intereacted with camera one time
        verify(mockedCamera,times(1)).On();
    }

    @Test (expected=CameraCommunicationException.class)
    public void testMobilePowerOnwhenCameraFails(){

        //mocking :faking camera functionality with dummy object
        ICamera mockedCamera = mock(ICamera.class);

        //stubbing : hard codding method of dependant method.
        when(mockedCamera.On()).thenReturn(true);

        Mobile mobile = new Mobile(mockedCamera);
        //act
        boolean actualStatus= mobile.powerOn();
     }
}

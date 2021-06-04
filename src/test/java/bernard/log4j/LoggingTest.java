package bernard.log4j;

import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingTest {

    //private static final Logger logger = LogManager.getLogger("HelloWorld");

    // Logger instance named "MyApp".
    private static final Logger logger = LogManager.getLogger(LoggingTest.class);
    public static void main(String[] args) {
        logger.trace("Entering application.");
        Bar bar = new Bar();
        if (!bar.doIt()) {
            logger.error("Didn't do it.");
        }
        logger.trace("Exiting application.");
    }

    private void method1(){
        logger.trace("inside, method 1");
    }

    @Test
    public void test1(){
        method1();
    }

}

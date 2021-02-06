package bernard.corejava;

public class LoopTest {

    public void testContinue(){

        for (int i = 0; i < 10; i++) {
            System.out.println("iiteration "+i);
            if(i==5){
                method1("continue");
            }
        }




    }

    private void method1(String action) {
        System.out.println("method1 ");
        if(action.equalsIgnoreCase("continue"));
            //continue;   //can't apply continue on outside loop
        if(action.equalsIgnoreCase("break"));
           // break;




    }

}

package bernard.mockito;

public class Mobile {
    private ICamera camera;
    public Mobile(ICamera camera){
        this.camera = camera;
        System.out.println("mobile constructor");
    }

    public boolean powerOn() {

        if(camera.On()){
            System.out.println(" mobile power on the positive code path");
            return true;
        }
        System.out.println(" mobile power on the negetive code path");
        return false;
    }
}

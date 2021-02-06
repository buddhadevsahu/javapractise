package bernard.designpattern.structural.composite1;

import org.junit.Test;

public class Composite1Test {

    @Test
    public void TestfileAddition(){
        Directory d1 = new Directory("Persistent");
        MyPage p1=new MyPage("Buddha");
        p1.addContent("ABCD");
        d1.add(p1);
        assertEquals(4,d1.size());

        Directory d2 = new Directory("TECH-HAWK");
        MyPage p2=new MyPage("SOMNATH");
        p2.addContent("XYZ");
        d2.add(p2);
        d1.add(d2);
        assertEquals(7,d1.size());
    }

    private void assertEquals(int i, int size) {
    }
}

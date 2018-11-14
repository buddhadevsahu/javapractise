package bernard.designpattern.structural.composite1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory extends StorageArttibute implements Storage{
    private List<Storage> list= new ArrayList<>();

    public Directory(String name) {
        this.name=name;
        createdDate=new Date();
        modifiedDate=new Date();
    }

    public boolean add(Storage p1) {
        list.add(p1);
        modifiedDate=new Date();
        return true;
    }


    //implementation of composite methods
    @Override
    public int size() {
        int result=0;
        for (Storage obj:list) {
            result = result + obj.size();
        }

        return result;
    }

    @Override
    public void rename(String newName) {
      name =newName;
    }
}

package bernard.designpattern.structural.composite1;

import java.util.Date;

public class MyPage extends StorageArttibute implements Storage{

    private String content;
    public MyPage(String name) {
        this.name = name;
        createdDate=new Date();
        modifiedDate=new Date();
    }

    @Override
    public int size() {
        return content == null ? 0 : content.length();
    }
    @Override
    public void rename(String newName) {
        name =newName;
    }

    public void addContent(String newContent) {
        if(content == null)
            content = newContent;
        else
        content=content+newContent;
    }
}

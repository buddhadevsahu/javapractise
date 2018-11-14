package bernard.misc;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

//fixed size LRU cache
//where Least recent used cache will be removed first
public class  LRUCache<K,V> extends LinkedHashMap<K,V>  implements Serializable {

    private int capacity;

    public LRUCache(int initialCapacity, float loadFactor, int size) {
        super(initialCapacity, loadFactor,true);
        this.capacity = size;
    }

    public LRUCache(int size){
        super(size,0.75f,true);
        this.capacity =size;
    }

    public LRUCache(){
        super(10,0.75f,true);
        this.capacity =10;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

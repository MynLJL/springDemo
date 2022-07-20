package collectionstudy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapLearn {
    public static void main(String[] args) {
        // initialCapacity=9, capacity=16  threshold=12
        Map<Integer, Integer> map = new HashMap<>(9);
        Map<Integer, Integer> conMap = new ConcurrentHashMap<>(1);
        map.put(null, null);
        map.put(1, 2);
        //conMap.put(null, null);
        conMap.put(1, 2);
        System.out.println(map.size());
    }
}

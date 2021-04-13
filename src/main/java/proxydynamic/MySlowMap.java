package proxydynamic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MySlowMap implements Map<String, String> {

    // delegate to innerMap
    private final Map<String, String> innerMap = new HashMap<>();

    @Override
    public int size() {
        return innerMap.size();
    }

    @Override
    public boolean isEmpty() {
        return innerMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return innerMap.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return innerMap.containsValue(o);
    }

    @Override
    public String get(Object o) {
        return innerMap.get(o);
    }

    @Override
    public String put(String s, String s2) {
        try {
            // override with sleep action to slow down put action
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return innerMap.put(s, s2);
    }

    @Override
    public String remove(Object o) {
        return innerMap.remove(o);
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> map) {
        innerMap.putAll(map);
    }

    @Override
    public void clear() {
        innerMap.clear();
    }

    @Override
    public Set<String> keySet() {
        return innerMap.keySet();
    }

    @Override
    public Collection<String> values() {
        return innerMap.values();
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return innerMap.entrySet();
    }
}

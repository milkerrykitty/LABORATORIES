package lapa5;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl<V> implements HashMap<String, V>
{
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;

    private static class Pair<V> {
        private final String key;
        private V value;

        private Pair(String key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final ArrayList<LinkedList<Pair<V>>> table;
    public HashMapImpl() {
        table = new ArrayList<>(TABLE_SIZE);
        for (int i = 0; i < TABLE_SIZE; i++) {
            table.add(new LinkedList<>());
        }
    }
    /**
     * Алгоритм хеширования строк.
     *
     * @param value ключ, по которому сохранится значение в хэш-таблицу
     * @return значение хэша
     */
    private long hashByString(String value)
    {
        long hash = 0;
        for (Character ch : value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }
        return hash;
    }

    @Override
    public void put(String key, V value)
    {
     int index = (int) hashByString(key);
     LinkedList<Pair<V>> bucket = table.get(index);
        for (Pair<V> pair : bucket) {
            if (pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }
        bucket.add(new Pair<>(key, value));
    }

    @Override
    public V getValue(String key)
    {
        V value = null;
        int index = (int) hashByString(key);
        LinkedList<Pair<V>> bucket = table.get(index);
        for (Pair<V> pair : bucket) {
            if (pair.key.equals(key)) {
                value = pair.value;
            }
        }
        return value;
    }

    @Override
    public V delete(String key)
    {
        V remove = null;
        int index = (int) hashByString(key);
        LinkedList<Pair<V>> bucket = table.get(index);
        for (Pair<V> pair : bucket) {
            if (pair.key.equals(key)) {
                remove = pair.value;
                bucket.remove(pair);
                break;
            }
        }
        return remove;
    }
}

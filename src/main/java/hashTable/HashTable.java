package hashTable;

import java.util.ArrayList;

public class HashTable<K, V> {
    private ArrayList<Entry<K, V>> buckets;

    private int capacity;

    private int size;

    public HashTable() {
        buckets = new ArrayList<>();
        capacity = 16;
        size = 0;

        for (int i = 0; i < capacity; i++) {
            buckets.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }

    public void add(K key, V value) {

        int numBucket = getBucketIndex(key);

        Entry<K, V> head = buckets.get(numBucket);

        while (head != null) {
            if (key.equals(head.key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        Entry<K, V> newEntry = new Entry<>(key, value);
        head = buckets.get(numBucket);
        newEntry.next = head;
        buckets.set(numBucket, newEntry);

        if ((1.0 * size) / capacity >= 0.75f) {
            ArrayList<Entry<K, V>> temp = buckets;
            buckets = new ArrayList<>();
            capacity = capacity * 2;
            size = 0;

            for (int i = 0; i < capacity; i++) {
                buckets.add(null);
            }

            for (Entry<K, V> entry : temp) {
                while (entry != null) {
                    add(entry.key, entry.value);
                    entry = entry.next;
                }
            }
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> entry = buckets.get(index);
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }
}

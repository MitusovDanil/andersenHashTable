package hashTable;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class HashTableTest {
    private HashTable<String, Integer> hashTable;

    @BeforeEach
    public void setup() {
        hashTable = new HashTable<>();

    }

    @Test
    @DisplayName("Тест метода HashTable.isEmpty()")
    void isEmpty() {
        assertTrue(hashTable.isEmpty(), "Для вызова метода: hashTable.isEmpty()");
    }

    @Test
    @DisplayName("Тест метода HashTable.add()")
    void add() {
        hashTable.add("Jon", 15);
        assertEquals(1, hashTable.size(), "Для вызова метода: hashTable.add()");
    }

    @Test
    @DisplayName("Тест метода HashTable.size()")
    void size() {
        assertEquals(0, hashTable.size(), "Для вызова метода: hashTable.size()");
        hashTable.add("Jo", 10);
        hashTable.add("J", 15);
        hashTable.add("Jon", 25);
        assertEquals(3, hashTable.size(), "Для вызова метода: hashTable.size()");
    }

    @Test
    @DisplayName("Тест метода HashTable.get()")
    void get() {
        hashTable.add("Jon", 15);
        assertEquals(15, hashTable.get("Jon"), "Для вызова метода: hashTable.get()");
    }
}
package com.byzantander;

import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BankMessage<K,V> implements Serializable {
    private BankRequestType type;
    private K key;
    private V value;
    private HashSet<K> keySet;
    private int size;

    public BankMessage() { // não é preciso mexer aqui
    }

    public static <K,V> byte[] toBytes(BankMessage<K,V> message) throws IOException {
        // ....
    }

    @SuppressWarnings("unchecked")
    public static <K,V> BankMessage<K,V> fromBytes(byte[] rep) throws IOException, ClassNotFoundException {
        // ....
    }

    public BankRequestType getType() {
        return this.type;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    @SuppressWarnings("unchecked")
    public void setKey(Object key) {
        this.key = (K) key;
    }

    // ....

}
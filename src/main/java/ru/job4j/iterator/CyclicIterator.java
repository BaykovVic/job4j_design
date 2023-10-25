package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T> {

    private List<T> data;
    private int pointer;

    public CyclicIterator(List<T> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (pointer == data.size()) {
            pointer = 0;
        }
        return pointer < data.size();
    }

    @Override
    public T next() {
        while (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data.get(pointer++);
    }
}
package ru.job4j.generic;

import ru.job4j.generic.Base;

public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    void delete(String id);

    T findById(String id);
}
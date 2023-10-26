package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int pointer = 0;
        while (source.hasNext()) {
            if (pointer == nodes.size()) {
                pointer = 0;
            }
            nodes.get(pointer++).add(source.next());
        }
    }
}
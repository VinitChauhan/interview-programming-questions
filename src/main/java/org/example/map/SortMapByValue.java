package org.example.map;

import java.util.*;

public class SortMapByValue {
    public static void main(String[] args) {
        Map<String,Integer> mp = new HashMap<>();
        mp.put("test3",60);
        mp.put("test2",10);
        mp.put("test5",30);
        mp.put("test4",50);
        mp.put("test1",20);
        mp.put("test6",40);
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();// preserve the insert order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(mp.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for ( Map.Entry<String, Integer> stringIntegerEntry : list ) {
            sortedMap.put(stringIntegerEntry.getKey(),stringIntegerEntry.getValue());
        }
        sortedMap.forEach((s, integer) -> System.out.print(" "+s+"-"+integer));
    }
}

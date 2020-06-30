package com.shcherbinina.cinemapark.utility;

import java.util.*;
import java.util.stream.Collectors;

public class Utility {
    public static List<Integer> getIntArrayFromString(String str) {
        return Arrays.stream(str.split(","))
                .map(String::trim).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }

    public static List<Integer> getDifferenceList(List<Integer> list1, List<Integer> list2) {
        if(list1 == null && list2 == null) throw new IllegalArgumentException();
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        List<Integer> list = new ArrayList<>();
        for(int val: list1) {
            if(list2.contains(val)) continue;

            list.add(val);
        }
        return  list;
    }
}

package com.otus.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CollectionUtils {
    public static long equalElementsCountConsideringIndex(List<Integer> left, List<Integer> right) {
        if (nonNull(left, right)) {
            int count = 0;
            for (int i = 0; i < left.size(); i++) {
                if (left.get(i).equals(right.get(i)))
                    count++;
            }

            return count;
        }

        return 0;
    }

    static boolean nonNull(Object... objects) {
        return Arrays.stream(objects).allMatch(Objects::nonNull);
    }
}

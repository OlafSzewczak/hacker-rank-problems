package pl.oszewczak.problemsolving.equalizethearray;

import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayEqualizerImpl implements ArrayEqualizer{

    public int getRemoveCountTillMostFrequentElementOnly(@NonNull List<Integer> numbers) {
        Map<Integer, Integer> elementToCount = new HashMap<>();
        for (int num : numbers) {
            elementToCount.put(num, elementToCount.getOrDefault(num, 0) + 1);
        }
        return numbers.size() - getMostFrequentElementCount(elementToCount);
    }

    public int getMostFrequentElementCount(Map<Integer, Integer> elementToCount) {
        return elementToCount.values().stream()
                .mapToInt(Integer::valueOf)
                .max()
                .orElse(0);
    }

}

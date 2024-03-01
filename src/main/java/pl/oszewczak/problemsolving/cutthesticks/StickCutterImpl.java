package pl.oszewczak.problemsolving.cutthesticks;

import java.util.*;

public class StickCutterImpl implements StickCutter {

    public List<Integer> getSticksSizesBeforeEachCutIteration(List<Integer> sticks) {
        if(sticks == null) {
            throw new NullPointerException("Sticks list cannot be null");
        }

        if(containNegative(sticks)) {
            throw new IllegalArgumentException("Invalid input: negative stick lengths not allowed");
        }
        sticks = new ArrayList<>(sticks);
        List<Integer> sticksBeforeEachIteration = new ArrayList<>();
        while(!allEqual(sticks)) {
            sticksBeforeEachIteration.add(sticks.size());
            cut(sticks);
        }
        sticksBeforeEachIteration.add(sticks.size());
        return sticksBeforeEachIteration;
    }

    private void cut(List<Integer> sticks) {
        int shortest = Collections.min(sticks);
        ListIterator<Integer> sticksIterator = sticks.listIterator();
        while(sticksIterator.hasNext()) {
            int next = sticksIterator.next();
            if(next > shortest) {
                sticksIterator.set(next - shortest);
            } else if(next == shortest) {
                sticksIterator.remove();
            }
        }
    }

    private boolean containNegative(List<Integer> sticks) {
        return sticks.stream().anyMatch(stick -> stick < 0);
    }

    private boolean allEqual(List<Integer> sticks) {
        return sticks.stream().allMatch(stick -> Objects.equals(stick, sticks.getFirst()));
    }
}

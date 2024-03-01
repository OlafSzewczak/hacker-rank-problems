package pl.oszewczak.problemsolving.cutthesticks;

import java.util.*;

public class StickCutterImpl implements StickCutter {

    public List<Integer> getSticksSizesBeforeEachCutIteration(List<Integer> sticks) {
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

    private boolean allEqual(List<Integer> sticks) {
        return sticks.stream().allMatch(stick -> Objects.equals(stick, sticks.getFirst()));
    }
}

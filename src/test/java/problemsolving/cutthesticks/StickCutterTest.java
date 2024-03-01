package problemsolving.cutthesticks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.oszewczak.problemsolving.cutthesticks.StickCutter;
import pl.oszewczak.problemsolving.cutthesticks.StickCutterImpl;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StickCutterTest {

    private StickCutter stickCutter;

    @BeforeEach
    public void setUp() {
        stickCutter = new StickCutterImpl();
    }


    @Test
    public void shouldReturnEqual() {
        assertEquals(List.of(6,4,2,1), stickCutter.getSticksSizesBeforeEachCutIteration(List.of(5, 4, 4, 2, 2, 8)));
    }

    @Test
    public void shouldReturnListWithPassedListSizeForListWithEqualElements() {
        List<Integer> equalElements = List.of(2, 2, 2, 2, 2, 2);
        assertEquals(List.of(equalElements.size()), stickCutter.getSticksSizesBeforeEachCutIteration(equalElements));
    }

    @Test
    public void shouldReturnListWithZeroForEmptyList() {
        assertEquals(List.of(0), stickCutter.getSticksSizesBeforeEachCutIteration(Collections.emptyList()));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForListWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> stickCutter.getSticksSizesBeforeEachCutIteration(List.of(1, 2, -3, 4, 5)));
    }

    @Test
    public void shouldThrowNullPointerExceptionForNull() {
        assertThrows(NullPointerException.class, () -> stickCutter.getSticksSizesBeforeEachCutIteration(null));
    }

}

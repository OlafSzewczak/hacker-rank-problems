package problemsolving.equalizethearray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.oszewczak.problemsolving.equalizethearray.ArrayEqualizer;
import pl.oszewczak.problemsolving.equalizethearray.ArrayEqualizerImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayEqualizerTest {

    private ArrayEqualizer arrayEqualizer;

    @BeforeEach
    public void setUp() {
        arrayEqualizer = new ArrayEqualizerImpl();
    }

    @Test
    public void shouldReturnEqual() {
        assertEquals(3, arrayEqualizer.getRemoveCountTillMostFrequentElementOnly(List.of(3, 2, 3, 4, 1, 3)));
    }

    @Test
    public void shouldReturnZeroForEmptyList() {
        assertEquals(0, arrayEqualizer.getRemoveCountTillMostFrequentElementOnly(List.of()));
    }

    @Test
    public void shouldReturnZeroForListWithSameElementDuplicates() {
        assertEquals(0, arrayEqualizer.getRemoveCountTillMostFrequentElementOnly(List.of(2, 2, 2, 2, 2)));
    }

    @Test
    public void shouldReturnNullPointerException() {
        assertThrows(NullPointerException.class, () -> arrayEqualizer.getRemoveCountTillMostFrequentElementOnly(null));
    }

}

package arithmetic.binarysearch.test;

import arithmetic.binarysearch.BinarySearchIteration;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class BinarySearchIterationTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfTableEmpty() {
        int[] table = {};
        BinarySearchIteration.search(table, 3);
    }

    @Test
    public void shouldNotThrowExceptionIfTableNotEmpty() {
        int[] table = {1};
        BinarySearchIteration.search(table, 1);
    }

    @Test
    public void shouldReturnErrorValueIfElementOutOfRightBound() {
        int[] table = {1, 2, 3};
        int searchedValue = BinarySearchIteration.search(table, 4);
        assertThat(-1, equalTo(searchedValue));
    }

    @Test
    public void shouldReturnErrorValueIfNegativeElementOutLeftBound() {
        int[] table = {1, 2, 3};
        int searchedValue = BinarySearchIteration.search(table, -3);
        assertThat(-1, equalTo(searchedValue));
    }


    @Test
    public void shouldReturnProperResultForNegativeValue() {
        int[] table = {-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int searchedValue = BinarySearchIteration.search(table, -2);
        assertThat(-2, equalTo(searchedValue));
    }

    @Test
    public void shouldReturnProperResultForPositiveValue() {
        int[] table = {-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int searchedValue = BinarySearchIteration.search(table, 3);
        assertThat(3, equalTo(searchedValue));
    }

    @Test //TODO reversed sorted
    public void shouldReturnProperResultForReversedSorting() {
        int[] table = {8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3};
        int searchedValue = BinarySearchIteration.search(table, 3);
        assertThat(3, equalTo(searchedValue));
    }
}
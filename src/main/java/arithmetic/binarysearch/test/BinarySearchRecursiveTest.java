package arithmetic.binarysearch.test;

import arithmetic.binarysearch.BinarySearchRecursive;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class BinarySearchRecursiveTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfTableEmpty() {
        int[] table = {};
        BinarySearchRecursive.search(table, 3);
    }

    @Test
    public void shouldNotThrowExceptionIfTableNotEmpty() {
        int[] table = {1};
        BinarySearchRecursive.search(table, 1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfElementOutOfRightBound() {
        int[] table = {1, 2, 3};
        BinarySearchRecursive.search(table, 4);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfNegativeElementOutLeftBound() {
        int[] table = {1, 2, 3};
        BinarySearchRecursive.search(table, -1);
    }

    @Test
    public void shouldNotThrowExceptionIfElementOutOfBound() {
        int[] table = {1, 2, 3};
        BinarySearchRecursive.search(table, 3);
    }

    @Test
    public void shouldReturnProperResultForNegativeValue() {
        int[] table = {-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int searchedValue = BinarySearchRecursive.search(table, -2);
        assertThat(-2, equalTo(searchedValue));
    }

    @Test
    public void shouldReturnProperResultForPositiveValue() {
        int[] table = {-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int searchedValue = BinarySearchRecursive.search(table, 3);
        assertThat(3, equalTo(searchedValue));
    }

/*    @Test TODO reversed sorted
    public void shouldReturnProperResultForReversedSorting() {
        int[] table = {8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3};
        int searchedValue = BinarySearchRecursive.search(table, 3);
        assertThat(3, equalTo(searchedValue));
    }*/
}
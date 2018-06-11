package arithmetic.binarysearch.test;

import arithmetic.binarysearch.BinarySearchIteration;
import arithmetic.binarysearch.BinarySearchRecursive;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinarySearchRecursiveTest {
    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionIfTableEmpty() {
        BinarySearchIteration.search(null, 3);
    }

    @Test
    public void shouldNotThrowExceptionIfTableNotEmpty() {
        int[] table = {};
        int searchedValue = BinarySearchRecursive.search(table, 1);
        assertThat(searchedValue, equalTo(-1)); // TODO change places
    }

    @Test
    public void shouldReturnErrorValueIfElementOutOfRightBound() {
        int[] table = {1, 2, 3};
        int searchedValue = BinarySearchRecursive.search(table, 4);
        assertThat(searchedValue, equalTo(-1));
    }

    @Test
    public void shouldReturnErrorValueIfNegativeElementOutLeftBound() {
        int[] table = {1, 2, 3};
        int searchedValue = BinarySearchRecursive.search(table, -3);
        assertThat(searchedValue, equalTo(-1));
    }

    @Test
    public void shouldReturnProperResultForNegativeValue() {
        int[] table = {-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int searchedValue = BinarySearchRecursive.search(table, -2);
        assertThat(searchedValue, equalTo(1));
    }

    @Test
    public void shouldReturnProperResultForPositiveValue() {
        int[] table = {-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int searchedValue = BinarySearchRecursive.search(table, 3);
        assertThat(searchedValue, equalTo(6));
    }

    @Test
    public void shouldFindInFirstAttempt() {
        int[] table = {1, 2, 3, 4, 5 };
        int searchedValue = BinarySearchRecursive.search(table, 3);
        assertThat(searchedValue,equalTo( 2));
    }

    @Test
    public void shouldFindFirstElement() {
        int[] table = {1, 2, 3, 4, 5};
        int searchedValue = BinarySearchRecursive.search(table, 1);
        assertThat(searchedValue,equalTo( 0));
    }

    @Test
    public void shouldFindLastElement() {
        int[] table = {1, 2, 3, 4, 5 };
        int searchedValue = BinarySearchRecursive.search(table, 5);
        assertThat(searchedValue,equalTo( 4));
    }
}
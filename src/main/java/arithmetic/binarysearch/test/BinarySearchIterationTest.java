package arithmetic.binarysearch.test;

import arithmetic.binarysearch.BinarySearchIteration;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class BinarySearchIterationTest {
    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionIfTableEmpty() {
        BinarySearchIteration.search(null, 3);
    }

    @Test
    public void shouldNotThrowExceptionIfTableNotEmpty() {
        int[] table = {};
        int searchedValue = BinarySearchIteration.search(table, 1);
        assertThat(-1, equalTo(searchedValue)); // TODO change places
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
        assertThat(1, equalTo(searchedValue));
    }

    @Test
    public void shouldReturnProperResultForPositiveValue() {
        int[] table = {-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int searchedValue = BinarySearchIteration.search(table, 3);
        assertThat(6, equalTo(searchedValue));
    }



    @Test
    public void shouldFindInFirstAttempt() {
        int[] table = {1, 2, 3, 4, 5 };
        int searchedValue = BinarySearchIteration.search(table, 3);
        assertThat(searchedValue,equalTo( 2));
    }

    @Test
    public void shouldFindFirstElement() {
        int[] table = {1, 2, 3, 4, 5};
        int searchedValue = BinarySearchIteration.search(table, 1);
        assertThat(searchedValue,equalTo( 0));
    }

    @Test
    public void shouldFindLastElement() {
        int[] table = {1, 2, 3, 4, 5 };
        int searchedValue = BinarySearchIteration.search(table, 5);
        assertThat(searchedValue,equalTo( 4));
    }

}
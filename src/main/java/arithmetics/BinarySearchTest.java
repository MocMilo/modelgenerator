package arithmetics;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfTableEmpty() {
        int[] table = {};
        BinarySearch.search(table, 3);
    }

    @Test
    public void shouldNotThrowExceptionIfTableNotEmpty() {
        int[] table = {1};
        BinarySearch.search(table, 3);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfElementOutOfBound() {
        int[] table = {1,2,3};
        BinarySearch.search(table, 4);
    }

    @Test
    public void shouldNotThrowExceptionIfElementOutOfBound() {
        int[] table = {1,2,3};
        BinarySearch.search(table, 3);
    }


   /* @Test
    public void shouldIfTableEmpty() {
        int[] table = {1,2,3,4,5,6,7,8};
        int searchedValue = BinarySearch.search(table, 3);
        assertThat(3, equalTo(searchedValue) );
    }*/


}
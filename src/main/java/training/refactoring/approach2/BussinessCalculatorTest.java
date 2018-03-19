package training.refactoring.approach2;

import org.junit.Test;
import training.refactoring.approach1.BussinesCalculator;

import java.util.Optional;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class BussinessCalculatorTest {

    private Optional<Integer> integerA;
    private Optional<Integer> integerB;
    private StringBuilder stringBuilder = new StringBuilder("testValue");

    @Test
    public void shouldReturnDouble() {

        StringBuilder referenceValue = new StringBuilder("testValue");
        StringBuilder testValue = new StringBuilder("testValue");


        integerA = Optional.ofNullable(5);
        integerB = Optional.ofNullable(10);
        int threshold = 11;
        Double testDouble = BussinesCalculator.calculate(integerA, integerB, threshold, referenceValue);
        System.out.println(testDouble);
        assertThat(testDouble, equalTo(0.0));
        assertThat(testDouble, not(nullValue()));
        assertThat(referenceValue.toString(), equalTo(testValue.toString()));

    }
    @Test
    public void shouldReturnDoubleCase2() {

        integerA = Optional.ofNullable(10);
        integerB = Optional.ofNullable(5);
        int threshold = 11;
        Double testDouble = BussinesCalculator.calculate(integerA, integerB, threshold, stringBuilder);
        System.out.println(testDouble);
        assertThat(testDouble, equalTo(0.0));
        assertThat(testDouble, not(nullValue()));
    }

    @Test
    public void shouldReturnDoubleCase3() {

        integerA = Optional.ofNullable(5);
        integerB = Optional.ofNullable(10);
        int threshold = 7;
        Double testDouble = BussinesCalculator.calculate(integerA, integerB, threshold, stringBuilder);
        System.out.println(testDouble);
        assertThat(testDouble, equalTo(0.0));
        assertThat(testDouble, not(nullValue()));
    }

    @Test
    public void shouldReturnDoubleCase4() {

        integerA = Optional.ofNullable(5);
        integerB = Optional.ofNullable(10);
        int threshold = 2;
        Double testDouble = BussinesCalculator.calculate(integerA, integerB, threshold, stringBuilder);
        System.out.println(testDouble);
        assertThat(testDouble, equalTo(50.0));
        assertThat(testDouble, not(nullValue()));
    }

    @Test
    public void shouldReturnDoubleCase5() {
        integerA = Optional.ofNullable(10);
        integerB = Optional.ofNullable(5);
        int threshold = 2;
        Double testDouble = BussinesCalculator.calculate(integerA, integerB, threshold, stringBuilder);
        System.out.println(testDouble);
        assertThat(testDouble, equalTo(25.0));
        assertThat(testDouble, not(nullValue()));
    }




}
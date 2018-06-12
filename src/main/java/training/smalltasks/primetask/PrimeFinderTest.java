package training.smalltasks.primetask;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrimeFinderTest {




    @Test
    public void isPrimeNumber() {
        System.out.println("test");
        int checkedNumber = 9;
        List<Integer> pirmes = new PrimeFinder().getPrimeDividorsForNumber(checkedNumber);

        System.out.println("prime numbers for number "+ checkedNumber);
        pirmes.forEach(x ->{
            System.out.println(x);
        });
    }


    @Test
    public void getDividors() {
/*        System.out.println("dividors result ");
        List<Integer> dividors = new PrimeFinder().getDividors(6);
        System.out.println("dividors size"+ dividors);*/

    }

    @Test
    public void idPrime(){
        System.out.println("is prime result: 5");
        System.out.println(new PrimeFinder().isPrime(5));


        assertThat(new PrimeFinder().isPrime(2), equalTo(true));
        assertThat(new PrimeFinder().isPrime(3), equalTo(true));
        assertThat(new PrimeFinder().isPrime(4), equalTo(false));
        assertThat(new PrimeFinder().isPrime(5), equalTo(true));
        assertThat(new PrimeFinder().isPrime(6), equalTo(false));
        assertThat(new PrimeFinder().isPrime(7), equalTo(true));
        assertThat(new PrimeFinder().isPrime(8), equalTo(false));
        assertThat(new PrimeFinder().isPrime(9), equalTo(false));

    }
}
package Stakeout;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StakeoutTest {
    @Test
    public void returnZero_whenInputIsNull() {
        assertEquals(0, Stakeout.maxReturn(null));
    }

    @Test
    public void returnMax_whenInputHasOneElement() {
        int[] a = {100};
        assertEquals(100, Stakeout.maxReturn(a));
    }

    @Test
    public void returnMax_whenEvenNumbersOfValues() {
        int[] a = {1, 1, 1, 1};
        assertEquals(2, Stakeout.maxReturn(a));
    }

    @Test
    public void returnMax_whenOddNumbersOfValues() {
        int[] a = {1, 1, 1, 1, 1};
        assertEquals(3, Stakeout.maxReturn(a));
    }

    @Test
    public void skipLargerValue_ifAdjacentValueIsEvenLarger() {
        int[] a = {1, 20, 21, 1, 1};
        assertEquals(23, Stakeout.maxReturn(a));
    }

    @Test
    public void skipTwoValues_ifTwoLargerNumberAreSeperatedByTwo() {
        int[] a = {1, 100, 4, 2, 100, 0, 1, 2};
        assertEquals(202, Stakeout.maxReturn(a));
    }

    @Test
    public void example1() {
        int[] a = {20, 10, 50, 5, 1};
        assertEquals(71, Stakeout.maxReturn(a));
    }

    @Test
    public void example2() {
        int[] a = {20, 50, 10, 1, 5};
        assertEquals(55, Stakeout.maxReturn(a));
    }
}

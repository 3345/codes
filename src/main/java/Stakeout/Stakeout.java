package Stakeout;

public class Stakeout {
    /**
     * @param homeValues non-negative {@code int[]}
     * @return the maximum sum of a subset of elements in {@code int[]} homeValues
     *  where any non of elements in the subset can be adjacent.
     *  Return 0 if {@code int[]} homeValues is null.
     */
    public static int maxReturn(int[] homeValues) {
        if (homeValues == null)
            return 0;
        if (homeValues.length == 1)
            return homeValues[0]; //assuming home value cannot be negative

        int[] profits = new int[homeValues.length];
        profits[0] = homeValues[0];
        profits[1] = Math.max(homeValues[0], homeValues[1]);

        for (int i = 2; i < homeValues.length; i++) {
            profits[i] = Math.max(homeValues[i] + profits[i - 2], profits[i - 1]);
        }

        return profits[homeValues.length - 1];
    }

}

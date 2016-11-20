package leetcode;

/**
 * Created by fyl on 11/20/16.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int len = height.length;

        if (len < 2) {
            return 0;
        }

        int[] highLeft = new int[height.length];
        int[] highRight = new int[height.length];

        highLeft[0] = height[0];

        for(int i = 1; i < len; i ++) {
            highLeft[i] = Math.max(highLeft[i - 1], height[i - 1]);
        }

        highRight[len - 1] = height[len - 1];

        for(int i = len - 2; i > -1; i --) {
            highRight[i] = Math.max(highRight[i + 1], height[i + 1]);
        }

        int sum = 0;

        for (int i = 1; i < len - 1; i ++) {
            int min = Math.min(highLeft[i], highRight[i]);
            if (height[i] < min) {
                sum += min - height[i];
            }
        }

        return sum;

    }
}

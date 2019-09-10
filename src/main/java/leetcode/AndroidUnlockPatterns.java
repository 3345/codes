package leetcode;

import org.junit.Test;

public class AndroidUnlockPatterns {
    boolean[] v = new boolean[10];
    int res = 0;
    int min;
    int max;

    public int numberOfPatterns(int m, int n) {
        min = m; int max = n;
        dfs(0, 0);
        return res;
    }

    private void dfs(int cur, int count) {
        if (count >= min && count <= max) {
            res++;
        }
        if (count == max) return;

        for (int i = 1; i <= 9; i++) {
            if (i == cur) continue;
            if (!v[i]) {
                int mid = (cur + i)/2;
                if ((cur + i)%2 == 0 && !v[mid]) continue;
                v[i] = true;
                dfs(i, count+1);
                v[i] = false;
            }
        }
    }

    @Test
    public void test() {
        numberOfPatterns(1,1);
    }

}

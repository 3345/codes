package leetcode;

/**
 * Created by fyl on 10/31/17.
 */
public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(times));
    }

    public static void main(String[] args) {
        int b = 1000;
        int mtd = 12;
        int mtt = 60;
        System.out.println(new PoorPigs().poorPigs(b, mtd, mtt));
    }
}

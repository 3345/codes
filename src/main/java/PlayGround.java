import org.junit.Test;

/**
 * Created by fyl on 8/2/19.
 */
public class PlayGround {
    @Test
    public void test() {
        int[] a= new int[]{1,1};
        int[] b= new int[]{0,0};
        int[] p = a;
        a = b;
        a = p;
        System.out.print(a);
    }
}

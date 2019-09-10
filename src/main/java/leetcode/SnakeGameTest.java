package leetcode;

import org.junit.Test;

public class SnakeGameTest {
    @Test
    public void test() {
        SnakeGame game = new SnakeGame(2,2, new int[][]{{0,1}});
        game.move("R");
        game.move("D");




    }
}

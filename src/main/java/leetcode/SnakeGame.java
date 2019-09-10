package leetcode;


import org.junit.Test;

import java.util.LinkedList;

public class SnakeGame {

    /**
     * Initialize your data structure here.
     *
     * @param width - screen width
     * @param height - screen height
     * @param food - A list of food positions
     * E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    LinkedList<int[]> snake = new LinkedList<>();
    int[][] food;
    int[][] world;
    int w;
    int h;

    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        snake.add(new int[]{0, 0});
        this.world = new int[height][width];
        this.world[0][0] = 1;
        this.w = width;
        this.h = height;
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String dir) {
        int[] head = snake.getLast();
        int[] nextHead = new int[]{head[0], head[1]};
        if (dir.equals("U")) {
            nextHead[0] += -1;
        }
        if (dir.equals("L")) {
            nextHead[1] += -1;
        }
        if (dir.equals("R")) {
            nextHead[1] += 1;
        }
        if (dir.equals("D")) {
            nextHead[0] += 1;
        }
        if (nextHead[0] < 0 || nextHead[0] >= h || nextHead[1] < 0 || nextHead[1] >= w || world[nextHead[0]][nextHead[1]] == 1) {
            return -1;
        }
        world[nextHead[0]][nextHead[1]] = 1;
        snake.addLast(nextHead);
        if (snake.size() - 2 >= food.length || !isSame(food[snake.size() - 2], nextHead)) {
            int[] tail = snake.removeFirst();
            world[tail[0]][tail[1]] = 0;
        }
        return snake.size() - 1;
    }

    private boolean isSame(int[] a, int[] b) {
        return (a[0] == b[0]) && (a[1] == b[1]);
    }
}


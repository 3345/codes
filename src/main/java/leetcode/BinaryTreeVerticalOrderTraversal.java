package leetcode;

import java.util.*;

/**
 * Created by fyl on 12/31/16.
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> levelQ = new LinkedList<>();

        nodeQ.add(root);
        levelQ.add(0);

        while (!nodeQ.isEmpty()) {
            TreeNode n = nodeQ.poll();
            int level = levelQ.poll();

           if (map.containsKey(level)) {
                map.get(level).add(n.val);
            } else {
                map.put(level, new ArrayList<>(Arrays.asList(n.val)));
            }

            if (n.left != null) {
                nodeQ.add(n.left);
                levelQ.add(level - 1);
            }

            if (n.right != null) {
                nodeQ.add(n.right);
                levelQ.add(level + 1);
            }
        }


        int min = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            min = Math.min(min, key);
        }

        for (int i = min; i < map.size() + min; i ++) {
            list.add(map.get(i));
        }

        return list;
    }

}

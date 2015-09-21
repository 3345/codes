package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yulai on 9/20/15.
 */
public class BSTIterator {
    List<TreeNode> chain = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        
        while (node != null) {
            chain.add(0, node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(chain.size() == 0);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ret = chain.remove(0);

        TreeNode node = ret.right;
        while (node != null) {
            chain.add(0, node);
            node = node.left;
        }

        return ret.val;
    }
}

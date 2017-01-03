package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fuyul on 1/3/2017.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        solve(ans, root, new ArrayList<Integer>());
        return ans;
    }

    public void solve(List<String> paths, TreeNode node, List<Integer> curPath) {
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<Integer> iter = curPath.iterator();
            while (iter.hasNext()) {
                sb.append(iter.next());
                sb.append("->");
            }
            sb.append(node.val);
            paths.add(sb.toString());
            return;
        }

        curPath.add(node.val);
        if (node.left != null) {
            solve(paths, node.left, curPath);
        }
        if (node.right != null) {
            solve(paths, node.right, curPath);
        }
        curPath.remove(curPath.size() - 1);
    }

}
